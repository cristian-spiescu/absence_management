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
	
	public void deleteEmployee(long id) {
		dao.delete(id + "");
	}
	
	public long addEmployee(Employee e) {
		return dao.save(e);
	}
	
	public List<Absence> getAbsencesByEmployee(Employee emp){
		List<Absence> l = new ArrayList<Absence>();
		if(emp.getAbsences() != null)
			l.addAll(emp.getAbsences());
		return l;
	}
	
	public void updateEmployee(Long id, String firstName, String lastName){
		dao.updateEmployee(id, firstName, lastName);
	}
}
