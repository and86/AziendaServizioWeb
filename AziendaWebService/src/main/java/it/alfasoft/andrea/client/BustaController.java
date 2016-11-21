package it.alfasoft.andrea.client;

import it.alfasoft.andrea.model.BustaPaga;

import java.util.List;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

public class BustaController {

	
	private InvocazioneBusta invocazione;

		
	
	public BustaController() {
		invocazione=new InvocazioneBusta();
	}

	public BustaController(InvocazioneBusta invocazione) {
		this.invocazione = invocazione;
	}

	public List<BustaPaga> leggiBustePaga(){
		
		Response response= invocazione.getAllBuste()
							.invoke();
					                     
		List<BustaPaga> listaBuste = response
									.readEntity(new GenericType<List<BustaPaga>>(){});
		
		
		return listaBuste;
		
	}
	
}
