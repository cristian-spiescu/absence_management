<%@page import="com.crispico.absence_management.model.AbsenceType"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AbsenceType</title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap theme -->
<link href="css/bootstrap-theme.min.css" rel="stylesheet">

</head>
<body>
	<div class="container theme-showcase" role="main">
		<p>
		<div class="panel">
			<tr>
				<td><a href="/absence_management.web/showEmployees.do"
					class="btn btn-xs btn-primary" role="button">Employees</a></td>
				<td><a href="/absence_management.web/showAbsences.do"
					class="btn btn-xs btn-primary" role="button">Absences</a></td>
				<td><a href="/absence_management.web/showAbsencesType.do"
					class="btn btn-xs btn-primary" role="button">AbsenceTypes</a></td>
			</tr>

		</div>

		<div class="panel panel-success">
			<div class="panel-heading">
				<h3 class="panel-title">AbsenceType</h3>
			</div>
			<div class="panel-body">
				<table class="table table-bordered table-striped">
					<thead>
						<th>Id Type</th>
						<th>Type</th>
						<th>Commands</th>
					</thead>
					<%
						for (AbsenceType absenceT : (List<AbsenceType>) request
								.getAttribute("list")) {
					%>
					<tr>
						<td><%=absenceT.getIdT()%>
						<td><%=absenceT.getAbsenceType()%></td>
						<td><button class="btn btn-xs btn-warning" type="button">Edit</button>
							<form action="deleteAbsenceType.do" method="POST">
								<button class="btn btn-xs btn-danger" type="submit">Delete</button>
								<input type="hidden" name="absenceTypeId"
									value="<%=absenceT.getIdT()%>">
							</form></td>
					</tr>
					<%
						}
					%>
				</table>
			</div>
		</div>
	</div>
</body>
</html>