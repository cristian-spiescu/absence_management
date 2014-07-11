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
	
	public void deleteEmployee(Employee employee){
		dao.delete(employee.getId());
	}
	
	public long addEmployee(Employee employee){
		return dao.save(employee);
	}
	
	public List<Employee> getEmployeesByPage(int pageSize,int pageNumber){
		return dao.getPage(pageSize, pageNumber);
	}
	
	public int getNumberOfEmployees(){
		return dao.getNumberOfEmployees();
	}
	
}
