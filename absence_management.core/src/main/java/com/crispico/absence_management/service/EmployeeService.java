package com.crispico.absence_management.service;

import java.util.List;

import com.crispico.absence_management.dao.EmployeeHibernateDao;
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
	
	public void deleteEmployee(long id){
		Employee employee = dao.getEmployeeById(id);
		dao.delete(employee);
	}
	
	public Employee addEmployee(Employee employee){
		dao.save(employee);
		return employee;
	}
	public void updateEmployee(Employee employee){
		dao.update(employee);
	}
}
