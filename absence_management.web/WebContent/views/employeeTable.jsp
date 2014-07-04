<%@page import="com.crispico.absence_management.model.Employee"%>
<%@page import="com.crispico.absence_management.model.Absence"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.*"%>
<%@page import="java.text.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employees</title>

<%@include file="head.jsp" %>

<script type="text/javascript">
	$(document).ready(function(){
		$("[name=openEditEmployeeModal]").click(function(){
			var employeeId=$(this).next().val();
			$.ajax({
	            url: "http://localhost:8080/absence_management.web/employeeEditInfo.do",
	            type: "GET",
	            contentType: 'application/json; charset=utf-8',
	            dataType: "json",
	           	data:"employeeId="+employeeId,
	            success: function(data){
	            	//handleAdmin(data["admin"], data["groupAdmin"]);
	            	//var obj = jQuery.parseJSON(data);
					$("#firstName").val(data["firstName"]);
					$("#lastName").val(data["lastName"]);
					$("#employeeId").val(employeeId);
	            },
	            error:function(msg,er,t){
					alert(msg+"   "+er+"  "+t);
	            } 
	        });
		});
		
	});

</script>
</head>
<body>
	<div class="container theme-showcase" role="main">
		<%@include file="navbar.jsp" %>
		<%@include file="editEmployeeModal.jsp" %>
		<%@include file="addEmployeeModal.jsp" %>
		<div class="panel panel-success">
			<div class="panel-heading">
				<h3 class="panel-title"><span class="glyphicon glyphicon-user"></span> Employees </h3>

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
						for (Employee employee : (List<Employee>) request.getAttribute("list")) {
					%>
					<tr>
						<td><%=employee.getFirstName()%></td>
						<td><%=employee.getLastName()%></td>
						<td>
						<%	
						for (Absence ab: employee.getAbsences()) {
							String sd, ed;
							DateFormat dateFormatter;
							dateFormatter = DateFormat.getDateInstance(DateFormat.DEFAULT);
							sd = dateFormatter.format(ab.getStartDate());
							ed = dateFormatter.format(ab.getEndDate());
						%>
							<%=sd+" "%><span class="glyphicon glyphicon-arrow-right"></span><%=" "+ed %><br/>
						<% } %>
						 </td>
						<td>
						<div class="row">
							<div class="col-md-3">
								<form action="deleteEmployee.do" method="POST">
									<button class="btn btn-xs btn-danger" type="submit">Delete</button>
									<input type="hidden" name="employeeId" value="<%=employee.getId()%>">
								</form>
							</div>
							<div class="col-md-3">
								<!-- <form action="employeeEditInfo.do" method="POST"> -->
									<button class="btn btn-xs btn-warning" name="openEditEmployeeModal" data-toggle="modal" data-target="#editModal">Edit</button>
									<input type="hidden" name="employeeId" value="<%=employee.getId()%>">
									<input type="hidden" name="firstName" value="<%=employee.getFirstName()%>">
									<input type="hidden" name="lastName" value="<%=employee.getLastName()%>">
								<!-- </form>-->
							</div>
						</div>
						</td>
					</tr>
					<%
						}
					%>
				</table>
			</div>
		</div>
		<button class="btn btn-primary glyphicon glyphicon-plus-sign pull-left" data-toggle="modal" data-target="#addModal"></button>
		
	</div>
</body>
</html>