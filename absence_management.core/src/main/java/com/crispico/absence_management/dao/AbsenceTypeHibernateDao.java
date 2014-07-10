package com.crispico.absence_management.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.crispico.absence_management.HibernateUtil;
import com.crispico.absence_management.model.Absence;
import com.crispico.absence_management.model.AbsenceType;

public class AbsenceTypeHibernateDao {
	
	public void save(AbsenceType type) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(type);
        session.getTransaction().commit();
	}
	
	public void update(Absence absence, String description) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql1 = "UPDATE AbsenceType SET description = :descrip WHERE idabsencetype = :abst_id";
	    Query query1 = session.createQuery(hql1);
	    query1.setString("descrip", description);
	    query1.setParameter("abst_id", absence.getAbsenceType().getId());
	    query1.executeUpdate();
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