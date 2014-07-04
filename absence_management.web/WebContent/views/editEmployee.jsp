<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>edit employee</title>
<%@include file="head.jsp" %>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-6 ">
		  <div class="panel panel-success">
			<div class="panel-heading">
				<h3 class="panel-title"><span class="glyphicon glyphicon-user"></span> Employee info </h3>

			</div>
			<div class="panel-body">
				<form method="POST" action="updateEmployee.do">
					<div class="input-group">
					  <span class="input-group-addon">Last name</span>
					  <input type="text" class="form-control" required name="lastName" value="<%=request.getParameter("lastName")%>">
					</div>
					<div class="input-group">
					  <span class="input-group-addon">First name</span>
					  <input type="text" class="form-control" required name="firstName" value="<%=request.getParameter("firstName")%>">
					</div>
					 <input type="hidden" class="form-control" required name="employeeId" value="<%=request.getParameter("employeeId")%>">
					<br/><div><button class="btn btn-primary" type="submit">Update</button></div>
					
				</form>
			</div>
		</div>
	</div>
</body>
</html>