package it.alfasoft.andrea.client;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;


public class TestInvocazioni extends Invocazione {
	private WebTarget bustaTarget=baseTarget.path("/bustepaga");

	public TestInvocazioni() {
		super();
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
