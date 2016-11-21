<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>



<jsp:include page=".././headerHtml.jsp"></jsp:include>
<jsp:include page=".././navBar.jsp"></jsp:include>
<jsp:include page="menuLateraleDip.jsp"></jsp:include>

<jsp:useBean id="dipendente" class="it.alfasoft.andrea.bean.Dipendente"
	scope="session" />
<jsp:useBean id="messaggio"
	class="it.alfasoft.andrea.utility.MessaggioBean" scope="request" />


<%
	if (dipendente.isValid()) {
%>

<!DOCTYPE html >
<html>
<div class="ch-container">
	<div class="row">


		<div id="content" class="col-lg-10 col-sm-10">
			<!-- content starts -->
			<div>


				<ul class="breadcrumb">
					<li><a href="../Dipendente/HomePageDipendente.jsp">Home</a></li>
					<li><a href="#">Nuova voce </a></li>
				</ul>

				<div class="row">
					<div class="box col-md-12">
						<div class="box-inner">
							<div class="box-header well" data-original-title="">
								<h2>
									<i class="glyphicon glyphicon-th-plus"></i> Registrazione Nuova
									Voce nella tua Rubrica

								</h2>


							</div>


							<div class="box-content" align="center">
								<form class="form-horizontal" action="doRegistraNuovaVoceDipendente.jsp"
									method="post">
									<div class="form-group">
										<label>Nome</label><br> <input type="text" name="nome"
											placeholder="Enter name" required><br> <label>Cognome</label><br>
										<input type="text" name="cognome" placeholder="Enter surname"
											required><br> <label>Telefono</label><br> <input
											type="text" name="telefono" placeholder="Enter number phone"
											required><br> <br><input type="submit"
											class="btn btn-primary" value="Registra"> <br> <font
											size="4" color="red"><%=messaggio.getMessaggio()%></font>
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







<%
	} else {
		response.sendRedirect(".././Accesso/Login.jsp");
	}
%>