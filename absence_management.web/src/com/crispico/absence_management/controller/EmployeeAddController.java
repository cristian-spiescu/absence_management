package com.crispico.absence_management.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeTableController
 */
public class EmployeeAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
//		String f = req.getParameter("firstname");
//		System.out.println(f);
//		
		req.getRequestDispatcher("views/addEmployee.jsp").forward(req, response);		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    String fname = req.getParameter("firstname");
	    System.out.println(fname);
	}
	
	

}
