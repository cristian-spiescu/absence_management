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
<title>Add new employee</title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap theme -->
<link href="css/bootstrap-theme.min.css" rel="stylesheet">

<script type="text/javascript">
	function cancelResp(){
		window.location="showEmployees.do"		
	}
</script>

</head>
<body>
	<div class="container theme-showcase" role="main">
		<p>
		<div class="panel panel-warning">
			<div class="panel-heading">
				<h3 class="panel-title">Add new employee</h3>
			</div>
			<div class="panel-body">
				<form action="/addEmp.do" method="post">
					<div class="form-group">
						<label>First name</label> <input
							class="form-control" name="firstname" type="text"
							placeholder="Enter first name">
					</div>
					<div class="form-group">
						<label>Last name</label> <input
							class="form-control" id="lastname"
							placeholder="Enter last name">
					</div>					
					<button class="btn btn-xs btn-primary" type="button">Ok</button>
					<button class="btn btn-xs btn-danger" type="button" onclick="location.href = 'showEmployees.do';">Cancel</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>