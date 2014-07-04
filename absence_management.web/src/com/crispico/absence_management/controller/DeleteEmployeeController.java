package com.crispico.absence_management.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crispico.absence_management.dao.EmployeeHibernateDao;
import com.crispico.absence_management.model.Employee;

public class DeleteEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long deleteid = Integer.parseInt(req.getParameter("deleteid"));
		EmployeeHibernateDao dao = new EmployeeHibernateDao();
		dao.delete(deleteid);
		resp.sendRedirect("showEmployees.do");	
	}
}