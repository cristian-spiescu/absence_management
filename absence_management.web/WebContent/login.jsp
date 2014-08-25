<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Login</title>
    </head>
    <body>
        <form action="/absence_management.web/userValidator" method="post">
            Username: <input type="text" name="name"/>
            Password: <input type="password" name="password"/>
            <br/>
            <input type="submit" value="LogIn"/>
            <br/>
            <% String fbURL = "http://www.facebook.com/dialog/oauth?client_id=714528398641253&redirect_uri=http://localhost:8080/absence_management.web/userValidator" + "&scope=email";%>
			<a href="<%= fbURL %>">Login with Facebook</a>            
        </form>
    </body>
</html>