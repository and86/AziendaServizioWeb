<%@page import="it.alfasoft.andrea.service.Servizi"%>
<%@page import="it.alfasoft.andrea.bean.Cliente"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:useBean id="messaggio"
	class="it.alfasoft.andrea.utility.MessaggioBean" scope="request" />

<%
long id=Long.parseLong(request.getParameter("id_utente"));

Servizi s=new Servizi();
Cliente c=(Cliente)s.getUtenteConId(id);

String nome_m=request.getParameter("nome1");
String cognome_m=request.getParameter("cognome1");
String username_m=request.getParameter("username1");
String password_m=request.getParameter("password1");
String rS_m=request.getParameter("ragioneSociale1");
String pIva_m=request.getParameter("pIva1");

c.setNome(nome_m);
c.setCognome(cognome_m);
c.setUsername(username_m);
c.setPassword(s.codificaPass(password_m));
c.setRagSociale(rS_m);
c.setpIVA(pIva_m);

s.aggiornaCliente(c);
%>

<jsp:forward page="ElencoClienti.jsp"></jsp:forward>












