<%@page import="com.crispico.absence_management.model.Employee"%>
<%@page import="com.crispico.absence_management.model.Absence"%>
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

<script language="JavaScript">
<!--
function function_delete(id){
    window.location="confirm_delete_employee.do?id=" + id;
}

function function_edit(id){
    window.location="edit_employee.do?id=" + id;
}

function adaugaAngajat(){
   firstname = document.getElementById("firstname").value;
   lastname = document.getElementById("lastname").value;
   window.location="add_employee.do?firstname="+firstname+"&lastname="+lastname;
}
//-->
</script>


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
						<th>Absentele</th>
						<th>Commands</th>
					</thead>
					<%
						for (Employee employee : (List<Employee>) request
								.getAttribute("list")) {
					%>
					<tr>
						<td><%=employee.getFirstName()%></td>
						<td><%=employee.getLastName()%></td>
						<td><%=employee.getAllAbsences()%></td>
						<td><button class="btn btn-xs btn-warning" type="button" onclick="function_edit(<%=employee.getID()%>)">Edit</button>
							<button class="btn btn-xs btn-danger" type="button"
								onclick="function_delete(<%=employee.getID()%>)">Delete</button></td>
					</tr>
					<%
						}
					%>
				</table>
			</div>
		</div>
		</p>
		<p>
		<div class="alert alert-success" role="alert">
			<strong> Adauga angajat </strong><br />
			<table>
				<tr>
					<td>Prenume:</td>
					<td><input type="text" id="firstname" /></td>
				</tr>
				<tr>
					<td>Nume:</td>
					<td><input type="text" id="lastname" /></td>
				</tr>
				<tr colspan="2">
					<td><input type="button" value="Adauga" onclick="adaugaAngajat()"></td>
				</tr>
			</table>
		</div>
		</p>
	</div>

</body>
</html>