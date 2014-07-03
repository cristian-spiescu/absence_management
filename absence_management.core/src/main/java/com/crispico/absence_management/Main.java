package com.crispico.absence_management;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import com.crispico.absence_management.dao.AbsenceHibernateDao;
import com.crispico.absence_management.dao.AbsenceTypeHibernateDao;
import com.crispico.absence_management.dao.EmployeeHibernateDao;
import com.crispico.absence_management.model.Absence;
import com.crispico.absence_management.model.AbsenceType;
import com.crispico.absence_management.model.Employee;

public class Main {

	public static void main(String[] args) {
		AbsenceTypeHibernateDao absenceTypeDAO = new AbsenceTypeHibernateDao();

		AbsenceType co = new AbsenceType();
		co.setType("CO");
		absenceTypeDAO.save(co);

		AbsenceType cm = new AbsenceType();
		cm.setType("CM");
		absenceTypeDAO.save(cm);

		// 10 tipuri de absente

		// 10 oameni, fiecare cu cate 10 absente (cate una din fiecare tip)
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		for(int i = 0; i < 10; i++){
			Employee e = new Employee();
			e.setFirstName("FirstName " + i);
			e.setLastName("LastName " + i);
	        session.save(e);
	        
			Absence abs = new Absence();
			abs.setStartDate(new Date());
			abs.setEndDate(new Date());
			abs.setAbsenceType(cm);
			abs.setEmployee(e);
			session.save(abs);

		}
        session.getTransaction().commit();


//		Employee e = new Employee();
//		e.setFirstName("Ana-Maria");
//		e.setLastName("Ann");
//		Set<Absence> set = new HashSet<Absence>();
//		set.add(abs);
//
//		List<Employee> employees = dao.getAll();
//		for (Employee employee : employees) {
//			System.out.println(employee);
//		}

	}

}
