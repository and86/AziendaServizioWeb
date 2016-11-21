package it.alfasoft.andrea.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernateUtil.HibernateUtil;
import it.alfasoft.andrea.bean.BustaPaga;
import it.alfasoft.andrea.bean.Dipendente;

public class BustaPagaDao {

	// 1 creazione busta paga
	public boolean creaBustaPaga(BustaPaga b) {
		boolean res = false;

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();

			session.persist(b);

			res = true;
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}

		return res;
	}

	// 2a Read con Id
	public BustaPaga leggiBustaConId(long id_b) {
		BustaPaga b = null;

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();

			b = session.get(BustaPaga.class, id_b);

			tx.commit();

		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}

		return b;

	}

	// 2c Read all
	@SuppressWarnings("unchecked")
	public List<BustaPaga> leggiTutteBustePaga(Dipendente d) {

		List<BustaPaga> buste = new ArrayList<BustaPaga>();
		long id = d.getId_utente();

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();

			Query query = session
					.createQuery("from BustaPaga where dipendente_id_utente=:idInserito");
			query.setLong("idInserito", id);

			buste = query.list();

			tx.commit();

		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}

		return buste;

	}
	
	@SuppressWarnings("unchecked")
	public List<BustaPaga> leggiTutteBustePaga() {
		
		List<BustaPaga> buste = new ArrayList<BustaPaga>();
		
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();

			Query query = session
					.createQuery("from BustaPaga");

			buste = query.list();

			tx.commit();

		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}

		return buste;
		
	}

	// 4 Delete
	public boolean eliminaBustaPaga(BustaPaga b) {
		boolean res = false;

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();

			session.delete(b);

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
