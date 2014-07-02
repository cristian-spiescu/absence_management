package com.crispico.absence_management;

import java.util.Date;
import java.util.List;

import com.crispico.absence_management.dao.EmployeeHibernateDao;
import com.crispico.absence_management.model.Absence;
import com.crispico.absence_management.model.AbsenceType;
import com.crispico.absence_management.model.Employee;

public class Main {

	public static void main(String[] args) {
		EmployeeHibernateDao dao = new EmployeeHibernateDao();
		

		List<Employee> emps = dao.getAll();
		for(int i=0;i<emps.size();i++){
			Employee emp = emps.get(i);
			List<AbsenceType> ats = dao.getAbsenceTypes();
			AbsenceType at = ats.get(0);
			Absence e = new Absence();
			e.setStartDate(new Date());
			e.setEndDate(new Date());
			e.setEmployee(emp);
			e.setType(at);
			dao.save(e);
		
		}
		
//		List <AbsenceType> abs = dao.getAbsenceTypes();
//		for (AbsenceType at : abs) {
//			System.out.println(at);
//		}
//		for(Absence a: emp.getAbsences()){
//			System.out.println(a);
//		}
		
	}

}
