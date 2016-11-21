package it.alfasoft.andrea.bean;



import javax.ws.rs.QueryParam;

public class FiltriFattura {
	
	private @QueryParam("dateInizio") String dateInizio;
	private @QueryParam("dateFine" )String dateFine;
	
	public String getDateInizio() {
		return dateInizio;
	}
	public void setDateInizio(String dateInizio) {
		this.dateInizio = dateInizio;
	}
	public String getDateFine() {
		return dateFine;
	}
	public void setDateFine(String dateFine) {
		this.dateFine = dateFine;
	}
	
	
	
	
	
	
	
}
