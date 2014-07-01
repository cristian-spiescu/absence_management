package com.crispico.absence_management.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crispico.absence_management.model.Employee;

/**
 * Servlet implementation class EmployeeTableController
 */
public class EmployeeTableController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Employee> list = new ArrayList<>();
		for (int i = 0; i < 15; i++) {
			Employee employee = new Employee();
			employee.setFirstName("First " + i);
			employee.setLastName("Last " + i);
			list.add(employee);
		}
		req.setAttribute("list", list);
		req.getRequestDispatcher("views/employeeTable.jsp").forward(req, resp);
	}

}
