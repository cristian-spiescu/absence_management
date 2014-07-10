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
	
	public static List<Employee> getAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        @SuppressWarnings("unchecked")
		List<Employee> result = (List<Employee>) session.createQuery("from Employee").list();
        session.getTransaction().commit();
        
        return result;
	}	
	
	public static Employee getEmployeeById(long id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Employee result = (Employee) session.createQuery("from Employee where Id = " + id).uniqueResult();
        session.getTransaction().commit();
        return result;
	}	
	
	public void delete(Employee employee) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.delete(employee);
        session.getTransaction().commit();
	}
	
	public void update(Employee employee) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(employee);
        session.getTransaction().commit();
	}
	
}
