package it.alfasoft.andrea.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;

public abstract class Invocazione {
	
	protected Client cliente = ClientBuilder.newClient();
	protected WebTarget baseTarget = cliente.target("http://localhost:8081/AziendaJSF/alfasoft/bustepaga/lista");

	abstract Invocation getTutteBustePaga();

}




