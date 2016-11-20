package it.alfasoft.andrea.resources;

import java.util.ArrayList;
import java.util.List;

import it.alfasoft.andrea.bean.FiltriFattura;
import it.alfasoft.andrea.model.Fattura;
import it.alfasoft.andrea.service.Servizio;



import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


@Path("fattura")
@Produces(MediaType.APPLICATION_JSON)
public class RisorsaFattura {
	
	Servizio s=new Servizio();

	@Path("/{CodiceFattura}")
	@GET
	public Fattura getFatturaConCodice(@PathParam("CodiceFattura") String codice){
		return s.leggiFatturaConCodice(codice);
	}
		
	@Path("/lista")
	@GET
	public List<Fattura> getAllFatture() {
		return new ArrayList<Fattura>(s.leggiTutteFatture());
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addFattura(Fattura f){
		s.registraFattura(f);
		return Response.status(Status.CREATED).entity(f).build();
		
	}
	
	@GET
	@Path("/fatturaProva")
	@Produces(MediaType.TEXT_PLAIN)
	public String getContextParameter(@BeanParam FiltriFattura ff){
		
//		ff.setAnno(2016);
		return ff.getDateInizio()+ " "+ff.getDateFine();
	}

	
}
