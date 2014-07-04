package com.crispico.absence_management;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import com.crispico.absence_management.dao.AbsenceHibernateDao;
import com.crispico.absence_management.dao.AbsenceTypeHibernateDao;
import com.crispico.absence_management.dao.EmployeeHibernateDao;
import com.crispico.absence_management.model.Absence;
import com.crispico.absence_management.model.AbsenceType;
import com.crispico.absence_management.model.Employee;

public class Main {

	public static void main(String[] args) {
		EmployeeHibernateDao dao = new EmployeeHibernateDao();
		AbsenceHibernateDao daoabs = new AbsenceHibernateDao();
		AbsenceTypeHibernateDao daoty = new AbsenceTypeHibernateDao();
		
		Employee e = new Employee();
		e.setFirstName("Johnanna");
		e.setLastName("Doe");
		dao.save(e);
		String str = "January 2, 2010";
		Date date = new Date();
		try {
			date = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(str);
		} catch (ParseException e1) {
			System.out.println("Date parsing exception!");
			e1.printStackTrace();
		}
		
		List<Employee> employees = dao.getAll();
		AbsenceType at = new AbsenceType();
		at.setAbsenceType("Tip");
		
		daoty.save(at);
		for (Employee employee : employees) {
			Set<Absence> absences = new HashSet<Absence>();
			Absence abs = new Absence();
			abs.setEmployee(employee);
			abs.setEndDate(date);
			abs.setStartDate(date);
			abs.setAbsenceType(at);
			absences.add(abs);
			employee.setAbsences(absences);
			daoabs.save(abs);		
			System.out.println(employee);
			System.out.println("**"+employee.printAbsences());
		}
	
		
		
		for(Absence absence : daoabs.getAll()){
			System.out.println(absence);
		}
		//long aux = 79;
		//dao.delete(aux);
		HibernateUtil.getSessionFactory().close();
	}

}
