package com.crispico.absence_management.controller;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.crispico.absence_management.dao.EmployeeHibernateDao;
import com.crispico.absence_management.model.Employee;

/**
 * Servlet implementation class EmployeeTableController
 */
public class EmployeeTableController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Employee> listEmp = new ArrayList<Employee>();  
		EmployeeHibernateDao dao = new EmployeeHibernateDao();
		listEmp = dao.getAll();
		req.setAttribute("employeeList", listEmp);
		req.getRequestDispatcher("views/employeeTable.jsp").forward(req, resp);
	}
}
