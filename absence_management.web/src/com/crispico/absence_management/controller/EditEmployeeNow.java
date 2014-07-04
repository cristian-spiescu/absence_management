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
 * Servlet implementation class EditEmployeeNow
 */
public class EditEmployeeNow extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Session sess;
		sess = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			// oki, chiar vrea sa-l stearga
			// il sterg aici, apoi il redirectez la show
			long id = Integer.parseInt(request.getParameter("id"));
			// vreau sa sterg un employee => ii sterg intai lista de absente
			sess.beginTransaction();
			Employee employee = (Employee) sess.get(Employee.class, id);

			sess.delete(employee); // absentele le sterge singur, automat

			// asentele, pt ca aveam delete cascade
			sess.getTransaction().commit();
			// System.out.println("Am sters angajatul");
			// System.out.println("aici ajung");
		} catch (HibernateException e) {
			e.printStackTrace();
			sess.getTransaction().rollback();
		} catch (Exception e) {
			System.out.println("am murit " + e);
		}
		response.sendRedirect("showEmployees.do");

	}

}
