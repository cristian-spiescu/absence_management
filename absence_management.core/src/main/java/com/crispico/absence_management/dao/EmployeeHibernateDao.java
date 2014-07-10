package com.crispico.absence_management.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.crispico.absence_management.HibernateUtil;
import com.crispico.absence_management.model.Absence;
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
		List<Employee> result = (List<Employee>) session.createQuery(
				"from Employee").list();
		session.getTransaction().commit();

		return result;
	}

	public List<Employee> getPage(int li, int limit) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("from Employee");
		query.setFirstResult(li);
		query.setMaxResults(limit);
		@SuppressWarnings("unchecked")
		List<Employee> result = (List<Employee>) query.list();
		// System.out.println("de la "+ li + " trimit " + limit + " = " +
		// result.size() +" inregistrari");
		session.getTransaction().commit();
		return result;
	}

	public long countEmployees() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("select count(*) from Employee");
		@SuppressWarnings("unchecked")
		long result = (Long) (query.iterate().next());
		// System.out.println("de la "+ li + " trimit " + limit + " = " +
		// result.size() +" inregistrari");
		session.getTransaction().commit();
		return result;
	}

	public List<Absence> getAbsencesByEmployeeId(long ID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Employee e = (Employee) session.get(Employee.class, ID);
		session.getTransaction().commit();
		return new ArrayList<Absence>(e.getAbsences());
		// List<Absence> result = (List<Absence>) session.createQuery(
		// "from Employee").list();

	}

}
