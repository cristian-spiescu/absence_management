package com.crispico.absence_management;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.crispico.absence_management.dao.AbsenceHibernateDao;
import com.crispico.absence_management.dao.AbsenceTypeHibernateDao;
import com.crispico.absence_management.dao.EmployeeHibernateDao;
import com.crispico.absence_management.model.Absence;
import com.crispico.absence_management.model.AbsenceType;
import com.crispico.absence_management.model.Employee;

public class Main {

	public static void main(String[] args) {
		/*	
		 *	insert employee
		 *	
		 */
		
		//EmployeeHibernateDao dao = new EmployeeHibernateDao();
//		
//		Employee e = new Employee();
//		e.setFirstName("John");
//		e.setLastName("Doe");
//		dao.save(e);
		
//		List<Employee> employees = dao.getAll();
//		for (Employee employee : employees) {
//			System.out.println(employee);
//		}
		
		/*	
		 *	insert absence type
		 *	
		 */
		
		//AbsenceTypeHibernateDao athd = new AbsenceTypeHibernateDao();
//		
//		AbsenceType at = new AbsenceType();
//		at.setType("Concediu medical");
//		athd.save(at);
//		
//		List<AbsenceType> types = athd.getAll();
//		for (AbsenceType tip : types) {
//			System.out.println(tip);
//		}
		
		/*	
		 *	insert absence with employee
		 *	
		 */
		
//		Date myStart;
//        Calendar cal = Calendar.getInstance();
//        cal.set(Calendar.MONTH, 8);
//        cal.set(Calendar.DATE, 24);
//        cal.set(Calendar.YEAR, 2014);
//        cal.set(Calendar.HOUR,9);
//        cal.set(Calendar.MINUTE,00);
//        cal.set(Calendar.SECOND,00);
//        myStart = cal.getTime();
//        
//        Date myEnd;
//        Calendar cal1 = Calendar.getInstance();
//        cal1.set(Calendar.MONTH, 8);
//        cal1.set(Calendar.DATE, 31);
//        cal1.set(Calendar.YEAR, 2014);
//        cal1.set(Calendar.HOUR,18);
//        cal1.set(Calendar.MINUTE,00);
//        cal1.set(Calendar.SECOND,00);
//        myEnd = cal1.getTime();
//        
//        
        
//        EmployeeHibernateDao ehd = new EmployeeHibernateDao();
//        Employee emp = new Employee();
//        emp.setFirstName("Vasile");
//        emp.setLastName("Alecsandri");
//        
//        AbsenceTypeHibernateDao athd = new AbsenceTypeHibernateDao();
//		AbsenceType at = athd.getAbsenceType(2);
//		System.out.print(at.toString());
//        
//        AbsenceType at = new AbsenceType();
//        at.setType("Concediu fara plata");
//        athd.save(at);
//        
//		AbsenceHibernateDao ahd = new AbsenceHibernateDao();
//		
//		Absence ar = new Absence();
//		ar.setType(at);
//		ar.setStart(myStart);
//		ar.setFinish(myEnd);
//		
//		
//		
//		emp.addToAbsences(ar);
//		ehd.save(emp);
//		ahd.save(ar);
		
//		List<Absence> types = ahd.getAll();
//		for (Absence tip : types) {
//			System.out.println(tip);
//		}
		
		EmployeeHibernateDao ehd = new EmployeeHibernateDao();
		List<Employee> e1 = ehd.getEmployee(1);
		System.out.print(e1.toString());
		
		AbsenceTypeHibernateDao athd = new AbsenceTypeHibernateDao();
		List<AbsenceType> at = athd.getAbsenceType(2);
		
		AbsenceHibernateDao ahd = new AbsenceHibernateDao();
		Absence ar = new Absence();
		ar.setEmployee(e1.get(0));
		ar.setType(at.get(0));
				
		Date myStart;
      Calendar cal = Calendar.getInstance();
      cal.set(Calendar.MONTH, 8);
      cal.set(Calendar.DATE, 24);
      cal.set(Calendar.YEAR, 2014);
      cal.set(Calendar.HOUR,9);
      cal.set(Calendar.MINUTE,00);
      cal.set(Calendar.SECOND,00);
      myStart = cal.getTime();
      
      Date myEnd;
      Calendar cal1 = Calendar.getInstance();
      cal1.set(Calendar.MONTH, 8);
      cal1.set(Calendar.DATE, 31);
      cal1.set(Calendar.YEAR, 2014);
      cal1.set(Calendar.HOUR,18);
      cal1.set(Calendar.MINUTE,00);
      cal1.set(Calendar.SECOND,00);
      myEnd = cal1.getTime();
      
      ar.setStart(myStart);
		ar.setFinish(myEnd);
		
	
	ahd.save(ar);	
	e1.get(0).addToAbsences(ar);	
	List<Absence> types = ahd.getAll();
	for (Absence tip : types) {
		System.out.println(tip);
	}
	
	List<Employee> eee = ehd.getAll();
	for (Employee tip : eee) {
		System.out.println(tip);
	}
	
		HibernateUtil.getSessionFactory().close();
	}

}
