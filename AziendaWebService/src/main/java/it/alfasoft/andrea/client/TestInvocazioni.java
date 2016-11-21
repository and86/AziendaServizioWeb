package it.alfasoft.andrea.client;

import java.util.List;

import it.alfasoft.andrea.model.BustaPaga;
import it.alfasoft.andrea.model.Dipendente;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

public class TestInvocazioni extends Invocazione {

	@Override
	Invocation getTutteBustePaga() {
		// TODO Auto-generated method stub
		return baseTarget.request().buildGet();
	}
}
