package com.crispico.absence_management.dao;

import java.util.List;

import org.hibernate.Session;

import com.crispico.absence_management.HibernateUtil;
import com.crispico.absence_management.model.Employee;

public class EmployeeHibernateDao {

	public void save(Employee employee) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
	}
	
	public List<Employee> getAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        @SuppressWarnings("unchecked")
		List<Employee> result = (List<Employee>) session.createQuery("from Employee").list();
        session.getTransaction().commit();
        
        return result;
	}
	
	public List<Employee> getEmployee(long i) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Employee> emp = (List<Employee>) session.createQuery("from Employee where id = " + i).list();
		session.getTransaction().commit();
		return emp;
	}
}
