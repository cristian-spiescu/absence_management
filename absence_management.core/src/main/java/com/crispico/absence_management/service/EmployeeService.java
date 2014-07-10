package com.crispico.absence_management.service;

import java.util.ArrayList;
import java.util.List;
import com.crispico.absence_management.dao.AbsenceHibernateDao;
import com.crispico.absence_management.dao.EmployeeHibernateDao;
import com.crispico.absence_management.model.Absence;
import com.crispico.absence_management.model.Employee;

public class EmployeeService {

	protected EmployeeHibernateDao dao = new EmployeeHibernateDao();
	protected AbsenceHibernateDao daoAbs = new AbsenceHibernateDao();
	
	public List<Employee> getAllEmployees() {
		return dao.getAll();
	}
	public void deleteEmployee(long deleteid){
		dao.delete(deleteid);
	}
	public void editEmployee(long editid, String fname, String lname){
		dao.update(editid,fname,lname);
	}
	public void addEmployee(String fname, String lname){
		Employee e = new Employee();
		e.setFirstName(fname);
		e.setLastName(lname);
		dao.save(e);
	}
	
	public List<Absence> getEmployeeAbsences(long id){
		List<Employee> employees = new ArrayList<Employee>();
		employees = dao.getAll();
		List<Absence> absences = new ArrayList<Absence>();
		for(Employee emp:employees)
			if(emp.getId() == id)
					absences.addAll(emp.getAbsences());
		return absences;
	}
}
