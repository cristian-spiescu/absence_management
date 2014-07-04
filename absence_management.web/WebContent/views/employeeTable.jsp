<%@page import="com.crispico.absence_management.model.Employee"%>
<%@page import="com.crispico.absence_management.model.Absence"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.crispico.absence_management.dao.EmployeeHibernateDao"%>
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
						<th>Absences</th>
						<th>Commands</th>
					</thead>
					<%
						for (Employee employee : (List<Employee>) request.getAttribute("employeeList")) {
					%>
					<tr>
						<td><%=employee.getFirstName()%></td>
						<td><%=employee.getLastName()%></td>
						<td>
							<%
								for(Absence a: employee.getAbsences()) {
							%> <%=a%><br> <%
 	}
 %>
						</td>
						<td><input type="submit" value="edit" name="Edit"></input> <a
							href="deleteEmployee.do?deleteid=<%=employee.getId()%>">Delete</a>
						</td>
					</tr>
					<%
						}
					%>
				</table>
				<script>
					function showhide(id) {
						if (document.getElementById) {
							obj = document.getElementById(id);
							if (obj.style.display == "none") {
								obj.style.display = "";
							} else {
								obj.style.display = "none";
							}
						}
					}
					function send(){
						firstname = document.getElementById("firstname").value;
						lastname = document.getElementById("lastname").value;
					    window.location="addEmployee.do?a="+firstname+"&b="+lastname;
					}
				</script>
				<form name="f1">
					<button class="btn btn-xs btn-warning" type="button"
						onclick="showhide('tbl')">Add Employee</button>
					<table class="table table-bordered table-striped" id="tbl"
						width="371" border="1" style="display: none">
						<tr>
							<th>First Name</th>
							<td><input id="firstname" name="a" type="text" value="">
							</td>
						</tr>
						<tr>
							<th>Last Name</th>
							<td><input id="lastname" name="b" type="text" value=""></td>
						</tr>
						<tr>
							<th>
							<input type="button" value="Add" onclick="send()">
							</th>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>