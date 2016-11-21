<%@page import="it.alfasoft.andrea.bean.BustaPaga"%>
<%@page import="it.alfasoft.andrea.bean.Dipendente"%>
<%@page import="java.util.List"%>
<%@page import="it.alfasoft.andrea.service.Servizi"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page=".././headerHtml.jsp"></jsp:include>
<jsp:include page=".././navBar.jsp"></jsp:include>
<jsp:include page="menuLateraleDip.jsp"></jsp:include>



<jsp:useBean id="dipendente" class="it.alfasoft.andrea.bean.Dipendente"
	scope="session" />

<jsp:useBean id="messaggio"
	class="it.alfasoft.andrea.utility.MessaggioBean" scope="request" />

<%-- <% --%>
// 	if (dipendente.isValid()) {
<%-- %> --%>

<div class="ch-container">
	<div class="row">


		<div id="content" class="col-lg-10 col-sm-10">
			<!-- content starts -->
			<div>


				<ul class="breadcrumb">
					<li><a href="../Admin/HomePageAdmin.jsp">Home</a></li>
					<li><a href="#">Le mie Buste Paga </a></li>
				</ul>

				<div class="row">
					<div class="box col-md-12">
						<div class="box-inner">
							<div class="box-header well" data-original-title="">
								<h2>
									<i class="glyphicon glyphicon-th-list"></i> Elenco Buste Paga
								</h2>

								<div class="box-icon">
									<a href="#" class="btn btn-setting btn-round btn-default"><i
										class="glyphicon glyphicon-cog"></i></a> <a href="#"
										class="btn btn-minimize btn-round btn-default"><i
										class="glyphicon glyphicon-chevron-up"></i></a> <a href="#"
										class="btn btn-close btn-round btn-default"><i
										class="glyphicon glyphicon-remove"></i></a>
								</div>
							</div>


							<div class="box-content">
								<div align="center">
									<font size="4" color="red"><%=messaggio.getMessaggio()%></font>
								</div>
							</div>
							<table
								class="table table-striped table-bordered bootstrap-datatable datatable responsive">
								<thead>
									<tr>
										<th>Data Emissione</th>
										<th>Totale</th>
										<th>Actions</th>
									</tr>
								</thead>
								<tbody>

									<%
										Servizi s = new Servizi();
										List<BustaPaga> buste = s.getListBuste(dipendente);
										session.setAttribute("buste", buste);
											
									%>
									<c:set var="i" value="1" scope="page" />

									<c:forEach items="${buste}" var="b">

										<tr>
											<td class="center"><c:out value="${b.dataEmissione}" /></td>
											<td class="center"><c:out value="${b.totale}" /></td>
											<td class="center">

												<form action="doCancellaBusta.jsp" method="post">
													<input type="hidden" value="${b.id_bustaPaga}"
														name="id_bustaPaga" />
													<button type="submit" class="btn btn-danger">
														Delete <i class="glyphicon glyphicon-trash icon-white"></i>
													</button>
												</form>


											</td>
										</tr>
										<c:set var="i" value="${i + 1}" scope="page" />
									</c:forEach>

								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</div>

<hr>

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

<%-- <% --%>
// 	} else {
// 		response.sendRedirect(".././Accesso/Login.jsp)");
// 	}
<%-- %> --%>