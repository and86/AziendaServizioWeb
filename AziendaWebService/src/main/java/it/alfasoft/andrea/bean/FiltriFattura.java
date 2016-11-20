package it.alfasoft.andrea.bean;

import java.util.Date;

import javax.ws.rs.QueryParam;

public class FiltriFattura {
	
	private @QueryParam("dateInizio") Date dateInizio;
	private @QueryParam("dateFine") Date dateFine;
	
	public Date getDateInizio() {
		return dateInizio;
	}
	public void setDateInizio(Date dateInizio) {
		this.dateInizio = dateInizio;
	}
	public Date getDateFine() {
		return dateFine;
	}
	public void setDateFine(Date dateFine) {
		this.dateFine = dateFine;
	}
	
	
	
	
	
	
}
