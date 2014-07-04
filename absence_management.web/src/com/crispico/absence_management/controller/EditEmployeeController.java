package com.crispico.absence_management.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.crispico.absence_management.dao.EmployeeHibernateDao;
import com.crispico.absence_management.model.Employee;
import com.google.gson.Gson;

/**
 * Servlet implementation class EmployeeTableController
 */
public class EditEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		EmployeeHibernateDao ehd = new EmployeeHibernateDao();
		long employeeId = Integer.parseInt(req.getParameter("employeeId"));
		Employee emp = ehd.getEmployeeById(employeeId);
	    JSONObject a =new JSONObject();
	    try {
			a.put("firstName",emp.getFirstName());
			a.put("lastName",emp.getLastName());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    resp.setContentType("application/json");
	    resp.setCharacterEncoding("UTF-8");
		
	    resp.getWriter().write(a.toString());
	}

}
