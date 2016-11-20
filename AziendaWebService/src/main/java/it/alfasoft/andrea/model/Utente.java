package it.alfasoft.andrea.model;

	import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;




	@Inheritance(strategy=InheritanceType.JOINED)

	@XmlRootElement
	public class Utente{

		protected String nome = "";
		protected String cognome = "";
		protected String username = "";
		protected String password = "";
		protected String ruolo;
		protected boolean loggato = false;
		
		
		public Utente (){
		}
		public Utente(String nome, String cognome, String username, String password) {
			this.nome = nome;
			this.cognome = cognome;
			this.username = username;
			this.password =  password;
		}

		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getCognome() {
			return cognome;
		}
		public void setCognome(String cognome) {
			this.cognome = cognome;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
		

}
