package com.crispico.absence_management.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crispico.absence_management.dao.EmployeeHibernateDao;
import com.crispico.absence_management.model.Absence;
import com.crispico.absence_management.model.Employee;

/**
 * Servlet implementation class EmployeeTableController
 */
public class EmployeeTableController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		List<Employee> list = new ArrayList<>();
//		for (int i = 0; i < 15; i++) {
//			Employee employee = new Employee();
//			employee.setFirstName("First " + i);
//			employee.setLastName("Last " + i);
//			list.add(employee);
//		}
		EmployeeHibernateDao ehd = new EmployeeHibernateDao();
		
		String s = req.getParameter("delemp");
		int i;
		
		if (s!=null) {
			i = Integer.parseInt(s);
			if (ehd.deleteEmployee(i)) {
				req.setAttribute("message", "Employee successfully deleted.");
				req.setAttribute("m_type", "success");
			}
			else {
				req.setAttribute("message", "Could not delete employee.");
				req.setAttribute("m_type", "danger");
			}
				
		}
		else {
			String s1 = req.getParameter("name");
			String s2 = req.getParameter("fname");
			
			if (s1!=null && s2!=null) {
				Employee emp = new Employee();
				emp.setFirstName(s2);
				emp.setLastName(s1);
				Set<Absence> l = new HashSet<Absence>();
				emp.setAbsences(l);
				if (ehd.save(emp)) {
					req.setAttribute("message", "Employee successfully added.");
					req.setAttribute("m_type", "success");
				}
				else {
					req.setAttribute("message", "Could not add employee.");
					req.setAttribute("m_type", "danger");
				}
					
			}
			else {
				String es1 = req.getParameter("ename");
				String es2 = req.getParameter("efname");
				String eid = req.getParameter("edemp");
				
				if (es1!=null && es2!=null && eid!=null) {
					long j = Integer.parseInt(eid);
					
					if (ehd.editEmployee(j, es2, es1)) {
						req.setAttribute("message", "Employee personal information successfully edited.");
						req.setAttribute("m_type", "success");
					}
					else {
						req.setAttribute("message", "Could not edit employee personal information.");
						req.setAttribute("m_type", "danger");
					}
						
				}
				else {
					req.setAttribute("message", "Here is displayed personal information about the company's employees.");
					req.setAttribute("m_type", "info");
				}
			}
		}
			
		
		
	
		req.setAttribute("list", ehd.getAll());
		req.getRequestDispatcher("views/employeeTable.jsp").forward(req, resp);
	}

}
