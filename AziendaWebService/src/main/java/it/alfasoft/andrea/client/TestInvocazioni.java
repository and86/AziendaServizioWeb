package it.alfasoft.andrea.client;

import java.util.List;

import it.alfasoft.andrea.model.BustaPaga;
import it.alfasoft.andrea.model.Dipendente;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

public class TestInvocazioni {

	public static void main(String[] args) {
		
		Invocazioni invocazione=new Invocazioni();
		Response risposta=invocazione.richiestaBuste()
					.invoke();

		

}
}
