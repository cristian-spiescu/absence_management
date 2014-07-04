<%@page import="com.crispico.absence_management.dao.EmployeeHibernateDao"%>
<%@page import="com.crispico.absence_management.model.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%!
  public void deleteEmp(Employee employee){
	//EmployeeHibernateDao eho = new EmployeeHibernateDao();
	//eho.delete(employee);
	System.out.print("merge");
}
%>	
	
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
					</thead>
					<%
						for (Employee employee : (List<Employee>) request.getAttribute("list")) {
							String name = "deleteEmployee.do?id=" + employee.getId();
					%>
					<tr>
						<td><%=employee.getFirstName()%></td>
						<td><%=employee.getLastName()%></td>
						<td><%=employee.printAbsence()%></td>
						<td><button class="btn btn-xs btn-warning" type="button">Edit</button>
							<a href= <%=name%> class="btn btn-default btn-lg active" role="button">Delete</a>
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