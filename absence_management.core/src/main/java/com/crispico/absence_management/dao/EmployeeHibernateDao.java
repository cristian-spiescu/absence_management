package com.crispico.absence_management.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.crispico.absence_management.HibernateUtil;
import com.crispico.absence_management.model.Employee;

public class EmployeeHibernateDao {

	public long save(Employee employee) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
        return employee.getId();
	}
	
	public List<Employee> getAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        @SuppressWarnings("unchecked")
		List<Employee> result = (List<Employee>) session.createQuery("from Employee").list();
        session.getTransaction().commit();
        
        return result;
	}
	
	public void delete(String id){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        
		session.beginTransaction();        
        String hql = "from Employee E where E.id = :empId";
        Query query = session.createQuery(hql);
        query.setParameter("empId", Long.parseLong(id));
        Employee employee = (Employee)query.list().get(0);        
        session.delete(employee);
        //session.flush();
        session.getTransaction().commit();
	}
	
	
	public void updateEmployee(Long id, String firstName, String lastName){
	      Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	      session.beginTransaction();     
	      Employee employee = (Employee)session.get(Employee.class, id); 
	      employee.setFirstName(firstName);
	      employee.setLastName(lastName);
	      session.update(employee); 
	      session.getTransaction().commit();
	}
	
	
}
