package com.crispico.absence_management.dao;

import java.util.List;

import org.hibernate.Session;

import com.crispico.absence_management.HibernateUtil;
import com.crispico.absence_management.model.Absence;

public class AbsenceHibernateDao {

	public void save(Absence absence) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(absence);
        session.getTransaction().commit();
	}
	
	public void delete(Absence absence) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.delete(absence);
        session.getTransaction().commit();
	}
	
	public List<Absence> getAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        @SuppressWarnings("unchecked")
		List<Absence> result = (List<Absence>) session.createQuery("from Absence").list();
        session.getTransaction().commit();
        
        return result;
	}
	
	public void update(Absence absence) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(absence);
        session.getTransaction().commit();
	}
	
	
	
}
