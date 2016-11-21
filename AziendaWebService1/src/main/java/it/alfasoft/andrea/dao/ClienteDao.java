package it.alfasoft.andrea.dao;

import hibernateUtil.HibernateUtil;
import it.alfasoft.andrea.bean.Cliente;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ClienteDao {
	
	//1 Crea
	public boolean creaCliente(Cliente c)
	{
		boolean result=false;
		
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();
		
		session.persist(c);
		
		 result=true;
		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		
		return result;	
	}
	//2a Read con Id
		public Cliente leggiClienteConId(long id_c){
			Cliente c=null;
			
			Session session =HibernateUtil.openSession();
			Transaction tx=null;

			try{
			tx=session.getTransaction();
			tx.begin();
			
			c=session.get(Cliente.class,id_c);
			
			 tx.commit();
			
			}catch(Exception ex){
				tx.rollback();
			}finally{
				session.close();
			}
			
			return c;
			
		}
		
		//2b Read con username
			public Cliente leggiClienteConUser(String username){
				Cliente c=null;
				
				Session session =HibernateUtil.openSession();
				Transaction tx=null;

				try{
				tx=session.getTransaction();
				tx.begin();
				
				Query query = session.createQuery("from Utente where username=:userInserito");
				query.setString("userInserito", username);
				c =(Cliente) query.uniqueResult();
				
				 tx.commit();
				
				}catch(Exception ex){
					tx.rollback();
				}finally{
					session.close();
				}
				
				return c;
				
			}
			
			//2c Read con nome e cognome
					public Cliente leggiClienteConNomeCognome(String nome, String cognome){
						Cliente c=null;
						
						Session session =HibernateUtil.openSession();
						Transaction tx=null;

						try{
						tx=session.getTransaction();
						tx.begin();
						
						Query query = session.createQuery("from Utente where nome=:nomeInserito &&"
								+ "cognome=:cognomeInserito");
						query.setString("nomeInserito", nome);
						query.setString("cognomeInserito", cognome);
						
						c =(Cliente) query.uniqueResult();
						
						 tx.commit();
						
						}catch(Exception ex){
							tx.rollback();
						}finally{
							session.close();
						}
						
						return c;
						
					}
					
					//2c Read tutti Utenti
					@SuppressWarnings("unchecked")
					public List<Cliente> leggiTuttiClienti(){
						List<Cliente> clienti=new ArrayList<Cliente>();
						
						Session session =HibernateUtil.openSession();
						Transaction tx=null;

						try{
						tx=session.getTransaction();
						tx.begin();
						
						Query query = session.createQuery("from Cliente"); 
						
						clienti =query.list();
						
						 tx.commit();
						
						}catch(Exception ex){
							tx.rollback();
						}finally{
							session.close();
						}
						
						return clienti;
						
					}
					
					//3 Update
					public boolean aggiornaCliente(Cliente c){
						
						boolean res=false;
						Session session =HibernateUtil.openSession();
						Transaction tx=null;

						try{
						tx=session.getTransaction();
						tx.begin();
						
						session.update(c);
						
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
					public boolean eliminaCliente(Cliente c){
						
						boolean res=false;
						Session session =HibernateUtil.openSession();
						Transaction tx=null;

						try{
						tx=session.getTransaction();
						tx.begin();
						
						session.delete(c);
						
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
