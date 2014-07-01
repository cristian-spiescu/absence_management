package com.crispico.absence_management;

import java.util.List;

import com.crispico.absence_management.dao.EmployeeHibernateDao;
import com.crispico.absence_management.model.Employee;

public class Main {

	public static void main(String[] args) {
		EmployeeHibernateDao dao = new EmployeeHibernateDao();
		
		Employee e = new Employee();
		e.setFirstName("John");
		e.setLastName("Doe");
		dao.save(e);
		
		List<Employee> employees = dao.getAll();
		for (Employee employee : employees) {
			System.out.println(employee);
		}
		
		HibernateUtil.getSessionFactory().close();
	}

}
