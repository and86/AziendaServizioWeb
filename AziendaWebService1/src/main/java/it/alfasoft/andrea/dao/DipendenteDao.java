package it.alfasoft.andrea.dao;

import hibernateUtil.HibernateUtil;


import it.alfasoft.andrea.bean.Dipendente;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DipendenteDao {
	
	//1 Crea
		public boolean creaDipendente(Dipendente d)
		{
			boolean result=false;
			
			Session session =HibernateUtil.openSession();
			Transaction tx=null;

			try{
			tx=session.getTransaction();
			tx.begin();
			
			session.persist(d);
			
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
			public Dipendente leggiDipendenteConId(long id_d){
				Dipendente d =null;
				
				Session session =HibernateUtil.openSession();
				Transaction tx=null;

				try{
				tx=session.getTransaction();
				tx.begin();
				
				d=session.get(Dipendente.class,id_d);
				
				 tx.commit();
				
				}catch(Exception ex){
					tx.rollback();
				}finally{
					session.close();
				}
				
				return d;
				
			}
			
			//2b Read con username
				public Dipendente leggiDipendenteConUser(String username){
					Dipendente d=null;
					
					Session session =HibernateUtil.openSession();
					Transaction tx=null;

					try{
					tx=session.getTransaction();
					tx.begin();
					
					Query query = session.createQuery("from Utente where username=:userInserito");
					query.setString("userInserito", username);
					d =(Dipendente) query.uniqueResult();
					
					 tx.commit();
					
					}catch(Exception ex){
						tx.rollback();
					}finally{
						session.close();
					}
					
					return d;
					
				}
				
				//2c Read con nome e cognome
						public Dipendente leggiDipendenteConNomeCognome(String nome, String cognome){
							Dipendente d =null;
							
							Session session =HibernateUtil.openSession();
							Transaction tx=null;

							try{
							tx=session.getTransaction();
							tx.begin();
							
							Query query = session.createQuery("from Utente where nome=:nomeInserito &&"
									+ "cognome=:cognomeInserito");
							query.setString("nomeInserito", nome);
							query.setString("cognomeInserito", cognome);
							
							d =(Dipendente) query.uniqueResult();
							
							 tx.commit();
							
							}catch(Exception ex){
								tx.rollback();
							}finally{
								session.close();
							}
							
							return d;
							
						}
						
						//2c Read tutti Utenti
						@SuppressWarnings("unchecked")
						public List<Dipendente> leggiTuttiDipendenti(){
							List<Dipendente> dipendenti=new ArrayList<Dipendente>();
							
							Session session =HibernateUtil.openSession();
							Transaction tx=null;

							try{
							tx=session.getTransaction();
							tx.begin();
							
							Query query = session.createQuery("from Dipendente"); 
							
							dipendenti =query.list();
							
							 tx.commit();
							
							}catch(Exception ex){
								tx.rollback();
							}finally{
								session.close();
							}
							
							return dipendenti;
							
						}
						
						//3 Update
						public boolean aggiornaDipendente(Dipendente d){
							
							boolean res=false;
							Session session =HibernateUtil.openSession();
							Transaction tx=null;

							try{
							tx=session.getTransaction();
							tx.begin();
							
							session.update(d);
							
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
						public boolean eliminaDipendente(Dipendente d){
							
							boolean res=false;
							Session session =HibernateUtil.openSession();
							Transaction tx=null;

							try{
							tx=session.getTransaction();
							tx.begin();
							
							session.delete(d);
							
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
