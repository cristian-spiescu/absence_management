package com.crispico.absence_management.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.crispico.absence_management.HibernateUtil;
import com.crispico.absence_management.model.Absence;

public class AbsenceHibernateDao {

	public void save(Absence absence) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.save(absence);
			session.getTransaction().commit();
		} catch (Exception ex) {
			session.getTransaction().rollback();
			ex.printStackTrace();
		}
	}

	public void delete(Absence absence) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.delete(absence);
			session.getTransaction().commit();
		} catch (Exception ex) {
			session.getTransaction().rollback();
			ex.printStackTrace();
		}
	}

	public void update(Absence absence) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.update(absence);
			session.getTransaction().commit();
		} catch (Exception ex) {
			session.getTransaction().rollback();
			ex.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Absence> getAbsences() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<Absence> result = new ArrayList<Absence>();
		try {
			session.beginTransaction();
			result = (List<Absence>) session.createQuery("from Absence").list();
			session.getTransaction().commit();
		} catch (Exception ex) {
			session.getTransaction().rollback();
			ex.printStackTrace();
		}

		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<Absence> getAbsencesByPage(int page) {
		int leftLimit = (page-1)*10+1;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<Absence> result = new ArrayList<Absence>();
		try {
			session.beginTransaction();
			result = (List<Absence>) session.createQuery("from Absence")
					.setFirstResult(leftLimit).setMaxResults(10).list();
			session.getTransaction().commit();
		} catch (Exception ex) {
			session.getTransaction().rollback();
			ex.printStackTrace();
		}

		return result;
	}

	public Absence getAbsenceById(long id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Absence result = null;
		try {
			session.beginTransaction();
			result = (Absence) session.createQuery(
					"from Absence where id=" + id).uniqueResult();
			session.getTransaction().commit();
		} catch (Exception ex) {
			session.getTransaction().rollback();
			ex.printStackTrace();
		}

		return result;
	}

}
