<%@page import="org.postgresql.jdbc2.ResultWrapper"%>
<%@page import="javax.persistence.Convert"%>
<%@page import="com.crispico.absence_management.dao.EmployeeHibernateDao"%>
<%@page import="com.crispico.absence_management.model.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Employee</title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap theme -->
<link href="css/bootstrap-theme.min.css" rel="stylesheet">
	<script type="text/javascript">
	function submitEdit() {
		document.edEmp.submit();
	}
	
	</script>

</head>
<body>
	<div class="navbar navbar-default">
        <div class="container">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Absence Management</a>
          </div>
          <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li class="active"><a href="#">Home</a></li>
              <li><a href="#about">About</a></li>
              <li><a href="#contact">Contact</a></li>
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Manage company <span class="caret"></span></a>
                <ul class="dropdown-menu" role="menu">
                  <li><a href="showAbsences.do">Absences</a></li>
                  <li><a href="showEmployees.do">Employees</a></li>
                  <li><a href="#">Absence Types</a></li>
                  <li class="divider"></li>
                  <li class="dropdown-header">Nav header</li>
                  <li><a href="#">Separated link</a></li>
                  <li><a href="#">One more separated link</a></li>
                </ul>
              </li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
      
	<div class="container theme-showcase" role="main">
		<p>
		<div class="panel panel-success">
			<div class="panel-heading">
				<h3 class="panel-title">Edit Employee Personal Info</h3>
			</div>
			<div class="panel-body">
				<!--  
				<table class="table table-bordered table-striped">
					<thead>
						<th>First Name</th>
						<th>Last Name</th>
					</thead>
					<%
						List<Employee> lista = (List<Employee>) request.getAttribute("list");
					%>
					<tr>
						<td><input type="text" name="fname" value="<%= lista.get(0).getFirstName()%>" ></td>
						<td><input type="text" name="fname" value="<%= lista.get(0).getLastName()%>" ></td>
					</tr>
					
				</table>
				-->
				<form name="edEmp" action="/absence_management.web/showEmployees.do" method="get">
					<legend>Use the form below to fill in the requested information.</legend>
					<fieldset>
						<p>
							<label> First Name:</label> <input type="text" name="efname" value="<%= lista.get(0).getFirstName()%>">
						</p>
						<p>
							<label> Last Name:</label> <input type="text" name="ename" value="<%= lista.get(0).getLastName()%>">

						</p>
						<input type="hidden" name="edemp" value="<%= lista.get(0).getId()%>">
					</fieldset>
					<br />
					<button type="button" class="btn btn-success" onclick="submitEdit();">Edit</button>
					<button type="button" class="btn btn-danger" onclick="window.location.href='showEmployees.do';">Cancel</button>
				</form>
				
					
				
			</div>
		</div>
	</div>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="../../assets/js/docs.min.js"></script>
</body>
</html>