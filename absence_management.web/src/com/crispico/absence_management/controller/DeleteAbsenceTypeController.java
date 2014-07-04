package com.crispico.absence_management.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crispico.absence_management.dao.AbsenceTypeHibernateDao;
import com.crispico.absence_management.model.AbsenceType;

/**
 * Servlet implementation class EmployeeTableController
 */
public class DeleteAbsenceTypeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		AbsenceTypeHibernateDao athd = new AbsenceTypeHibernateDao();
		long typeId = Integer.parseInt(req.getParameter("typeId"));
		AbsenceType at = athd.getAbsenceTypeById(typeId);
		athd.delete(at);
		resp.sendRedirect("/absence_management.web/showAbsenceTypes.do");
	}

}
