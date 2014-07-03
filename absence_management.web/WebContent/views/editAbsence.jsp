<%@page import="com.crispico.absence_management.model.AbsenceType"%>
<%@page import="com.crispico.absence_management.model.Absence"%>
<%@page import="org.postgresql.jdbc2.ResultWrapper"%>
<%@page import="javax.persistence.Convert"%>
<%@page
	import="com.crispico.absence_management.dao.EmployeeHibernateDao"%>
<%@page import="com.crispico.absence_management.model.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Absence</title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap theme -->
<link href="css/bootstrap-theme.min.css" rel="stylesheet">

<script type="text/javascript">
	function submitInfo() {
		document.edAbs.submit();
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
				<h3 class="panel-title">Absence Info</h3>
			</div>
			<div class="panel-body">
				<!-- 
				<form name="addEmp" action="/showEmployees.do" method="post" >
    				<input type="text" name="name" >
    				<input type="text" name="fname" >
    				<button type="button" class="btn btn-success" onclick="submit();">Add</button>
				</form>
				-->
				<form name="edAbs" action="/absence_management.web/showAbsences.do" method="get">
					<legend>Use the form below to fill in the requested information.</legend>
					<%
						List<Absence> l = (List<Absence>) request.getAttribute("list");
					%>
					<fieldset>
						<p>
							<label> Employee:</label> 
							<select name="e_employees_list">
								<%
									for (Employee employee : (List<Employee>) request.getAttribute("emp_list")) {
										if (employee.equals(l.get(0).getEmployee())) {
								%>
											<option selected="true" value="<%= employee.getId()%>"><%= employee.getFirstName() + " " + employee.getLastName() %></option>
								<%
										} 
										else {
								%>
											<option value="<%= employee.getId()%>"><%= employee.getFirstName() + " " + employee.getLastName() %></option>
								<%
										}
									}
								%>
							</select>

						</p>
						<p>
							<label> Absence type:</label> 
							<select name="e_absences_list">
								<%
									for (AbsenceType absence : (List<AbsenceType>) request.getAttribute("abs_type_list")) {
										if (absence.equals(l.get(0).getType())) {
								%>
											<option selected="true" value="<%= absence.getAbsence_type_id()%>"><%= absence.getType() %></option>
								<%
										} 
										else {
								%>
											<option value="<%= absence.getAbsence_type_id()%>"><%= absence.getType() %></option>
								<%
										}
									}
								%>
							</select>
						</p>
						<p>
							<label> Start date:</label> 
							<input type="text" name="e_startd" value="<%= l.get(0).getStart()%>">

						</p>
						<p>
							<label> End date:</label> 
							<input type="text" name="e_endd" value="<%= l.get(0).getFinish()%>">

						</p>
						<input type="hidden" name="edabs" value="<%= l.get(0).getAbsence_id()%>">

					</fieldset>
					<br />
					<button type="button" class="btn btn-success" onclick="submitInfo();">Add</button>
				</form>
			</div>
		</div>
	</div>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="../../assets/js/docs.min.js"></script>
</body>
</html>