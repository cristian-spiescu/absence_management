package com.crispico.absence_management.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.crispico.absence_management.HibernateUtil;
import com.crispico.absence_management.model.Absence;
import com.crispico.absence_management.model.AbsenceType;


public class AbsenceHibernateDao {

	public long save(Absence absence) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(absence);
        session.getTransaction().commit();
        return absence.getId();
	}
	
	public List<Absence> getAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        @SuppressWarnings("unchecked")
		List<Absence> result = (List<Absence>) session.createQuery("from Absence").list();
        session.getTransaction().commit();
        
        return result;
	}
	
	public List<AbsenceType> getAbsencesTypes() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        @SuppressWarnings("unchecked")
		List<AbsenceType> result = (List<AbsenceType>) session.createQuery("from AbsenceType").list();
        session.getTransaction().commit();
        
        return result;
	}
	
	public List<Absence> getAbsencesByType(long typeId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        
		session.beginTransaction();
        String hql = "from Absence where type_id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", typeId);        
        
        @SuppressWarnings("unchecked")
		List<Absence> result = (List<Absence>) query.list();
        session.getTransaction().commit();
        
        return result;
	}
	
	public List<Absence> getAbsencesByPeriod(Date startDate, Date endDate) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        
		session.beginTransaction();
        String hql = "from Absence where startdate >= :s and enddate <= :e";
        Query query = session.createQuery(hql);
        query.setParameter("s", startDate);
        query.setParameter("e", endDate);
        
        @SuppressWarnings("unchecked")
		List<Absence> result = (List<Absence>) query.list();
        session.getTransaction().commit();
        
        return result;
	}
	
	public List<Absence> getAbsencesByTP(long typeId, Date startDate, Date endDate) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        
		session.beginTransaction();
        String hql = "from Absence where type_id = :id and startdate >= :s and enddate <= :e";
        Query query = session.createQuery(hql);
        query.setParameter("id", typeId); 
        query.setParameter("s", startDate);
        query.setParameter("e", endDate);
        
        @SuppressWarnings("unchecked")
		List<Absence> result = (List<Absence>) query.list();
        session.getTransaction().commit();
        
        return result;
	}
	
	public void delete(String id){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        
		session.beginTransaction();        
        String hql = "from Absence A where A.id = :absId";
        Query query = session.createQuery(hql);
        query.setParameter("absId", Long.parseLong(id));
        Absence absence = (Absence)query.list().get(0);
        
        absence.getEmployee().getAbsences().remove(absence);

        session.flush();
        session.delete(absence);

        session.getTransaction().commit();
	}

}
