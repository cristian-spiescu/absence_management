package com.crispico.absence_management.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.crispico.absence_management.HibernateUtil;
import com.crispico.absence_management.dao.AbsenceTypeHibernateDao;
import com.crispico.absence_management.model.AbsenceType;

/**
 * Servlet implementation class EmployeeTableController
 */
public class AbsenceTypeTableController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AbsenceTypeHibernateDao dao = new AbsenceTypeHibernateDao();
		List<AbsenceType> absTypes = dao.getAll();
		
		req.setAttribute("list", absTypes);
		req.getRequestDispatcher("views/typesTable.jsp").forward(req, resp);
	}
}