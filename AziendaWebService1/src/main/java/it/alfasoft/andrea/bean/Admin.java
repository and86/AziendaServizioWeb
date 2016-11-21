package it.alfasoft.andrea.bean;

import it.alfasoft.andrea.utility.ValidaDati;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@PrimaryKeyJoinColumn(name="id_utente")
public class Admin extends Utente implements Serializable,ValidaDati {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String livelloAccesso;

	public Admin() {
	}

	public Admin(String nome,String cognome,String username,String password, char ruolo,String livelloAccesso) {
		super(nome,cognome,username,password,ruolo);
		this.livelloAccesso = livelloAccesso;
	}

	public String getLivelloAccesso() {
		return livelloAccesso;
	}

	public void setLivelloAccesso(String livelloAccesso) {
		this.livelloAccesso = livelloAccesso;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public boolean isValid() {
boolean res=false;
		
		if(		(!nome.isEmpty() && nome!=null) &&
				(!cognome.isEmpty() && cognome!=null) &&
				(!username.isEmpty() && username!=null) &&
				(!password.isEmpty() && password!=null) &&
				(!livelloAccesso.isEmpty() && livelloAccesso!=null) &&
				(ruolo=='a')
			){
			res=true;
		}
		return res;
	}



	
	
	
}
