package com.crispico.absence_management.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crispico.absence_management.dao.AbsenceHibernateDao;
import com.crispico.absence_management.dao.AbsenceTypeHibernateDao;
import com.crispico.absence_management.dao.EmployeeHibernateDao;

/**
 * Servlet implementation class EditAbsenceController
 */
public class EditAbsenceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAbsenceController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AbsenceHibernateDao ahd = new AbsenceHibernateDao();
		
		String s = request.getParameter("myabs");
		int i;
		
		if (s!=null) {
			i = Integer.parseInt(s);
		}
		else {
			i = 0;
		}
		EmployeeHibernateDao ehd = new EmployeeHibernateDao();
		request.setAttribute("emp_list", ehd.getAll());
		
		AbsenceTypeHibernateDao athd = new AbsenceTypeHibernateDao();
		request.setAttribute("abs_type_list", athd.getAll());
			
		request.setAttribute("list", ahd.getAbsence(i));
		request.getRequestDispatcher("views/editAbsence.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
