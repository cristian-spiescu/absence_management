<%@page import="com.crispico.absence_management.model.Employee"%>
<%@page import="com.crispico.absence_management.model.AbsenceType"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employees</title>

<%@include file="head.jsp" %>

</head>
<body>
	<div class="container theme-showcase" role="main">
		<%@include file="navbar.jsp" %>
		<div class="panel panel-success">
			<div class="panel-heading">
				<h3 class="panel-title">Absence types</h3>
			</div>
			<div class="panel-body">
				<table class="table table-bordered table-striped">
					<thead>
						<th>type</th>
						<th>Commands</th>
					</thead>
					<%
						for (AbsenceType absType : (List<AbsenceType>) request.getAttribute("list")) {
					%>
					<tr>
						<td><%=absType.getType()%></td>
						<td>
							<form action="deleteAbsenceType.do" method="POST">
								<button class="btn btn-xs btn-danger" type="submit">Delete</button>
								<input type="hidden" name="typeId" value="<%=absType.getId()%>">
							</form>
						</td>
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