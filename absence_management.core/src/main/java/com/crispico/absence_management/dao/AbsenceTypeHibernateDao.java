package com.crispico.absence_management.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.crispico.absence_management.HibernateUtil;
import com.crispico.absence_management.model.Absence;
import com.crispico.absence_management.model.AbsenceType;
import com.crispico.absence_management.model.Employee;

public class AbsenceTypeHibernateDao {

	public void save(AbsenceType absenceType) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.save(absenceType);
			session.getTransaction().commit();
		} catch (Exception ex) {
			session.getTransaction().rollback();
			ex.printStackTrace();
		}

	}

	public void delete(AbsenceType type) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.delete(type);
			session.getTransaction().commit();
		} catch (Exception ex) {
			session.getTransaction().rollback();
			ex.printStackTrace();
		}
	}
	
	public void update(AbsenceType type) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.update(type);
			session.getTransaction().commit();
		} catch (Exception ex) {
			session.getTransaction().rollback();
			ex.printStackTrace();
		}
	}

	public AbsenceType getAbsenceTypeById(long id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		AbsenceType result = null;
		try {
			session.beginTransaction();
			result = (AbsenceType) session.createQuery(
					"from AbsenceType where id=" + id).uniqueResult();
			session.getTransaction().commit();
		} catch (Exception ex) {
			session.getTransaction().rollback();
			ex.printStackTrace();
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<AbsenceType> getAbsenceTypes() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<AbsenceType> result = new ArrayList<AbsenceType>();
		try {
			session.beginTransaction();
			result = (List<AbsenceType>) session.createQuery(
					"from AbsenceType").list();
			session.getTransaction().commit();
		} catch (Exception ex) {
			session.getTransaction().rollback();
			ex.printStackTrace();
		}

		return result;
	}
}
