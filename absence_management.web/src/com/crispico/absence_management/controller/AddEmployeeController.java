package com.crispico.absence_management.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.crispico.absence_management.HibernateUtil;
import com.crispico.absence_management.model.Employee;

/**
 * Servlet implementation class AddEmployeeController
 */
public class AddEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// il adaug, apoi il retrimit la tabela cu angajati
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Employee e = new Employee();
		e.setFirstName(request.getParameter("firstname"));
		e.setLastName(request.getParameter("lastname"));
        session.save(e);

        session.getTransaction().commit();

		//request.getRequestDispatcher("views/employeeTable.jsp").forward(request, response);
		// request.getRequestDispatcher("/showEmployees.do").forward(request, response);
		response.sendRedirect("showEmployees.do");
	}

}
