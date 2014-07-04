package com.crispico.absence_management.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.crispico.absence_management.HibernateUtil;
import com.crispico.absence_management.model.Employee;

/**
 * Servlet implementation class EditEmployee
 */
public class EditEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// stiu ce employee.... hai sa i-l dam, ca sa poata sa-l editeze
		Session sess;
		sess = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			long id = Integer.parseInt(request.getParameter("id"));
			sess.beginTransaction();
			Employee employee = (Employee) sess.get(Employee.class, id);
			sess.getTransaction().commit();
		    request.setAttribute("employee", employee);
		} catch (HibernateException e) {
			e.printStackTrace();
			sess.getTransaction().rollback();
		}

		request.getRequestDispatcher("views/editEmployee.jsp").forward(request, response);
	}
}
