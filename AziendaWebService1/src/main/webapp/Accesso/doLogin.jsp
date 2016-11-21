<%@page import="it.alfasoft.andrea.service.Servizi"%>
<%@page import="it.alfasoft.andrea.bean.Utente"%>
<%@page import="it.alfasoft.andrea.bean.Admin"%>
<%@page import="it.alfasoft.andrea.bean.Cliente"%>
<%@page import="it.alfasoft.andrea.bean.Dipendente"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<jsp:useBean id="user" class="it.alfasoft.andrea.bean.Utente" scope="request" />
<jsp:useBean id="admin" class="it.alfasoft.andrea.bean.Admin" scope="session" />
<jsp:useBean id="cliente" class="it.alfasoft.andrea.bean.Cliente" scope="session" />
<jsp:useBean id="dipendente" class="it.alfasoft.andrea.bean.Dipendente" scope="session" />
<jsp:useBean id="messaggio" class="it.alfasoft.andrea.utility.MessaggioBean" scope="request" />

<jsp:setProperty property="*" name="user" />
<%-- <jsp:setProperty property="*" name="admin" /> --%>
<%-- <jsp:setProperty property="*" name="cliente" /> --%>
<%-- <jsp:setProperty property="*" name="dipendente" /> --%>
<%
	Servizi s = new Servizi();

	String usn = request.getParameter("username"); //prendo user dal form login
	Utente u = s.getUtente(usn); //leggo utente con user
	String pass = request.getParameter("password"); //prendo pass dal form login

	pass = s.codificaPass(pass);
	if (u != null && pass.equals(u.getPassword())) { //l'utente è nel database
		user = u;
		char ruolo = user.getRuolo();
		user.setNome(u.getNome());
		user.setCognome(u.getCognome());
		user.setRuolo(ruolo);

		switch (ruolo) {
		case 'a':
			Admin ad=s.getAdmin(usn);
			session.setAttribute("admin", ad);
			
%>
<jsp:forward page=".././Admin/HomePageAdmin.jsp" />
<%
	break;

		case 'c':
			Cliente cl=s.getCliente(usn);
			session.setAttribute("cliente", cl);
%>
<jsp:forward page=".././Cliente/HomePageCliente.jsp" />
<%
	break;

		case 'd':
			Dipendente dp=s.getDipendente(usn);
			session.setAttribute("dipendente", dp);
%>
<jsp:forward page=".././Dipendente/HomePageDipendente.jsp" />
<%
	break;
		}
	
	}else {
		messaggio.setMessaggio("User e/o password errati");
		%>
		<jsp:forward page="Login.jsp" />
		<%
				
	}
	
%>
