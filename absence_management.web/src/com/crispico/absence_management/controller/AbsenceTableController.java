package com.crispico.absence_management.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crispico.absence_management.dao.AbsenceHibernateDao;
import com.crispico.absence_management.dao.AbsenceTypeHibernateDao;
import com.crispico.absence_management.dao.EmployeeHibernateDao;
import com.crispico.absence_management.model.Absence;
import com.crispico.absence_management.model.AbsenceType;
import com.crispico.absence_management.model.Employee;

/**
 * Servlet implementation class AbsenceTableController
 */
public class AbsenceTableController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AbsenceTableController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			AbsenceHibernateDao ahd = new AbsenceHibernateDao();
			EmployeeHibernateDao ehd = new EmployeeHibernateDao();
			AbsenceTypeHibernateDao athd = new AbsenceTypeHibernateDao();

			String s = req.getParameter("delabs");
			int i;

			if (s != null) {
				i = Integer.parseInt(s);
				if (ahd.deleteAbsence(i)) {
					req.setAttribute("message", "Absence successfully deleted.");
					req.setAttribute("m_type", "success");
				} 
				else {
					req.setAttribute("message", "Could not delete absence.");
					req.setAttribute("m_type", "danger");
				}

			} 
			else {
				String emp = req.getParameter("employees_list");
				String a = req.getParameter("absences_list");
				String d1 = req.getParameter("startd");
				String d2 = req.getParameter("endd");

				if (emp != null && a != null && d1 != null && d2 != null) {
					long iemp = Integer.parseInt(emp);
					List<Employee> employee = (List<Employee>) ehd.getEmployee(iemp);

					long iabs = Integer.parseInt(a);
					List<AbsenceType> type = (List<AbsenceType>) athd.getAbsenceType(iabs);

					Date start_date = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH).parse(d1);
					Date finish_date = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH).parse(d2);

					Absence absence = new Absence();
					absence.setEmployee(employee.get(0));
					absence.setType(type.get(0));
					absence.setStart(start_date);
					absence.setFinish(finish_date);
					if (ahd.save(absence)) {
						req.setAttribute("message", "Absence successfully added.");
						req.setAttribute("m_type", "success");
					}
					else {
						req.setAttribute("message", "Could not add absence.");
						req.setAttribute("m_type", "danger");
					}
				}
				else {
					String e_abs_id = req.getParameter("edabs");
					String e_emp = req.getParameter("e_employees_list");
					String e_a = req.getParameter("e_absences_list");
					String e_d1 = req.getParameter("e_startd");
					String e_d2 = req.getParameter("e_endd");
					
					if (e_abs_id!=null && e_emp != null && e_a != null && e_d1 != null && e_d2 != null) {
						long ia = Integer.parseInt(e_abs_id);
					
						long iemp = Integer.parseInt(e_emp);
						List<Employee> employee = (List<Employee>) ehd.getEmployee(iemp);

						long iabs = Integer.parseInt(e_a);
						List<AbsenceType> type = (List<AbsenceType>) athd.getAbsenceType(iabs);

						Date start_date = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH).parse(e_d1);
						Date finish_date = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH).parse(e_d2);

						List<Absence> absence = (List<Absence>) ahd.getAbsence(ia);
						absence.get(0).setEmployee(employee.get(0));
						absence.get(0).setType(type.get(0));
						absence.get(0).setStart(start_date);
						absence.get(0).setFinish(finish_date);
						if (ahd.editAbsence(absence.get(0))) {
							req.setAttribute("message", "Absence successfully added.");
							req.setAttribute("m_type", "success");
						}
						else {
							req.setAttribute("message", "Could not add absence.");
							req.setAttribute("m_type", "danger");
						}
					}
					else {
						req.setAttribute("message","Here is displayed information about the absences of the company's employees.");
						req.setAttribute("m_type", "info");
					}
				}
				
			}
			
			

			req.setAttribute("list", ahd.getAll());
			req.getRequestDispatcher("views/absenceTable.jsp").forward(req,resp);
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
