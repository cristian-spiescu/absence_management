package com.crispico.absence_management.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import com.crispico.absence_management.HibernateUtil;
import com.crispico.absence_management.model.Absence;
import com.crispico.absence_management.model.Employee;

public class EmployeeHibernateDao {

	public boolean save(Employee employee) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
	        session.save(employee);
	        session.getTransaction().commit();
	        return true;
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			session.getTransaction().rollback();
			return false;
		}
        
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
	
	public boolean deleteEmployee(long i) {
		Session session= HibernateUtil.getSessionFactory().getCurrentSession();;
		try {
			session.beginTransaction();
	        Employee employee = (Employee) session.get(Employee.class, i);
	        Set<Absence> l = (Set<Absence>)employee.getAbsences();
	        for (Absence a : l) {
	        	employee.removeFromAbsences(a);
	        	session.delete(a);
	        }
	        session.delete(employee);
	        session.getTransaction().commit();
			return true;
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			session.getTransaction().rollback();
			return false;
		}
		
		
	}
	
	public boolean editEmployee(long i, String first_name, String last_name) {
		Session session= HibernateUtil.getSessionFactory().getCurrentSession();;
		try {
			session.beginTransaction();
	        Employee employee = (Employee) session.get(Employee.class, i);
	        employee.setFirstName(first_name);
	        employee.setLastName(last_name);
	        session.update(employee);
	        session.getTransaction().commit();
			return true;
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			session.getTransaction().rollback();
			return false;
		}
	}

}
