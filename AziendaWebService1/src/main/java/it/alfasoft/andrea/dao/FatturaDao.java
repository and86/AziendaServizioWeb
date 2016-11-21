package it.alfasoft.andrea.dao;

import hibernateUtil.HibernateUtil;
import it.alfasoft.andrea.model.Fattura;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FatturaDao {

	// 1 Creazione fattura
	public boolean creaFattura(Fattura f) {
		boolean res = false;

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();

			session.persist(f);

			res = true;
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}

		return res;
	}

	// 2a Read con Codice
	public Fattura leggiFatturaConCodice(String codice) {
		Fattura f = null;

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();

			Query query = session
					.createQuery("from Fattura where codice=:codiceInserito");
			query.setString("codiceInserito", codice);
			f = (Fattura) query.uniqueResult();

			tx.commit();

		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}

		return f;

	}

	// 2b Read con Id
	public Fattura leggiFatturaConId(long id) {
		Fattura f = null;

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();

			f = session.get(Fattura.class, id);

			tx.commit();

		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}

		return f;

	}

	// 2c Read all
	@SuppressWarnings("unchecked")
	public List<Fattura> leggiTutteFatture() {

		List<Fattura> fatture = new ArrayList<Fattura>();

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();

			Query query = session.createQuery("from Fattura");

			fatture = query.list();

			tx.commit();

		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}

		return fatture;

	}

	public List<Fattura> leggiFatturaConData(Date start, Date end) {
		List<Fattura> fatture = new ArrayList<Fattura>();

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();

			Query query = session.createQuery("From Fattura as f where f.emissione between :start and :end ");
			query.setDate("start", start);
			query.setDate("end",end);
			
			fatture = query.list();

			tx.commit();

		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}

		return fatture;
	}

	// 4 Delete
	public boolean eliminaFattura(Fattura f) {
		boolean res = false;

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();

			session.delete(f);

			tx.commit();
			res = true;

		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}

		return res;

	}

	// 5 Update
	public boolean aggiornaFattura(Fattura f) {
		boolean res = false;

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();

			session.update(f);

			tx.commit();
			res = true;

		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}

		return res;

	}

}
