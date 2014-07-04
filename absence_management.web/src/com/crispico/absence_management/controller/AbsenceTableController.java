package com.crispico.absence_management.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crispico.absence_management.dao.AbsenceHibernateDao;
import com.crispico.absence_management.model.Absence;

public class AbsenceTableController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AbsenceHibernateDao aDao = new AbsenceHibernateDao();
		//List<Employee> list = new ArrayList<>();
		List<Absence> list = aDao.getAll();
//		for (int i = 0; i < 15; i++) {
//			Employee employee = new Employee();
//			employee.setFirstName("First " + i);
//			employee.setLastName("Last " + i);
//			list.add(employee);
//		}
		req.setAttribute("list", list);
		req.getRequestDispatcher("views/AbsenceTable.jsp").forward(req, resp);
	}

}
