package it.alfasoft.andrea.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;

public class Invocazioni {


	private Client buste=ClientBuilder.newClient();
	private WebTarget baseTarget=buste.target("http://localhost:8081/AziendaJSF/alfasoft");
	private WebTarget busTarget=baseTarget.path("/bustepaga");
	private WebTarget listaBusteTarget=busTarget.path("/lista");
	
	public Invocazioni() {
		
	}
	
	public Invocation getTutteBuste(){
		
		return busTarget.request().buildGet();
	}
}
