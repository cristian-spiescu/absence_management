package com.crispico.absence_management.dao;

import java.util.Iterator;
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
	
	public Employee saveAndGet(Employee employee) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
	        session.save(employee);
	        session.getTransaction().commit();
	        return employee;
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			session.getTransaction().rollback();
			return null;
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
		try {
			session.beginTransaction();
	        List<Employee> emp = (List<Employee>) session.createQuery("from Employee where id = " + i).list();
			session.getTransaction().commit();
			return emp;
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			session.getTransaction().rollback();
			return null;
		}
        
	}
	
	public boolean deleteEmployee(long i) {
		Session session= HibernateUtil.getSessionFactory().getCurrentSession();;
		try {
			session.beginTransaction();
	        Employee employee = (Employee) session.get(Employee.class,i);
	        System.out.println(employee);
	        
	        Set<Absence> l = (Set<Absence>)employee.getAbsences();
	        System.out.println(l);
	        
	        for(Iterator<Absence> it=l.iterator(); it.hasNext();) {
	            Absence a = it.next();
	            it.remove();     //removing second last in list works fine
	            session.delete(a);
	        }
//	        for (Absence a : l) {
//	        	employee.removeFromAbsences(a);
//	        	session.delete(a);
//	        }
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
	
	public long howManyEmployees(String s) {
		Session session= HibernateUtil.getSessionFactory().getCurrentSession();;
		try {
			session.beginTransaction();
	        Long nr = (Long)session.createQuery("select count (*) from Employee where upper(lastName) like upper('%" + s + "%') or upper(firstName) like upper('%" + s + "%')").uniqueResult();
	        session.getTransaction().commit();
			return nr;
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			session.getTransaction().rollback();
			return -1;
		}
	}
	
	public List<Employee> getFromTo(int i) {
		Session session= HibernateUtil.getSessionFactory().getCurrentSession();;
		try {
			session.beginTransaction();
			List<Employee> rez;
	        rez = (List<Employee>)session.createQuery("from Employee").setFirstResult(i).setMaxResults(10).list();
	        session.getTransaction().commit();
			return rez;
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			session.getTransaction().rollback();
			return null;
		}
	}

	public List<Employee> searchEmployee(String s,int i) {
		Session session= HibernateUtil.getSessionFactory().getCurrentSession();;
		try {
			session.beginTransaction();
			List<Employee> rez;
	        rez = (List<Employee>)session.createQuery("from Employee where upper(lastName) like upper('%" + s + "%') or upper(firstName) like upper('%" + s + "%') ").setFirstResult(i).setMaxResults(10).list();
	        session.getTransaction().commit();
			return rez;
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			session.getTransaction().rollback();
			return null;
		}
	}
}
