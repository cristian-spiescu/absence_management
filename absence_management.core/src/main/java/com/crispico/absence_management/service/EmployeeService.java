package com.crispico.absence_management.service;

import java.util.ArrayList;
import java.util.List;

import com.crispico.absence_management.dao.EmployeeHibernateDao;
import com.crispico.absence_management.model.Absence;
import com.crispico.absence_management.model.Employee;

public class EmployeeService {

	protected EmployeeHibernateDao dao = new EmployeeHibernateDao();
	
	public String sayHello(String name) {
		System.out.println(name);
		return "Hello " + name;
	}
	
	public List<Employee> getAllEmployees() {
		return dao.getAll();
	}
	
	public void saveEmployee(Employee employee){
		dao.save(employee);
	}
	
	public void deleteEmployee(Employee employee){
		dao.delete(Long.toString(employee.getId()));
	}
}
