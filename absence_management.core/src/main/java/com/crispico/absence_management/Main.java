package com.crispico.absence_management;

import java.util.Calendar;

import com.crispico.absence_management.dao.AbsenceHibernateDao;
import com.crispico.absence_management.dao.AbsenceTypeHibernateDao;
import com.crispico.absence_management.dao.EmployeeHibernateDao;
import com.crispico.absence_management.model.Absence;
import com.crispico.absence_management.model.AbsenceType;
import com.crispico.absence_management.model.Employee;

public class Main {

	public static void main(String[] args) {
		
		/** POPULARE TABELA EMPLOYEE **/
		EmployeeHibernateDao dao = new EmployeeHibernateDao();
		
		Employee e1 = new Employee();
		e1.setFirstName("John");
		e1.setLastName("Doe");
		dao.save(e1);
		
		Employee e2 = new Employee();
		e2.setFirstName("Bob");
		e2.setLastName("Smith");
		dao.save(e2);
		
		Employee e3 = new Employee();
		e3.setFirstName("Jessica");
		e3.setLastName("Black");
		dao.save(e3);
		
		Employee e4 = new Employee();
		e4.setFirstName("Will");
		e4.setLastName("Cave");	
		dao.save(e4);
		
		/** POPULARE TABELA ABSENCE TYPE **/
		AbsenceTypeHibernateDao daoAT = new AbsenceTypeHibernateDao();
		
		AbsenceType at1 = new AbsenceType();
		at1.setDescription("Zi libera legal");
		daoAT.save(at1);
		
		AbsenceType at2 = new AbsenceType();
		at2.setDescription("Concediu de odihna");
		daoAT.save(at2);
		
		AbsenceType at3 = new AbsenceType();
		at3.setDescription("Concediu medical");		
		daoAT.save(at3);
		
		AbsenceType at4 = new AbsenceType();
		at4.setDescription("Absenta nemotivata");		
		daoAT.save(at4);
		
		
		/** POPULARE TABELA ABSENCE **/
		AbsenceHibernateDao daoA = new AbsenceHibernateDao();		
		Calendar cal = Calendar.getInstance();
	
		Absence a11 = new Absence();
		cal.set(Calendar.YEAR, 2014);
	    cal.set(Calendar.MONTH, 8);
	    cal.set(Calendar.DAY_OF_MONTH, 25);
		a11.setStartDate(cal.getTime());		
		cal.set(Calendar.YEAR, 2014);
	    cal.set(Calendar.MONTH, 8);
	    cal.set(Calendar.DAY_OF_MONTH, 25);		
		a11.setEndDate(cal.getTime());
		a11.setEmployee(e1);
		a11.setType(at1);
		e1.getAbsences().add(a11);
		daoA.save(a11);
		
		cal = Calendar.getInstance();
		Absence a12 = new Absence();
		cal.set(Calendar.YEAR, 2014);
	    cal.set(Calendar.MONTH, 9);
	    cal.set(Calendar.DAY_OF_MONTH, 1);
		a12.setStartDate(cal.getTime());		
		cal.set(Calendar.YEAR, 2014);
	    cal.set(Calendar.MONTH, 9);
	    cal.set(Calendar.DAY_OF_MONTH, 17);		
		a12.setEndDate(cal.getTime());
		a12.setEmployee(e1);
		a12.setType(at2);
		e1.getAbsences().add(a12);
		daoA.save(a12);
		
		cal = Calendar.getInstance();
		Absence a21 = new Absence();
		cal.set(Calendar.YEAR, 2014);
	    cal.set(Calendar.MONTH, 3);
	    cal.set(Calendar.DAY_OF_MONTH, 12);
		a21.setStartDate(cal.getTime());		
		cal.set(Calendar.YEAR, 2014);
	    cal.set(Calendar.MONTH, 3);
	    cal.set(Calendar.DAY_OF_MONTH, 17);		
		a21.setEndDate(cal.getTime());
		a21.setEmployee(e2);
		a21.setType(at3);
		e2.getAbsences().add(a21);	
		daoA.save(a21);
		
		Absence a22 = new Absence();
		cal.set(Calendar.YEAR, 2014);
	    cal.set(Calendar.MONTH, 8);
	    cal.set(Calendar.DAY_OF_MONTH, 25);
		a22.setStartDate(cal.getTime());		
		cal.set(Calendar.YEAR, 2014);
	    cal.set(Calendar.MONTH, 8);
	    cal.set(Calendar.DAY_OF_MONTH, 25);		
		a22.setEndDate(cal.getTime());
		a22.setEmployee(e2);
		a22.setType(at1);
		e2.getAbsences().add(a22);
		daoA.save(a22);
		
		Absence a31 = new Absence();
		cal.set(Calendar.YEAR, 2014);
	    cal.set(Calendar.MONTH, 8);
	    cal.set(Calendar.DAY_OF_MONTH, 25);
		a31.setStartDate(cal.getTime());		
		cal.set(Calendar.YEAR, 2014);
	    cal.set(Calendar.MONTH, 8);
	    cal.set(Calendar.DAY_OF_MONTH, 25);		
		a31.setEndDate(cal.getTime());
		a31.setEmployee(e3);
		a31.setType(at1);
		e3.getAbsences().add(a31);
		daoA.save(a31);		
		
		cal = Calendar.getInstance();
		Absence a32 = new Absence();
		cal.set(Calendar.YEAR, 2014);
	    cal.set(Calendar.MONTH, 11);
	    cal.set(Calendar.DAY_OF_MONTH, 15);
		a32.setStartDate(cal.getTime());		
		cal.set(Calendar.YEAR, 2014);
	    cal.set(Calendar.MONTH, 11);
	    cal.set(Calendar.DAY_OF_MONTH, 25);		
		a32.setEndDate(cal.getTime());
		a32.setEmployee(e3);
		a32.setType(at2);
		e3.getAbsences().add(a32);	
		daoA.save(a32);
		
		cal = Calendar.getInstance();
		Absence a33 = new Absence();
		cal.set(Calendar.YEAR, 2014);
	    cal.set(Calendar.MONTH, 2);
	    cal.set(Calendar.DAY_OF_MONTH, 6);
		a33.setStartDate(cal.getTime());		
		cal.set(Calendar.YEAR, 2014);
	    cal.set(Calendar.MONTH, 3);
	    cal.set(Calendar.DAY_OF_MONTH, 19);		
		a33.setEndDate(cal.getTime());
		a33.setEmployee(e3);
		a33.setType(at3);
		e3.getAbsences().add(a33);	
		daoA.save(a33);
		
		Absence a41 = new Absence();
		cal.set(Calendar.YEAR, 2014);
	    cal.set(Calendar.MONTH, 8);
	    cal.set(Calendar.DAY_OF_MONTH, 25);
		a41.setStartDate(cal.getTime());		
		cal.set(Calendar.YEAR, 2014);
	    cal.set(Calendar.MONTH, 8);
	    cal.set(Calendar.DAY_OF_MONTH, 25);		
		a41.setEndDate(cal.getTime());
		a41.setEmployee(e4);
		a41.setType(at1);
		e4.getAbsences().add(a41);
		daoA.save(a41);
		
		
		HibernateUtil.getSessionFactory().close();
	}
}
