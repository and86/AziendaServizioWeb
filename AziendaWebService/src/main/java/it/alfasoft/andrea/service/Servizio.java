package it.alfasoft.andrea.service;



import java.text.ParseException;
import java.util.Date;
import java.util.List;

import it.alfasoft.andrea.dao.FatturaDao;
import it.alfasoft.andrea.model.Fattura;
import it.alfasoft.andrea.utility.DataUtility;

public class Servizio {
	
	FatturaDao fDao=new FatturaDao();
	
	//Registrazione
	public boolean registraFattura(Fattura f){
		return fDao.creaFattura(f);	
		
	}
	
	//Lettura
	public Fattura leggiFatturaConCodice(String codice){
		Fattura f=fDao.leggiFatturaConCodice(codice);
		return f;
	}
	
	public List<Fattura> leggiTutteFatture(){
		return fDao.leggiTutteFatture();
	}
	
	public List<Fattura> leggiFattureConData(String start,String end) throws ParseException{
		
		
		Date dateInizio=DataUtility.stringToDate(start);
		Date dateFine=DataUtility.stringToDate(end);
		return fDao.leggiFatturaConData(dateInizio, dateFine);
		
	}
	
	

	
	//Update
	public boolean aggiornaFattura(Fattura f) {
		fDao.leggiFatturaConId(f.getId_fattura());
		return fDao.aggiornaFattura(f);
	}
	
	//Delete
	public boolean eliminaFatturaConCodice(String codice){
		Fattura f= fDao.leggiFatturaConCodice(codice);
		return fDao.eliminaFattura(f);
		
	}

}
