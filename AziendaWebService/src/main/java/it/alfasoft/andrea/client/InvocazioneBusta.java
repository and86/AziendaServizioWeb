package it.alfasoft.andrea.client;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;


public class InvocazioneBusta extends Invocazione {
	private WebTarget bustaTarget=baseTarget.path("/bustepaga/lista");

	public InvocazioneBusta() {
	
	}

	public WebTarget getBustaTarget() {
		return bustaTarget;
	}

	public void setBustaTarget(WebTarget bustaTarget) {
		this.bustaTarget = bustaTarget;
	}
	
	public Invocation getAllBuste(){
		return bustaTarget.request().buildGet();
	}

}
