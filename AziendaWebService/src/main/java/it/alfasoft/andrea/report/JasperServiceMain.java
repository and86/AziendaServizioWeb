package it.alfasoft.andrea.report;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import it.alfasoft.andrea.dao.FatturaDao;
import it.alfasoft.andrea.model.Fattura;
import it.alfasoft.andrea.service.Servizio;

public class JasperServiceMain {
	
public static void main(String[] args) {
		
	Servizio s=new Servizio();	
		
		String nomeFile="ReportFattura.pdf";
		//metti codice fattura da concatenare e non sovraascivere
		String percorso  = "C:\\Users\\Andrea\\Desktop\\Report\\";
		 
		String fileFinale=percorso+nomeFile;
		
		try {
			
			//la mia lista che mantiene i dati
	        List<Fattura> fatture = s.leggiTutteFatture();
				
	      // Converto la  lista to JRBeanCollectionDataSource 
	     // JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(fatture,false);
			
				
	      //  una mappa per mandare i parametri a Jasper 
	      Map<String, Object> parameters = new HashMap<String, Object>();
	    
	      //parameters.put("FatturaDataSource", itemsJRBean); 
	      //leggo una volta con codice e poi metto i campi
	      parameters.put("importo", s.leggiFatturaConCodice("aaa").getTotale());
	      parameters.put("data", s.leggiFatturaConCodice("aaa").getEmissione());
	      parameters.put("codiceFattura", s.leggiFatturaConCodice("aaa").getCodice());
	      
	      //  file compilato di jasper (.jasper) di Jasper Report per creare  PDF 
	      JasperPrint jasperPrint = JasperFillManager.fillReport("reportFattura.jasper", parameters, new JREmptyDataSource());

	      //outputStream per creare PDF 
	      OutputStream outputStream = new FileOutputStream(new File(fileFinale));
	     
	      
	      // scrivo in un  file PDF  
			JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
			System.out.println("il File.pdf e' stato creato");
			
			
			
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	       

		}

	}