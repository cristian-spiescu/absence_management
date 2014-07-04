package com.crispico.absence_management.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crispico.absence_management.dao.AbsenceHibernateDao;

public class AbsenceTableController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		AbsenceHibernateDao abs = new AbsenceHibernateDao();
		req.setAttribute("list", abs.getAll());
		req.getRequestDispatcher("views/absenceTable.jsp").forward(req, resp);
	}

}
