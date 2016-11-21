<%@page import="it.alfasoft.andrea.bean.Dipendente"%>
<%@page import="it.alfasoft.andrea.bean.BustaPaga"%>
<%@page import="it.alfasoft.andrea.service.Servizi"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    



<jsp:useBean id="busta" class="it.alfasoft.andrea.bean.BustaPaga"
	scope="session" /> 
<jsp:setProperty property="*" name="busta"/>


<% 
Servizi s=new Servizi();

// String id=request.getParameter("id_dipendente");

long id=Long.parseLong(request.getParameter("id_dipendente"));
long importo=Long.parseLong(request.getParameter("importo"));
String data=request.getParameter("dataEmissione");
Dipendente d=(Dipendente) s.getUtenteConId(id);

BustaPaga b=new BustaPaga();
b.setDipendente(d);
b.setDataEmissione(data);
b.setTotale(importo);

// out.println(id);
// out.println(importo);
// out.println(data);

s.creaBustaPaga(b);
response.sendRedirect("ElencoBustePaga.jsp");

%>


