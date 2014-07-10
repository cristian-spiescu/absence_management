package com.crispico.absence_management;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import com.crispico.absence_management.dao.AbsenceHibernateDao;
import com.crispico.absence_management.dao.AbsenceTypeHibernateDao;
import com.crispico.absence_management.dao.EmployeeHibernateDao;
import com.crispico.absence_management.model.Absence;
import com.crispico.absence_management.model.AbsenceType;
import com.crispico.absence_management.model.Employee;

public class InsertTables {
	public void init(){
		EmployeeHibernateDao empDao = new EmployeeHibernateDao();
		
		Employee e1 = new Employee();
		e1.setFirstName("John");
		e1.setLastName("Doe");
		empDao.save(e1);
		
		Employee e2 = new Employee();
		e2.setFirstName("John");
		e2.setLastName("Ana");
		empDao.save(e2);
		
		Employee e3 = new Employee();
		e3.setFirstName("Deluis");
		e3.setLastName("Johnnatan");
		empDao.save(e3);
		
		Employee e4 = new Employee();
		e4.setFirstName("Mark");
		e4.setLastName("Louis");
		empDao.save(e4);
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");
		
		//angajat 1 - absenta 1
		AbsenceHibernateDao absDao = new AbsenceHibernateDao();
		Absence e1a1 = new Absence();
		calendar.set(Calendar.YEAR, 2014);
		calendar.set(Calendar.MONTH, 11);
		calendar.set(Calendar.DAY_OF_MONTH, 20);
		e1a1.setStartDate(format1.format(calendar.getTime()));
		calendar.set(Calendar.YEAR, 2014);
		calendar.set(Calendar.MONTH, 12);
		calendar.set(Calendar.DAY_OF_MONTH, 3);
		e1a1.setEndDate(format1.format(calendar.getTime()));
		e1a1.setEmployee(e1);
		e1.getAbsences().add(e1a1);
		
		//angajat 1 - absenta 2
		Absence e1a2 = new Absence();
		calendar.set(Calendar.YEAR, 2014);
		calendar.set(Calendar.MONTH, 4);
		calendar.set(Calendar.DAY_OF_MONTH, 10);
		e1a2.setStartDate(format1.format(calendar.getTime()));
		calendar.set(Calendar.YEAR, 2014);
		calendar.set(Calendar.MONTH, 4);
		calendar.set(Calendar.DAY_OF_MONTH, 30);
		e1a2.setEndDate(format1.format(calendar.getTime()));
		e1a2.setEmployee(e1);
		e1.getAbsences().add(e1a2);
		
		//angajat 2 - absenta 1
		Absence e2a1 = new Absence();
		calendar.set(Calendar.YEAR, 2014);
		calendar.set(Calendar.MONTH, 4);
		calendar.set(Calendar.DAY_OF_MONTH, 10);
		e2a1.setStartDate(format1.format(calendar.getTime()));
		calendar.set(Calendar.YEAR, 2014);
		calendar.set(Calendar.MONTH, 4);
		calendar.set(Calendar.DAY_OF_MONTH, 30);
		e2a1.setEndDate(format1.format(calendar.getTime()));
		e2a1.setEmployee(e2);
		e2.getAbsences().add(e2a1);
		
		//angajat 3 - absenta 1
		Absence e3a1 = new Absence();
		calendar.set(Calendar.YEAR, 2014);
		calendar.set(Calendar.MONTH, 6);
		calendar.set(Calendar.DAY_OF_MONTH, 16);
		e3a1.setStartDate(format1.format(calendar.getTime()));
		calendar.set(Calendar.YEAR, 2014);
		calendar.set(Calendar.MONTH, 6);
		calendar.set(Calendar.DAY_OF_MONTH, 30);
		e3a1.setEndDate(format1.format(calendar.getTime()));
		e3a1.setEmployee(e3);
		e3.getAbsences().add(e3a1);
		
		Absence e4a1 = new Absence();
		calendar.set(Calendar.YEAR, 2014);
		calendar.set(Calendar.MONTH, 2);
		calendar.set(Calendar.DAY_OF_MONTH, 12);
		e4a1.setStartDate(format1.format(calendar.getTime()));
		calendar.set(Calendar.YEAR, 2014);
		calendar.set(Calendar.MONTH, 2);
		calendar.set(Calendar.DAY_OF_MONTH, 18);
		e4a1.setEndDate(format1.format(calendar.getTime()));
		e4a1.setEmployee(e4);
		e4.getAbsences().add(e4a1);
		
		//inserarea tip concediu pentru absenta "a" a angajatului "e1"

		AbsenceTypeHibernateDao absTypeDao = new AbsenceTypeHibernateDao();
		AbsenceType at1 = new AbsenceType();
		at1.setDescription("Concediu Odihna");
		AbsenceType at2 = new AbsenceType();
		at2.setDescription("Concediu Medical");
		AbsenceType at3 = new AbsenceType();
		at3.setDescription("Concediu fara plata");
		
		//se seteaza tipul de absenta pentru angajati
		e1a1.setAbsenceType(at1);
		e1a2.setAbsenceType(at2);
		e2a1.setAbsenceType(at3);
		e3a1.setAbsenceType(at2);
		e4a1.setAbsenceType(at1);
		//se introduc tipurile de absente
		absTypeDao.save(at1);
		absTypeDao.save(at2);
		absTypeDao.save(at3);
		//se introduc absentele
		absDao.save(e1a1);
		absDao.save(e1a2);
		absDao.save(e2a1);
		absDao.save(e3a1);
		absDao.save(e4a1);

		HibernateUtil.getSessionFactory().close();
	}
}
