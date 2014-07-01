package com.crispico.absence_management;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorldServlet
 */
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();

	    out.println("<html>");
	    out.println("<head>");
	    out.println("<title>Hola</title>");
	    out.println("</head>");
	    out.println("<body bgcolor=\"white\">");
	    out.println("Salutari! Eu sunt un text dinamic. Iata dovada: " + new Date());
	    out.println("</body>");
	    out.println("</html>");
	}

}
