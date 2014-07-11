package com.crispico.absence_management.dao;

import java.util.ArrayList;
import java.util.List;

import javax.management.Query;

import org.hibernate.Session;

import com.crispico.absence_management.HibernateUtil;
import com.crispico.absence_management.model.Employee;

public class EmployeeHibernateDao {

	public long save(Employee employee) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
        long aux = employee.getId();
        return aux;
	}
	
	public List<Employee> getAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        @SuppressWarnings("unchecked")
		List<Employee> result = (List<Employee>) session.createQuery("from Employee").list();
        session.getTransaction().commit();
        
        return result;
	}
	
	public int getNumberOfEmployees() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        @SuppressWarnings("unchecked")
		List<Employee> result = (List<Employee>) session.createQuery("from Employee").list();
        session.getTransaction().commit();
        
        return result.size();
	}
	
	public List<Employee> getPage(int pageSize, int pageNumber){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        @SuppressWarnings("unchecked")
        List<Employee> result = new ArrayList<Employee>();
		List<Employee> list = (List<Employee>) session.createQuery("from Employee").list();
        session.getTransaction().commit();
        
        if(pageNumber > list.size()/pageSize+1 ){
        	pageNumber = list.size()/pageSize+1;
        }
        if(pageNumber < 1){
        	pageNumber = 1;
        }
        
        for(int i = (pageNumber - 1) * pageSize + 1; 
        		i < pageNumber * pageSize + 1 && i < list.size(); i++){
        	result.add(list.get(i));
        }
        
        return result;
	}
	
	public void delete(long id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        //session.delete(employee);
        org.hibernate.Query query = session.createQuery("from Employee where id = " + id + "");
        session.delete(query.list().get(0));
        session.getTransaction().commit();
	}
}
