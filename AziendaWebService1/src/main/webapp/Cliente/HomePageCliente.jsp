<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page=".././headerHtml.jsp"></jsp:include>
<jsp:include page=".././navBar.jsp"></jsp:include>



<jsp:useBean id="cliente" class="it.alfasoft.andrea.bean.Cliente"
	scope="session" />

<jsp:useBean id="messaggio"
	class="it.alfasoft.andrea.utility.MessaggioBean" scope="request" />



<%
if (cliente.isValid()) {
%>
	
<!DOCTYPE html>
<html>

<div class="ch-container">
	<div class="row">

		<!-- left menu starts -->
		<jsp:include page="menuLateraleCli.jsp"></jsp:include>
		<!-- left menu ends -->

		<div id="content" class="col-lg-10 col-sm-10">
			<!-- content starts -->
			<div>

				<h1 align="center">Welcome to Customer Home Page</h1>
				<br>
				<h4 align="center">${cliente.nome} ${cliente.cognome} </h4>

				
			</div>
			<ul class="breadcrumb">
				<li><a href="#">Home</a></li>

			</ul>
			<div align="center"><font size="4" color="red"><%=messaggio.getMessaggio()%></font></div>
		</div>
		
		<div class=" row">

			<!--       devo scrivere per ogni pagina   -->






		</div>
		<!-- content ends -->
	</div>
	<!--/#content.col-md-0-->
</div>
<!--/fluid-row-->




<hr>

<jsp:include page=".././footer.jsp"></jsp:include>



<!--/.fluid-container-->

<!--      includo tutti script di sotto -->
<jsp:include page=".././scriptEndJs.jsp"></jsp:include>

</html>

<%
 } else{
response.sendRedirect(".././Accesso/Login.jsp");
}
 %>
