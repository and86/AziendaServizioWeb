package it.alfasoft.andrea.service;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
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
	
	
	//Creazione Report
	
	public void creaReportFattura(Fattura f,String pathToJasper){
		
//		Fattura f= fDao.leggiFatturaConCodice(codiceFattura);
		
//		String codice=f.getCodice();
//		Double importo=f.getTotale();
//		Date data=f.getEmissione();
		
		String nomeFile="ReportFattura"+f.getCodice().toUpperCase()+".pdf";
		String percorso  = "C:\\Users\\Andrea\\Desktop\\Report\\";
		
		String fileFinale=percorso+nomeFile;
		
		try {
			 
			Map<String, Object> parameters = new HashMap<String, Object>();
			
//			  parameters.put("importo", importo);
//		      parameters.put("data", data);
//		      parameters.put("codiceFattura",codice);
			
			Fattura f2= fDao.leggiFatturaConCodice(f.getCodice());
			
			String codice=f.getCodice();
			Double importo=f.getTotale();
			Date data=f.getEmissione();
			
			parameters.put("totale", importo);		//"totale" è uguale al nome che ho dato nel file jrxml
			parameters.put("emissione", data);
		    parameters.put("codice",codice);
			
			
			
		      //  file compilato di jasper (.jasper) di Jasper Report per creare  PDF 
		      JasperPrint jasperPrint = JasperFillManager.fillReport(pathToJasper, parameters, new JREmptyDataSource());

		    //outputStream per creare PDF 
	          OutputStream outputStream = new FileOutputStream(new File(fileFinale));
	         
		   // scrivo in un  file PDF  
		      JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
//		      System.out.println("il File.pdf e' stato creato");
						      
		
	} catch (JRException e) {
		
		e.printStackTrace();
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	}
//		return fileFinale;
		
	}

}
