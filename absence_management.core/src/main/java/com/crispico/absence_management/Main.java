package com.crispico.absence_management;

import java.util.Date;
import java.util.List;

import com.crispico.absence_management.dao.AbsenceHibernateDao;
import com.crispico.absence_management.dao.AbsenceTypeHibernateDao;
import com.crispico.absence_management.dao.EmployeeHibernateDao;
import com.crispico.absence_management.model.Absence;
import com.crispico.absence_management.model.AbsenceType;
import com.crispico.absence_management.model.Employee;

public class Main {

	public static void main(String[] args) {
		EmployeeHibernateDao dao = new EmployeeHibernateDao();
		AbsenceTypeHibernateDao athd = new AbsenceTypeHibernateDao();
		AbsenceHibernateDao ahd = new AbsenceHibernateDao();
		
		for(int i=0;i<3;i++){
			Employee emp = new Employee();
			emp.setFirstName("John"+i);
			emp.setLastName("Doe"+i);
			dao.save(emp);
		}
		String[] types={"concediu medical", "concediu de odihna"};
		for(int i=0;i<types.length;i++){
			AbsenceType at = new AbsenceType();
			at.setType(types[i]);
			athd.save(at);
		}
		

		List<Employee> emps = dao.getAll();
		for(int i=0;i<emps.size();i++){
			Employee emp = emps.get(i);
			List<AbsenceType> ats = athd.getAbsenceTypes();
			AbsenceType at = ats.get(0);
			Absence a = new Absence();
			a.setStartDate(new Date());
			a.setEndDate(new Date());
			a.setEmployee(emp);
			a.setType(at);
			ahd.save(a);
		
		}
		
		
	}

}
