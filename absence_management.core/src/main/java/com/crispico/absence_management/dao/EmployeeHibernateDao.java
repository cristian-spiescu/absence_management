package com.crispico.absence_management.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.crispico.absence_management.HibernateUtil;
import com.crispico.absence_management.model.Employee;

public class EmployeeHibernateDao {

	public void save(Employee employee) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.save(employee);
			session.getTransaction().commit();
		} catch (Exception ex) {
			session.getTransaction().rollback();
			ex.printStackTrace();
		}
	}

	public void delete(Employee employee) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.delete(employee);
			session.getTransaction().commit();
		} catch (Exception ex) {
			session.getTransaction().rollback();
			ex.printStackTrace();
		}
	}

	public void update(Employee employee) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.update(employee);
			session.getTransaction().commit();
		} catch (Exception ex) {
			session.getTransaction().rollback();
			ex.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getAll() {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<Employee> result = new ArrayList<Employee>();
		try {
			session.beginTransaction();
			result = (List<Employee>) session.createQuery(
					"from Employee").list();
			session.getTransaction().commit();
		} catch (Exception ex) {
			session.getTransaction().rollback();
			ex.printStackTrace();
		}

		return result;
	}
	

	public Employee getEmployeeById(Long id) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Employee result = null;
		try {
			session.beginTransaction();
			result = (Employee) session.createQuery(
					"from Employee where id=" + id).uniqueResult();
			session.getTransaction().commit();
		} catch (Exception ex) {
			session.getTransaction().rollback();
			ex.printStackTrace();
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<Employee> getEmployeesByName(String nameSnippet, int page) {
		int leftLimit = (page-1)*10+1;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<Employee> result = null;
		try {
			session.beginTransaction();
			Query query = session.createQuery("from Employee e where lower(e.lastName) like lower(:searchKeyword)"
					+ " or lower(e.firstName) like lower(:searchKeyword) order by e.lastName");
			result = (List<Employee>) query.setParameter("searchKeyword", nameSnippet + "%")
					.setFirstResult(leftLimit).setMaxResults(10).list();
			session.getTransaction().commit();
		} catch (Exception ex) {
			session.getTransaction().rollback();
			ex.printStackTrace();
		}
		return result;
	}

}
