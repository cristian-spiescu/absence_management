package com.crispico.absence_management.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crispico.absence_management.dao.EmployeeHibernateDao;
import com.crispico.absence_management.model.Employee;

public class addEmployeeController extends HttpServlet{
	private static final long serialVersionUID = 1L;

		@Override
		public void doPost(HttpServletRequest req, HttpServletResponse res)
	        throws IOException, ServletException {

	    String fName = req.getParameter("firstName");
	    String lName = req.getParameter("lastName");
	    System.out.println("****************First = "+ fName);
		EmployeeHibernateDao dao = new EmployeeHibernateDao();
		
		Employee e = new Employee();
		e.setFirstName(fName);
		e.setLastName(lName);
		dao.save(e);
		res.sendRedirect("/showEmployees.do");
	}
}
