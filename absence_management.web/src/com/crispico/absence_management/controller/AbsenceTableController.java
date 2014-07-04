package com.crispico.absence_management.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crispico.absence_management.dao.AbsenceHibernateDao;
import com.crispico.absence_management.model.Absence;

/**
 * Servlet implementation class EmployeeTableController
 */
public class AbsenceTableController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AbsenceHibernateDao dao = new AbsenceHibernateDao();
		List<Absence> list = dao.getAll();
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("views/absenceTable.jsp").forward(req, resp);
	}

}
