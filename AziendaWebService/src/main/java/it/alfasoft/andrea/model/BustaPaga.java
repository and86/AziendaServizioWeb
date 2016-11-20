package it.alfasoft.andrea.model;
	
	import java.util.Date;

	import javax.xml.bind.annotation.XmlRootElement;

	@XmlRootElement
	public class BustaPaga {
	
		private Date dataEmissione;
		private Dipendente dipendente;
		private double totale;
		
		public BustaPaga() {
		}
		
		public BustaPaga(Date emissione, Dipendente d, double tot){
			this.dataEmissione = emissione;
			this.dipendente = d;
			this.totale = tot;
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

		public Date getDataEmissione() {
			return dataEmissione;
		}

		public void setDataEmissione(Date dataEmissione) {
			this.dataEmissione = dataEmissione;
		}



}
