package it.alfasoft.andrea.bean;

import java.io.Serializable;

import javax.persistence.*;
import javax.persistence.Entity;


@Entity
public class BustaPaga implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_bustaPaga;
	
	
	
	
	@ManyToOne
	private Dipendente dipendente;
	private double totale;
	private String DataEmissione;
	
	public BustaPaga() {
//		this.DataEmissione="";
//		this.totale=0;
	}

	public BustaPaga(String DataEmissione,double totale) {
		this.DataEmissione = DataEmissione;
		this.totale = totale;
	}

	public long getId_bustaPaga() {
		return id_bustaPaga;
	}

	public void setId_bustaPaga(long id_bustaPaga) {
		this.id_bustaPaga = id_bustaPaga;
	}	

	public String getDataEmissione() {
		return DataEmissione;
	}

	public void setDataEmissione(String dataEmissione) {
		DataEmissione = dataEmissione;
	}

	public Dipendente getDipendente() {
		return dipendente;
	}

	public void setDipendente(Dipendente dipendente) {
		this.dipendente = dipendente;
	}

	public double getTotale() {
		return totale;
	}

	public void setTotale(double totale) {
		this.totale = totale;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
