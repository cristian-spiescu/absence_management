package com.crispico.absence_management.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crispico.absence_management.dao.AbsenceTypeHibernateDao;
import com.crispico.absence_management.model.AbsenceType;

public class DeleteAbsenceTypeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long typeId = Integer.parseInt(req.getParameter("absenceTypeId"));
		AbsenceTypeHibernateDao absDao = new AbsenceTypeHibernateDao(); 
		AbsenceType abs = AbsenceTypeHibernateDao.getAbsenceTypeById(typeId);
		absDao.delete(abs);
		resp.sendRedirect("/absence_management.web/showAbsencesType.do");
	}


}
