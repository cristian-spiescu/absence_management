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
    window.location="deleteAbsence.do?id=" + id;
}
//-->
</script>

</head>
<body>
	<div class="container theme-showcase" role="main">
		<p>
		<div class="panel panel-success">
			<div class="panel-heading">
				<h3 class="panel-title">Absences</h3>
			</div>
			<div class="panel-body">
				<table class="table table-bordered table-striped">
					<thead>
						<th>Absence</th>
						<th>Absence type</th>
						<th>Commands</th>
					</thead>
					<%
						for (Absence absence : (List<Absence>) request.getAttribute("list")) {
					%>
					<tr>
						<td><b><%=absence.getEmployee()%></b> a lipsit in perioada <%=absence.getStartDate()%>
							- <%=absence.getEndDate()%></td>
						<td><%=absence.getAbsenceType()%></td>
						<td><button class="btn btn-xs btn-warning" type="button">Edit</button>
							<!-- redirect to another page which does the deletion -->
							<button class="btn btn-xs btn-danger" type="button"
								onclick="function_delete(<%=absence.getID()%>)">Delete</button></td>
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