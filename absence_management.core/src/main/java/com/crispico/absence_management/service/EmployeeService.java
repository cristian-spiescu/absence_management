package com.crispico.absence_management.service;

import java.util.List;

import com.crispico.absence_management.dao.EmployeeHibernateDao;
import com.crispico.absence_management.model.Employee;


public class EmployeeService {

	protected EmployeeHibernateDao dao = new EmployeeHibernateDao();
	protected Employee e = new Employee();
	
	public String sayHello(String name) {
		System.out.println(name);
		return "Hello " + name;
	}
	
	public List<Employee> getAllEmployees() {
		return EmployeeHibernateDao.getAll();
	}
	
	public void save(Employee employee) {
		dao.save(employee);
	}
	
	public void deleteEmp(Employee employee){
		dao.delete(employee);
	}
	
	public void edit(Employee employee){
		dao.update(employee);
	}
	
		
}
