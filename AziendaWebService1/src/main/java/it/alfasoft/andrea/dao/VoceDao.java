package it.alfasoft.andrea.dao;


import it.alfasoft.andrea.model.Rubrica;
import it.alfasoft.andrea.model.Voce;

import java.util.List;




import hibernateUtil.HibernateUtil;




import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class VoceDao {

	// 1- Create

	public boolean creaVoce(Voce v) {
		boolean res = false;

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {

			tx = session.getTransaction();
			tx.begin();

			session.persist(v);

			tx.commit();
			res = true;
		} catch (Exception ex) {

			tx.rollback();

		} finally {
			session.close();
		}

		return res;

	}

	// 2 - Read (con Id voce)
	public Voce leggiVoceConId(long v_id) {
		
		Voce v = null;
		
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {

			tx = session.getTransaction();

			tx.begin();

			v = session.get(Voce.class, v_id);

			tx.commit();

		} catch (Exception ex) {

			tx.rollback();

		} finally {
			session.close();
		}

		return v;

	}

	// 3 - Read (con id_rubrica, nome,cognome)
	public Voce leggiVoce(long id_rubrica,String nome, String cognome) {
		Voce v = null;
		
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {

			tx = session.getTransaction();

			tx.begin();

			Query query = session
					.createQuery("from Voce where Rubrica_id_Rubrica=:idRubricaInserito and"
							+ " nome=:nomeInserito and"
							+ "cognome=:cognomeInserito");

			query.setLong("idRubricaInserito", id_rubrica);
			query.setString("nomeInserito", nome);
			query.setString("cognomeInserito", cognome);
			v = (Voce) query.uniqueResult();
			
			tx.commit();

		} catch (Exception ex) {

			tx.rollback();

		} finally {
			session.close();
		}

		return v;

	}
	
	public Voce leggiVoce(long id_rubrica,long id_voce) {
		Voce v = null;
		
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {

			tx = session.getTransaction();

			tx.begin();

			Query query = session
					.createQuery("from Voce where Rubrica_id_Rubrica=:idRubricaInserito and"
							+ "id_voce=idVoceInserito");

			query.setLong("idRubricaInserito", id_rubrica);
			query.setLong("idVoceInserito", id_voce);
			v = (Voce) query.uniqueResult();
			
			tx.commit();

		} catch (Exception ex) {

			tx.rollback();

		} finally {
			session.close();
		}

		return v;

	}
	
	// 4 - Read (con id_rubrica)
	
	
	@SuppressWarnings("unchecked")
	public List<Voce> leggiTutteLeVoci(Rubrica r) {
			List<Voce> listaVoci=null;
			
			Session session = HibernateUtil.openSession();
			Transaction tx = null;

			try {

				tx = session.getTransaction();

				tx.begin();

				Query query = session
						.createQuery("from Voce where Rubrica_id_Rubrica=:idRubricaInserito");

				query.setLong("idRubricaInserito", r.getId_Rubrica());
				listaVoci=query.list();
				
				tx.commit();

			} catch (Exception ex) {

				tx.rollback();

			} finally {
				session.close();
			}

			return listaVoci;

		}

	// 5 - Update
	public boolean aggiornaVoce(Voce v) {
		boolean res = false;

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {

			tx = session.getTransaction();
			tx.begin();

			session.update(v);

			tx.commit();
			res = true;
		} catch (Exception ex) {

			tx.rollback();

		} finally {
			session.close();
		}

		return res;

	}

	// 6- Delete

	public boolean eliminaVoce(Voce v) {
		boolean res = false;

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {

			tx = session.getTransaction();
			tx.begin();

			session.delete(v);

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
