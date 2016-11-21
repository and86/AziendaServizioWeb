<%@page import="it.alfasoft.andrea.bean.Dipendente"%>
<%@page import="it.alfasoft.andrea.bean.Utente"%>
<%@page import="it.alfasoft.andrea.service.Servizi"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:include page=".././headerHtml.jsp"></jsp:include>
<jsp:include page=".././navBar.jsp"></jsp:include>
<jsp:include page="menuLateraleAdmin.jsp"></jsp:include>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:useBean id="admin" class="it.alfasoft.andrea.bean.Admin"
	scope="session" />
<jsp:useBean id="messaggio"
	class="it.alfasoft.andrea.utility.MessaggioBean" scope="request" />

<!DOCTYPE html >
<html>	
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script> -->
<!-- <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css"> -->
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script> -->
<!-- <script type="text/javascript" src="Modifica.js"></script> -->




<div class="ch-container">
	<div class="row">
		

		<div id="content" class="col-lg-10 col-sm-10">
			<!-- content starts -->
			<div>


				<ul class="breadcrumb">
					<li><a href="../Admin/HomePageAdmin.jsp">Home</a></li>
					<li><a href="#">Modifica Dipendente </a></li>
				</ul>

				<div class="row">
				
					<div class="box col-md-12">
						<div class="box-inner">
							<div class="box-header well" data-original-title="">
								
								<h2>
									<i class="glyphicon glyphicon-edit"></i> Modifica Dipendente
								</h2>


							</div>
<%
Servizi s=new Servizi();
long id=Long.parseLong(request.getParameter("id_utente"));

Dipendente d=(Dipendente)s.getUtenteConId(id);

%>

							<div class="box-content" align="center">
							<font size="4" color="red"><%=messaggio.getMessaggio()%></font>
								<form class="form-horizontal" action="doModificaDipendente.jsp"
									method="post">
									<div class="form-group">
										<label>Nome</label><br> <input type="text" name="nome1" value=<%=d.getNome()%> ><br> 
										<label>Cognome</label><br><input type="text" name="cognome1" value=<%=d.getCognome()%>><br> 
										<label>Username</label><br> <input type="text" name="username1" value=<%=d.getUsername()%> ><br>
										<label>Password</label><br> <input type="password" name="password1" ><br>
										<label>Posizione</label><br> <input type="text" name="posizione1" value=<%=d.getRuolo()%>><br> 
										<label>Stipendio</label><br><input type="text" name="stipendio1" value=<%=d.getStipendio()%> ><br> 
										<br><input type="hidden" value=<%=d.getId_utente()%>
														name="id_utente" ><br> 
										<br> <input type="submit"
											class="btn btn-primary" value="Modifica"> <br>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">

	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">×</button>
				<h3>Settings</h3>
			</div>
			<div class="modal-body">
				<p>Here settings can be configured...</p>
			</div>
			<div class="modal-footer">
				<a href="#" class="btn btn-default" data-dismiss="modal">Close</a> <a
					href="#" class="btn btn-primary" data-dismiss="modal">Save
					changes</a>
			</div>
		</div>
	</div>
</div>


<jsp:include page=".././footer.jsp"></jsp:include>

</html>
