<%@page import="it.alfasoft.andrea.bean.Dipendente"%>
<%@page import="it.alfasoft.andrea.service.Servizi"%>



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
String ps= request.getParameter("posizione");
String sti= request.getParameter("stipendio");

Double stipendio_d=0.0;
if(!sti.isEmpty() && sti!=null){
stipendio_d=Double.parseDouble(sti);
} 


Dipendente d=new Dipendente(nome,cognome,username,password,'d',ps,stipendio_d);

Servizi s=new Servizi();

if(d.isValid() && s.getUtente(username)==null){
	password=s.codificaPass(password);
	d.setPassword(password);
	s.registraDipendente(d);
	messaggio.setMessaggio("Dipendente registrato");

	
%>
<jsp:forward page="ElencoDipendenti.jsp" />
<% 
}else {
	messaggio.setMessaggio("Campi non validi e/o user già in uso");
	%>
<jsp:forward page="RegistrazioneNuovoDipendente.jsp" />
<% 
}
	
	%>
