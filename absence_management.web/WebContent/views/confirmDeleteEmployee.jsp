<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.crispico.absence_management.model.Employee"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirmare stergere</title>
<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap theme -->
<link href="css/bootstrap-theme.min.css" rel="stylesheet">

<script language="JavaScript">
<!--
function raspuns_nu(){
    window.location="showEmployees.do";
}

function raspuns_da(id){
	// alert("vreau sa sterg "+id);
    window.location="deleteEmployees.do?id=" + id;
}

//-->
</script>

</head>
<body>
	<!-- 
	<div id="confirm">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button class="bootbox-close-button close" aria-hidden="true"
						data-dismiss="modal" type="button">×</button>
					<h4 class="modal-title">Custom title</h4>
				</div>
				<div class="modal-body">
					<div class="bootbox-body">I am a custom dialog</div>
				</div>
				<div class="modal-footer">
					<button class="btn btn-success" type="button"
						data-bb-handler="success">Success!</button>
					<button class="btn btn-danger" type="button"
						data-bb-handler="danger">Danger!</button>
					<button class="btn btn-primary" type="button"
						data-bb-handler="main">Click ME!</button>
				</div>
			</div>
		</div>
	</div>


 -->
<div class="alert alert-warning" role="alert">
	Sunteti sigur ca vreti sa stergeti angajatul cu numele
	<% Employee employee = (Employee)request.getAttribute("employee"); %>
	<%=employee.getFirstName()%>
	<%=employee.getLastName()%>
	
	si toate informatiile lui asociate? <br /><br />
	<button class="btn btn-xs btn-warning" type="button" onclick="raspuns_nu()">Nu</button>
	<button class="btn btn-xs btn-danger" type="button" onclick="raspuns_da(<%=request.getParameter("id")%>)">Da</button>
</div>


</body>
</html>