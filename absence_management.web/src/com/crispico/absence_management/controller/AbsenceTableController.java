package com.crispico.absence_management.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.crispico.absence_management.dao.AbsenceHibernateDao;
import com.crispico.absence_management.model.Absence;

/**
 * Servlet implementation class AbsenceTableController
 */
public class AbsenceTableController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Absence> listAbs = new ArrayList<Absence>();  
		AbsenceHibernateDao dao = new AbsenceHibernateDao();
		listAbs = dao.getAll();
		req.setAttribute("absenceList", listAbs);
		req.getRequestDispatcher("views/absencesTable.jsp").forward(req, resp);
	}

}
