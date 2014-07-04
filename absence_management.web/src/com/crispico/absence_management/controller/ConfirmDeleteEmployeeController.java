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
 * Servlet implementation class ConfirmDeleteEmployeeController
 */
public class ConfirmDeleteEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// da-i ca parametru un employee, ca sa pot sa-i afisez datele la
		// confirm
		Session sess;
		sess = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			long id = Integer.parseInt(request.getParameter("id"));
			// vreau sa sterg un employee => ii sterg intai lista de absente
			sess.beginTransaction();
			Employee employee = (Employee) sess.get(Employee.class, id);
			sess.getTransaction().commit();
		    request.setAttribute("employee", employee);
		} catch (HibernateException e) {
			e.printStackTrace();
			sess.getTransaction().rollback();
		}
		request.getRequestDispatcher("views/confirmDeleteEmployee.jsp").forward(request, response);
	}

}
