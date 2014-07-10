<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form class="form-horizontal" role="form" action="addEmployee.do"
		method="POST">
		<div class="form-group">
			<label for="inputEmail3" class="col-sm-2 control-label ">FirstName</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="first" name = "firstName" placeholder="">
			</div>
			<label for="inputPassword3" class="col-sm-2 control-label">LastName</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="last" name = "lastName" placeholder="">
			</div>
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Add</button>
			</div>
		</div>



	</form>
</body>
</html>