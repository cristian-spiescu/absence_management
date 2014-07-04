package com.crispico.absence_management.dao;

import java.util.List;

import org.hibernate.Query;
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
	
	public void delete(long id){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String hql = "FROM Employee e WHERE e.id = :employee_id";
        Query query = session.createQuery(hql);
        query.setParameter("employee_id", id);
	    Employee employee = (Employee)query.list().get(0);
        session.delete(employee);
        session.getTransaction().commit();
	}
}