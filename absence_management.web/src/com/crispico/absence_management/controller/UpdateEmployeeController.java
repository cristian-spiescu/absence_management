package com.crispico.absence_management.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crispico.absence_management.dao.EmployeeHibernateDao;
import com.crispico.absence_management.model.Employee;

/**
 * Servlet implementation class EmployeeTableController
 */
public class UpdateEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		EmployeeHibernateDao ehd = new EmployeeHibernateDao();
		long employeeId = Integer.parseInt(req.getParameter("employeeId"));
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		Employee emp = ehd.getEmployeeById(employeeId);
		emp.setFirstName(firstName);
		emp.setLastName(lastName);
		ehd.update(emp);
		resp.sendRedirect("/absence_management.web/showEmployees.do");
	}

}
