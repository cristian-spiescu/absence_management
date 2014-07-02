package com.crispico.absence_management;

import java.util.Date;
import java.util.List;

import com.crispico.absence_management.dao.EmployeeHibernateDao;
import com.crispico.absence_management.model.Absence;
import com.crispico.absence_management.model.Employee;

public class Main {

	public static void main(String[] args) {
		EmployeeHibernateDao dao = new EmployeeHibernateDao();
		

		List<Employee> emps = dao.getAll();
		Employee emp = emps.get(0);
		Absence e = new Absence();
		e.setStartDate(new Date());
		e.setEndDate(new Date());
		e.setEmployee(emp);
		dao.save(e);
//		
//		List <Absence> abs = dao.getAbsences();
//		for (Absence a : abs) {
//			System.out.println(a);
//		}
		for(Absence a: emp.getAbsences()){
			System.out.println(a);
		}

	}

}
