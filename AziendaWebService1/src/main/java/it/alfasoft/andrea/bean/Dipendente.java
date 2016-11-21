package it.alfasoft.andrea.bean;

import it.alfasoft.andrea.utility.ValidaDati;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;



import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@PrimaryKeyJoinColumn(name="id_utente")
public class Dipendente extends Utente implements Serializable,ValidaDati {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String posizione;
	private double stipendio;

	@OneToMany(mappedBy="dipendente",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
    @NotFound(action=NotFoundAction.IGNORE)
	private Set<BustaPaga> buste =new HashSet<BustaPaga>();
	
	public Dipendente() {
	}

	public Dipendente(String nome, String cognome,
			String username, String password, char ruolo,String posizione, double stipendio) {
		super(nome,cognome,username,password,ruolo);
		this.posizione=posizione;
		this.stipendio = stipendio;
	}

	public double getStipendio() {
		return stipendio;
	}

	public void setStipendio(double stipendio) {
		this.stipendio = stipendio;
	}
	

	public String getPosizione() {
		return posizione;
	}

	public void setPosizione(String posizione) {
		this.posizione = posizione;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
		
	public Set<BustaPaga> getBuste() {
		return buste;
	}

	public void setBuste(Set<BustaPaga> buste) {
		this.buste = buste;
	}
	
public void aggiungiBusta(BustaPaga b){
		
		this.buste.add(b);
	}

	public boolean isValid() {
		boolean res=false;
		
		if(		(!nome.isEmpty() && nome!=null) &&
				(!cognome.isEmpty() && cognome!=null) &&
				(!username.isEmpty() && username!=null) &&
				(!password.isEmpty() && password!=null) &&
				(!posizione.isEmpty() && posizione!=null) &&
				(ruolo=='d')
			){
			res=true;
		}
		return res;
	}
	

}
