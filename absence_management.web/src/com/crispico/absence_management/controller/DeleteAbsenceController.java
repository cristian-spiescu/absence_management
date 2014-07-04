package com.crispico.absence_management.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crispico.absence_management.dao.AbsenceHibernateDao;
import com.crispico.absence_management.model.Absence;

/**
 * Servlet implementation class EmployeeTableController
 */
public class DeleteAbsenceController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		AbsenceHibernateDao ahd = new AbsenceHibernateDao();
		long absenceId = Integer.parseInt(req.getParameter("absenceId"));
		Absence absence = ahd.getAbsenceById(absenceId);
		ahd.delete(absence);
		resp.sendRedirect("/absence_management.web/showAbsences.do");
	}

}
