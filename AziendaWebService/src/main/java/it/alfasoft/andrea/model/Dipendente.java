package it.alfasoft.andrea.model;


	
	import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;



	import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.xml.bind.annotation.XmlRootElement;

	import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;


	@XmlRootElement
	public class Dipendente extends Utente{


		private double stipendio;
		private Set<BustaPaga> buste = new HashSet<BustaPaga>();
		
		public Dipendente(){
			super();
		}
		public Dipendente(double stipendio){
			super();
			this.stipendio = stipendio;
		}
		public double getStipendio() {
			return stipendio;
		}
		public void setStipendio(double stipendio) {
			this.stipendio = stipendio;
		}
	}

