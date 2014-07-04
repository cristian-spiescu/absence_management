<%@page import="com.crispico.absence_management.model.Absence, org.hibernate.*, com.crispico.absence_management.HibernateUtil"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Delete id
	<%=request.getParameter("id")%>
	<%
    	Session sess = HibernateUtil.getSessionFactory().getCurrentSession();
		long id = Integer.parseInt(request.getParameter("id"));

		try {
			sess.beginTransaction();
			Absence absence = (Absence) sess.get(Absence.class, id);
			sess.delete(absence);
			sess.getTransaction().commit();
            System.out.println("siii ti-am sters absenta :D");
		} catch (HibernateException e) {
			e.printStackTrace();
			sess.getTransaction().rollback();
		}
	%>
</body>
</html>