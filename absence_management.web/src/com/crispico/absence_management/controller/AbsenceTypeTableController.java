package com.crispico.absence_management.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crispico.absence_management.dao.EmployeeHibernateDao;
import com.crispico.absence_management.model.AbsenceType;

/**
 * Servlet implementation class EmployeeTableController
 */
public class AbsenceTypeTableController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		EmployeeHibernateDao ehd = new EmployeeHibernateDao();
		List<AbsenceType> list = ehd.getAbsenceTypes();
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("views/absenceTypeTable.jsp").forward(req, resp);
	}

}
