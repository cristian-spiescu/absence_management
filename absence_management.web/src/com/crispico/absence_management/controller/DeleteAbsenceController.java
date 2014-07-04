package com.crispico.absence_management.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crispico.absence_management.dao.AbsenceHibernateDao;
import com.crispico.absence_management.dao.AbsenceTypeHibernateDao;
import com.crispico.absence_management.model.Absence;
import com.crispico.absence_management.model.AbsenceType;

public class DeleteAbsenceController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long absId = Integer.parseInt(req.getParameter("absenceId"));
		AbsenceHibernateDao absDao = new AbsenceHibernateDao(); 
		Absence abs = AbsenceHibernateDao.getAbsenceById(absId);
		absDao.delete(abs);
		resp.sendRedirect("/absence_management.web/showAbsences.do");
	}

}
