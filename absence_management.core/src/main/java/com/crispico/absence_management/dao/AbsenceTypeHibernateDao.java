package com.crispico.absence_management.dao;

import java.util.List;

import org.hibernate.Session;

import com.crispico.absence_management.HibernateUtil;
import com.crispico.absence_management.model.AbsenceType;

public class AbsenceTypeHibernateDao {
	public void save(AbsenceType absenceType) {
		Session sessionA = HibernateUtil.getSessionFactory().getCurrentSession();
        sessionA.beginTransaction();
        sessionA.save(absenceType);
        sessionA.getTransaction().commit();
	}
	
	public static List<AbsenceType> getAll() {
		Session sessionA = HibernateUtil.getSessionFactory().getCurrentSession();
        sessionA.beginTransaction();
        @SuppressWarnings("unchecked")
		List<AbsenceType> result = (List<AbsenceType>) sessionA.createQuery("from AbsenceType").list();
        sessionA.getTransaction().commit();
        
        return result;
	}
	
	public static AbsenceType getAbsenceTypeById(long id){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        AbsenceType result = (AbsenceType) session.createQuery("from AbsenceType where idT = " + id).uniqueResult();
        session.getTransaction().commit();
        return result;
	}
	
	public void delete(AbsenceType absenceType) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.delete(absenceType);
        session.getTransaction().commit();
	}
	
	
}
