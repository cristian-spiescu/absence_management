package com.crispico.absence_management.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crispico.absence_management.dao.EmployeeHibernateDao;

/**
 * Servlet implementation class DeleteEmployeeController
 */
public class DeleteEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String paramValue = req.getParameter("id");	
		EmployeeHibernateDao dao = new EmployeeHibernateDao();
		
//		PrintWriter iesire = resp.getWriter();
//		iesire.println(Long.valueOf(paramValue).longValue());
//		iesire.close();
		long parameter = Long.valueOf(paramValue);
		
		dao.delete(parameter);
		
		resp.sendRedirect("showEmployees.do");
	}
}
