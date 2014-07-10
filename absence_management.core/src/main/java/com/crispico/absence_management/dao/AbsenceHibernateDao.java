package com.crispico.absence_management.dao;

import java.util.List;
import org.hibernate.Query;
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
	public void delete(long idabsence){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String hql = "FROM Absence WHERE idabsence=:idabs";
		Query query = session.createQuery(hql);
		query.setParameter("idabs", idabsence);
		Absence absence = (Absence)query.list().get(0);
        absence.getEmployee().getAbsences().remove(absence);
        session.delete(absence);
        session.getTransaction().commit();

	}
	public void update(Absence absence, String sDate, String eDate){
		String hql = "UPDATE Absence SET startdate = :sDate, enddate = :eDate WHERE idabsence = :abs_id";
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery(hql);
        query.setParameter("abs_id", absence.getId());
        query.setString("sDate", sDate);
        query.setString("eDate", eDate);
	    query.executeUpdate();
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
}