package com.crispico.absence_management.dao;

import java.util.List;

import org.hibernate.Session;

import com.crispico.absence_management.HibernateUtil;
import com.crispico.absence_management.model.Absence;
import com.crispico.absence_management.model.AbsenceType;
import com.crispico.absence_management.model.Employee;

public class AbsenceTypeHibernateDao {


	public void save(AbsenceType absenceType) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(absenceType);
        session.getTransaction().commit();
      //  session.close();
	}
	
	public void delete(AbsenceType type) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.delete(type);
        session.getTransaction().commit();
       // session.close();
	}
	public AbsenceType getAbsenceTypeById(Long id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
		AbsenceType result = (AbsenceType) session.createQuery("from AbsenceType where id="+id).uniqueResult();
        session.close();
        
        return result;
	}
	
	public List<AbsenceType> getAbsenceTypes() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        @SuppressWarnings("unchecked")
		List<AbsenceType> result = (List<AbsenceType>) session.createQuery("from AbsenceType").list();
        session.close();
        
        return result;
	}
}
