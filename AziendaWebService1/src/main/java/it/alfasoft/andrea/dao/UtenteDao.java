package it.alfasoft.andrea.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernateUtil.HibernateUtil;
import it.alfasoft.andrea.bean.Utente;

public class UtenteDao {
	
	// 1 Create
	public boolean creaUtente(Utente u){
		boolean res=false;
		
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();
		
		session.persist(u);
		
		 tx.commit();
		 res=true;
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		
		return res;
		
	}
	
	//2a Read con Id
	public Utente leggiUtenteConId(long id_u){
		Utente u=null;
		
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();
		
		u=session.get(Utente.class,id_u);
		
		 tx.commit();
		
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		
		return u;
		
	}
	
	//2b Read con username
		public Utente leggiUtenteConUser(String username){
			Utente u=null;
			
			Session session =HibernateUtil.openSession();
			Transaction tx=null;

			try{
			tx=session.getTransaction();
			tx.begin();
			
			Query query = session.createQuery("from Utente where username=:userInserito");
			query.setString("userInserito", username);
			u =(Utente) query.uniqueResult();
			
			 tx.commit();
			
			}catch(Exception ex){
				tx.rollback();
			}finally{
				session.close();
			}
			
			return u;
			
		}
		
		//2c Read con nome e cognome
				public Utente leggiUtenteConNomeCognome(String nome, String cognome){
					Utente u=null;
					
					Session session =HibernateUtil.openSession();
					Transaction tx=null;

					try{
					tx=session.getTransaction();
					tx.begin();
					
					Query query = session.createQuery("from Utente where nome=:nomeInserito &&"
							+ "cognome=:cognomeInserito");
					query.setString("nomeInserito", nome);
					query.setString("cognomeInserito", cognome);
					
					u =(Utente) query.uniqueResult();
					
					 tx.commit();
					
					}catch(Exception ex){
						tx.rollback();
					}finally{
						session.close();
					}
					
					return u;
					
				}
				
				//2c Read tutti Utenti
				@SuppressWarnings("unchecked")
				public List<Utente> leggiTuttiUtenti(){
					List<Utente> utenti=new ArrayList<Utente>();
					
					Session session =HibernateUtil.openSession();
					Transaction tx=null;

					try{
					tx=session.getTransaction();
					tx.begin();
					
					Query query = session.createQuery("from Utente"); 
					
					utenti =query.list();
					
					 tx.commit();
					
					}catch(Exception ex){
						tx.rollback();
					}finally{
						session.close();
					}
					
					return utenti;
					
				}
				
				//3 Update
				public boolean aggiornaUtente(Utente u){
					
					boolean res=false;
					Session session =HibernateUtil.openSession();
					Transaction tx=null;

					try{
					tx=session.getTransaction();
					tx.begin();
					
					session.update(u);
					
					 tx.commit();
					 res=true;
					
					}catch(Exception ex){
						tx.rollback();
					}finally{
						session.close();
					}
					
					return res;
					
				}
				
				//4 Delete
				public boolean eliminaUtente(Utente u){
					
					boolean res=false;
					Session session =HibernateUtil.openSession();
					Transaction tx=null;

					try{
					tx=session.getTransaction();
					tx.begin();
					
					session.delete(u);
					
					 tx.commit();
					 res=true;
					
					}catch(Exception ex){
						tx.rollback();
					}finally{
						session.close();
					}
					
					return res;
					
				}

				public boolean eliminaUtenteConId(long id_u) {
					boolean res=false;
					Session session =HibernateUtil.openSession();
					Transaction tx=null;

					try{
					tx=session.getTransaction();
					tx.begin();
					
					session.delete(id_u);
					
					 tx.commit();
					 res=true;
					
					}catch(Exception ex){
						tx.rollback();
					}finally{
						session.close();
					}
					
					return res;
				
				}
	
}
