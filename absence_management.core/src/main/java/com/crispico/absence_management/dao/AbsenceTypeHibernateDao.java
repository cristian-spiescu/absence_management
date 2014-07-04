package com.crispico.absence_management.dao;

import java.util.List;

import org.hibernate.Session;

import com.crispico.absence_management.HibernateUtil;
import com.crispico.absence_management.model.AbsenceType;

public class AbsenceTypeHibernateDao {
	public void save(AbsenceType absenceType) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(absenceType);
        session.getTransaction().commit();
	}
	
	public List<AbsenceType> getAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        @SuppressWarnings("unchecked")
		List<AbsenceType> result = (List<AbsenceType>) session.createQuery("from AbsenceType").list();
        session.getTransaction().commit();
        
        return result;
	}
}
