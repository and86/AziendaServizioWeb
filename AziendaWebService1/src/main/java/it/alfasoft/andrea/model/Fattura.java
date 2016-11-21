package it.alfasoft.andrea.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@Entity
public class Fattura {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_fattura;
	
	private Date emissione;
	private String codice;
	private double totale;
	
	public Fattura(Date emissione, String codice, double totale) {
		this.emissione = emissione;
		this.codice = codice;
		this.totale = totale;
	}

	public Fattura() {
		
	}

	public long getId_fattura() {
		return id_fattura;
	}

	public void setId_fattura(long id_fattura) {
		this.id_fattura = id_fattura;
	}

	public Date getEmissione() {
		return emissione;
	}

	public void setEmissione(Date emissione) {
		this.emissione = emissione;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public double getTotale() {
		return totale;
	}

	public void setTotale(double totale) {
		this.totale = totale;
	}
	
	
	
	
	
	
	
	

}
