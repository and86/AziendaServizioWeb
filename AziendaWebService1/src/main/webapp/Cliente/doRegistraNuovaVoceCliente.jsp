
<%@page import="it.alfasoft.andrea.model.Voce"%>
<%@page import="it.alfasoft.andrea.model.Rubrica"%>
<%@page import="it.alfasoft.andrea.service.Servizi"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:useBean id="cliente" class="it.alfasoft.andrea.bean.Cliente"
	scope="session" />
<jsp:useBean id="messaggio"
	class="it.alfasoft.andrea.utility.MessaggioBean" scope="request" />


<%
String name=request.getParameter("nome");
String surname=request.getParameter("cognome");
String tel=request.getParameter("telefono");

Servizi s=new Servizi();

String username=cliente.getUsername();
Rubrica r=s.cercaRubricaConUser(username);
if(r==null){
	s.registraRubrica(username);
}
Voce v=new Voce(name,surname,tel);

if(v.isValid()){
	s.registraVoce(r, v);
	messaggio.setMessaggio("Voce aggiunta nella tua rubrica");
	%>
		<jsp:forward page="HomePageCliente.jsp" />
		<%
}else{
	messaggio.setMessaggio("Campi non compilati");
	%>
	<jsp:forward page="RegistraNuovaVoceCliente.jsp" />
	<%
	
}


%>