<%@page import="it.alfasoft.andrea.bean.Dipendente"%>
<%@page import="it.alfasoft.andrea.service.Servizi"%>
<%@page import="it.alfasoft.andrea.bean.Cliente"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:useBean id="messaggio"
	class="it.alfasoft.andrea.utility.MessaggioBean" scope="request" />

<%
long id=Long.parseLong(request.getParameter("id_utente"));

Servizi s=new Servizi();
Dipendente d =(Dipendente)s.getUtenteConId(id);

String nome_m=request.getParameter("nome1");
String cognome_m=request.getParameter("cognome1");
String username_m=request.getParameter("username1");
String password_m=request.getParameter("password1");
String posizione_m=request.getParameter("posizione1");
double stipendio_m=Double.parseDouble(request.getParameter("stipendio1"));

d.setNome(nome_m);
d.setCognome(cognome_m);
d.setUsername(username_m);
d.setPassword(s.codificaPass(password_m));
d.setPosizione(posizione_m);
d.setStipendio(stipendio_m);

s.aggiornaDipendente(d);
%>

<jsp:forward page="ElencoDipendenti.jsp"></jsp:forward>




