package it.alfasoft.andrea.dao;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernateUtil.HibernateUtil;
import it.alfasoft.andrea.bean.Admin;


public class AdminDao {
	
	public boolean creaAdmin(Admin a){
		boolean res=false;
		
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();
		
		session.persist(a);
		
		 res=true;
		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		
		
		return res;
	}
	
	//2a Read con Id
		public Admin leggiAdminConId(long id_a){
			Admin a =null;
			
			Session session =HibernateUtil.openSession();
			Transaction tx=null;

			try{
			tx=session.getTransaction();
			tx.begin();
			
			a=session.get(Admin.class,id_a);
			
			 tx.commit();
			
			}catch(Exception ex){
				tx.rollback();
			}finally{
				session.close();
			}
			
			return a;
			
		}
		
		//2b Read con username
			public Admin leggiAdminConUser(String username){
				Admin a =null;
				
				Session session =HibernateUtil.openSession();
				Transaction tx=null;

				try{
				tx=session.getTransaction();
				tx.begin();
				
				Query query = session.createQuery("from Utente where username=:userInserito");
				query.setString("userInserito", username);
				a =(Admin) query.uniqueResult();
				
				 tx.commit();
				
				}catch(Exception ex){
					tx.rollback();
				}finally{
					session.close();
				}
				
				return a;
				
			}
			
			//2c Read con nome e cognome
					public Admin leggiAdminConNomeCognome(String nome, String cognome){
						Admin a=null;
						
						Session session =HibernateUtil.openSession();
						Transaction tx=null;

						try{
						tx=session.getTransaction();
						tx.begin();
						
						Query query = session.createQuery("from Utente where nome=:nomeInserito &&"
								+ "cognome=:cognomeInserito");
						query.setString("nomeInserito", nome);
						query.setString("cognomeInserito", cognome);
						
						a =(Admin) query.uniqueResult();
						
						 tx.commit();
						
						}catch(Exception ex){
							tx.rollback();
						}finally{
							session.close();
						}
						
						return a;
						
					}
					
					
					//3 Update
					public boolean aggiornaAdmin(Admin a ){
						
						boolean res=false;
						Session session =HibernateUtil.openSession();
						Transaction tx=null;

						try{
						tx=session.getTransaction();
						tx.begin();
						
						session.update(a);
						
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
					public boolean eliminaAdmin(Admin a){
						
						boolean res=false;
						Session session =HibernateUtil.openSession();
						Transaction tx=null;

						try{
						tx=session.getTransaction();
						tx.begin();
						
						session.delete(a);
						
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
