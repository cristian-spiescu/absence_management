package com.crispico.absence_management;

import java.util.List;

import com.crispico.absence_management.dao.AbsenceHibernateDao;
import com.crispico.absence_management.dao.AbsenceTypeHibernateDao;
import com.crispico.absence_management.dao.EmployeeHibernateDao;
import com.crispico.absence_management.model.AbsenceType;
import com.crispico.absence_management.model.Employee;

public class Main {

	public static void main(String[] args) {
		EmployeeHibernateDao dao = new EmployeeHibernateDao();
		
//		Employee e = new Employee();
//		e.setFirstName("John");
//		e.setLastName("Doe");
//		dao.save(e);
		
		List<Employee> employees = EmployeeHibernateDao.getAll();
		Employee emp =  employees.get(0);
//		for (Employee employee : employees) {
//			System.out.println(employee);
//		}
		///-------Absence-----------------------
		
		AbsenceHibernateDao daoA = new AbsenceHibernateDao();
		
//		Calendar cal = Calendar.getInstance();
//		cal.set(2009, 11, 9); //year is as expected, month is zero based, date is as expected
//		Date dt = cal.getTime();
//		
		List <AbsenceType> absenceT = AbsenceTypeHibernateDao.getAll();
		
		AbsenceType abst = absenceT.get(0); 
//		
//		Absence a = new Absence();
//		a.setEmployee(emp);
//		a.setStartDate(dt);
//		a.setEndDate(dt);
//		a.setAbsenceType(abst);
//		
//		daoA.save(a);
//	
//		List<Absence> absences = daoA.getAll();
//		for (Absence absence : absences) {
//			System.out.println(absence);
//		}
		
		
		///-------AbsenceType-------------------

		AbsenceTypeHibernateDao daoT = new AbsenceTypeHibernateDao();
		
//		AbsenceType t= new AbsenceType();
//		t.setAbsenceType("ConcediuMedical");
//		
//		daoT.save(t);
//		
//		List<AbsenceType> absenceType = AbsenceTypeHibernateDao.getAll();
//		for (AbsenceType absenceTp :absenceType) {
//			System.out.println(absenceTp);
//		}
//		
		
		HibernateUtil.getSessionFactory().close();
	}

}
