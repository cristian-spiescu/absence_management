package com.crispico.absence_management.service;

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
	
	public Employee addEmployee(String fn, String ln) {
		Employee employee = new Employee();
		employee.setFirstName(fn);
		employee.setLastName(ln);
//		if (dao.save(employee)) {
//			return employee;
//		}
//		return null;	
		return dao.saveAndGet(employee);
	}
	
	public boolean editEmployee(Employee emp) {
		
		return dao.editEmployee(emp.getId(),emp.getFirstName(), emp.getLastName());
		
	}
	
	public boolean deleteEmployee(long i) {
		
		return dao.deleteEmployee(i);
		
	}
	
	public long howMany(String s) {
		return dao.howManyEmployees(s);
		
	}
	
	public List<Employee> getEmployeesFromTo(int i) {
		return dao.getFromTo(i);
	}
	
	public List<Employee> searchEmployee(String s,int i) {
		return dao.searchEmployee(s,i);
	}
}
