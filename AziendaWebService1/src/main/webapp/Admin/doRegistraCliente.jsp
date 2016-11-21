<%@page import="it.alfasoft.andrea.service.Servizi"%>
<%@page import="it.alfasoft.andrea.bean.Cliente"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:useBean id="user" class="it.alfasoft.andrea.bean.Utente"
	scope="session" />
<%-- <jsp:setProperty property="*" name="user" /> --%>
<jsp:useBean id="messaggio"
	class="it.alfasoft.andrea.utility.MessaggioBean" scope="request" />

<% 
String nome= request.getParameter("nome");
String cognome= request.getParameter("cognome");
String username= request.getParameter("username");
String password= request.getParameter("password");
String rS= request.getParameter("ragioneSociale");
String pIva= request.getParameter("pIva");


Cliente c=new Cliente(nome,cognome,username,password,'c',rS,pIva);

Servizi s=new Servizi();

if(c.isValid() && s.getUtente(username)==null){
	password=s.codificaPass(password);
	c.setPassword(password);
	s.registraCliente(c);
	messaggio.setMessaggio("Cliente registrato");

	
%>
<jsp:forward page="ElencoClienti.jsp" />
<% 
}else {
	messaggio.setMessaggio("Campi non validi e/o user già in uso");
	%>
<jsp:forward page="RegistrazioneNuovoCliente.jsp" />
<% 
}
	
	%>



