<%@page import="com.crispico.absence_management.model.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employees</title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap theme -->
<link href="css/bootstrap-theme.min.css" rel="stylesheet">

</head>
<body>
	<div class="container theme-showcase" role="main">
		<p>
		<div class="panel panel-success">
			<div class="panel-heading">
				<h3 class="panel-title">Employees</h3>
			</div>
			<div class="panel-body">
				<table class="table table-bordered table-striped">
					<thead>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Commands</th>
					</thead>
					<%
						for (Employee employee : (List<Employee>) request.getAttribute("list")) {
					%>
					<tr>
						<td><%=employee.getFirstName()%></td>
						<td><%=employee.getLastName()%></td>
						<td><button class="btn btn-xs btn-warning" type="button">Edit</button>
							<button class="btn btn-xs btn-danger" type="button">Delete</button></td>
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