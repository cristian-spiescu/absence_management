<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.crispico.absence_management.model.Employee"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit employee</title>
<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap theme -->
<link href="css/bootstrap-theme.min.css" rel="stylesheet">

<script language="JavaScript">
<!--
	function anuleaza() {
		window.location = "showEmployees.do";
	}

	function editeaza_angajat(id) {
		// alert("vreau sa sterg "+id);
		window.location = "editEmployeeForm.do?id=" + id;
	}
//-->
</script>

</head>
<body>
	<%
		Employee employee = (Employee) request.getAttribute("employee");
	%>

	<p>
	<div class="alert alert-warning" role="alert">
		<strong> Editeaza date angajat </strong><br />
		<table>
			<tr>
				<td>Prenume:</td>
				<td><input value="<%=employee.getFirstName()%>" type="text"
					id="firstname" /></td>
			</tr>
			<tr>
				<td>Nume:</td>
				<td><input value="<%=employee.getLastName()%>" type="text"
					id="lastname" /></td>
			</tr>
			<tr>
				<td><input type="button" value="Adauga"
					onclick="editeaza_angajat(<%=request.getParameter("id") %>)"></td>
				<td><input type="button" value="Anuleaza"
					onclick="anuleaza()"></td>
			</tr>
		</table>
	</div>
	</p>


</body>
</html>