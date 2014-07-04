package com.crispico.absence_management.dao;

import java.util.List;

import org.hibernate.Session;

import com.crispico.absence_management.HibernateUtil;
import com.crispico.absence_management.model.Absence;

public class AbsenceHibernateDao {
	public void save(Absence absence) {
		Session sessionA = HibernateUtil.getSessionFactory().getCurrentSession();
        sessionA.beginTransaction();
        sessionA.save(absence);
        sessionA.getTransaction().commit();
	}
	
	public List<Absence> getAll() {
		Session sessionA = HibernateUtil.getSessionFactory().getCurrentSession();
        sessionA.beginTransaction();
        @SuppressWarnings("unchecked")
		List<Absence> result = (List<Absence>) sessionA.createQuery("from Absence").list();
        sessionA.getTransaction().commit();
        
        return result;
	}
	
	public static Absence getAbsenceById(long id){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Absence result = (Absence) session.createQuery("from Absence where id = " + id).uniqueResult();
        session.getTransaction().commit();
        return result;
	}
	
	public void delete(Absence absence) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.delete(absence);
        session.getTransaction().commit();
	}
	
}

