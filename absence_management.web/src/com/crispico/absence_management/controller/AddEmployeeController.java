package com.crispico.absence_management.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crispico.absence_management.dao.EmployeeHibernateDao;
import com.crispico.absence_management.model.Employee;

public class AddEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fname=req.getParameter("a");
		String lname=req.getParameter("b");
		EmployeeHibernateDao dao = new EmployeeHibernateDao();
		
		if(fname!=null && lname !=null)
		{
			Employee e = new Employee();
			e.setFirstName(fname);
			e.setLastName(lname);
			dao.save(e);
		}
		resp.sendRedirect("showEmployees.do");
	}
}
	