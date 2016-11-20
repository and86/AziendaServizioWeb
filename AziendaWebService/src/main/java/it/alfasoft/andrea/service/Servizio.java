package it.alfasoft.andrea.service;

import java.util.List;

import it.alfasoft.andrea.dao.FatturaDao;
import it.alfasoft.andrea.model.Fattura;

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
