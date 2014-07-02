package com.crispico.absence_management.dao;

import java.util.List;

import org.hibernate.Session;

import com.crispico.absence_management.HibernateUtil;
import com.crispico.absence_management.model.Absence;
import com.crispico.absence_management.model.AbsenceType;
import com.crispico.absence_management.model.Employee;

public class EmployeeHibernateDao {

	public void save(Employee employee) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
       // session.close();
	}
	public void save(Absence absence) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(absence);
        session.getTransaction().commit();
      //  session.close();
	}
	
	public List<Employee> getAll() {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        @SuppressWarnings("unchecked")
		List<Employee> result = (List<Employee>) session.createQuery("from Employee").list();
        session.close();
        
        return result;
	}
	
	public List<Absence> getAbsences() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        @SuppressWarnings("unchecked")
		List<Absence> result = (List<Absence>) session.createQuery("from Absence").list();
        session.close();
        
        return result;
	}
	
	public List<AbsenceType> getAbsenceTypes() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        @SuppressWarnings("unchecked")
		List<AbsenceType> result = (List<AbsenceType>) session.createQuery("from AbsenceType").list();
        session.close();
        
        return result;
	}
}
