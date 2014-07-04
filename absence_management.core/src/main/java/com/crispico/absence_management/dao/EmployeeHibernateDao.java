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
	
	public void delete(Long long1){
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		org.hibernate.Query q = session.createQuery("from Employee where id = " + long1 + "");
		//q.setParameter("value", Long.parseLong(long1));
		System.out.println("\n\n" + long1);
		session.delete(q.list().get(0)); 
		//q.executeUpdate();
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


	
}
