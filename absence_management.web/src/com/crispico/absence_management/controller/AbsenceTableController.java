package com.crispico.absence_management.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crispico.absence_management.dao.AbsenceHibernateDao;

/**
 * Servlet implementation class AbsenceTableController
 */
public class AbsenceTableController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AbsenceHibernateDao dao = new AbsenceHibernateDao();
		request.setAttribute("list", dao.getAll());
		request.getRequestDispatcher("views/absenceTable.jsp").forward(request, response);
	}
}
