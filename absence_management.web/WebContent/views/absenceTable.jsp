<%@page import="com.crispico.absence_management.model.Absence"%>
<%@page import="com.crispico.absence_management.model.Employee"%>
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
				<h3 class="panel-title">Absences</h3>
			</div>
			<div class="panel-body">
				<div class="alert alert-<%= (String)request.getAttribute("m_type")%>" role="alert">
        			<%= (String)request.getAttribute("message") %>
      			</div>
				<table class="table table-bordered table-striped">
					<thead>
						<th>Type</th>
						<th>Employee</th>
						<th>Start date</th>
						<th>End date</th>
						<th>Commands</th>
					</thead>
					<%
						for (Absence absence : (List<Absence>) request.getAttribute("list")) {
					%>
					<tr>
						<td><%=absence.getType().getType()%></td>
						<td><%=absence.getEmployee().getFirstName()+ " " + absence.getEmployee().getLastName()%></td>
						<td><%=absence.getStart()%></td>
						<td><%=absence.getFinish()%></td>
						<td><button class="btn btn-xs btn-warning" type="button" onclick="window.location.href='editAbsence.do?myabs=<%= absence.getAbsence_id()%>';">Edit</button>
							<button class="btn btn-xs btn-danger" type="button" onclick="window.location.href='deleteAbsence.do?myabs=<%= absence.getAbsence_id()%>';">Delete</button></td>
					</tr>
					<%
						}
					%>
				</table>
				<button type="button" class="btn btn-success" onclick="window.location.href='addAbsence.do';">Add absence</button>
			</div>
		</div>
	</div>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="../../assets/js/docs.min.js"></script>
</body>
</html>