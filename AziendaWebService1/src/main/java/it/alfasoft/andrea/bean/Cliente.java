package it.alfasoft.andrea.bean;

import it.alfasoft.andrea.utility.ValidaDati;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@PrimaryKeyJoinColumn(name="id_utente")
public class Cliente extends Utente implements Serializable,ValidaDati {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String ragSociale;
	private String pIVA;

	
	public Cliente() {
		
	}

	public Cliente(String nome, String cognome,
			String username, String password, char ruolo,String ragioneSociale, String pIVA) {
		super(nome,cognome,username,password,ruolo);
		this.ragSociale = ragioneSociale;
		this.pIVA=pIVA;
	}

	public String getRagSociale() {
		return ragSociale;
	}

	public void setRagSociale(String ragSociale) {
		this.ragSociale = ragSociale;
	}
	

	public String getpIVA() {
		return pIVA;
	}

	public void setpIVA(String pIVA) {
		this.pIVA = pIVA;
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
				(!ragSociale.isEmpty() && ragSociale!=null) &&
				(!pIVA.isEmpty() && pIVA!=null)&&
				(ruolo=='c')
			){
			res=true;
		}
		return res;
	}


	
	
	
	
	
	

}
