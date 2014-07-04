<%@page import="com.crispico.absence_management.model.Employee"%>
<%@page import="com.crispico.absence_management.model.Absence"%>
<%@page import="com.crispico.absence_management.model.AbsenceType"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Absences</title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap theme -->
<link href="css/bootstrap-theme.min.css" rel="stylesheet">

</head>
<body>
	<div class="container theme-showcase" role="main">
		<p>
		<div class="panel panel-warning">
			<div class="panel-heading">
				<h3 class="panel-title">Absences</h3>
			</div>
			<div class="panel-body">
				<table class="table table-bordered table-striped">
					<thead>
						<th>Absence id</th>
						<th>Start Date</th>
						<th>End Date</th>
						<th>Type</th>
						<th>Employee</th>
					</thead>
					<%
						for (Absence absence : (List<Absence>) request.getAttribute("list")) {
					%>
					<tr>
						<td align="center"><%=absence.getAbsenceId()%></td>
						<td><%=absence.getStartDate()%></td>
						<td><%=absence.getEndDate() %></td>
						<td><%=absence.getAbsenceType().getAbsenceType() %></td>
						<td><%=absence.getEmployee().getFirstName()+ " " +absence.getEmployee().getLastName() %></td>
						
					
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


