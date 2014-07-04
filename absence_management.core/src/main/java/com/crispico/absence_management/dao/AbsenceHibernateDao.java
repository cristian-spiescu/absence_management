package com.crispico.absence_management.dao;

import java.util.List;

import org.hibernate.Session;

import com.crispico.absence_management.HibernateUtil;
import com.crispico.absence_management.model.Absence;

public class AbsenceHibernateDao {

	public long save(Absence abs) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(abs);
        session.getTransaction().commit();
        long aux = abs.getAbsenceId();
        return aux;
	}
	
	public List<Absence> getAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        @SuppressWarnings("unchecked")
		List<Absence> result = (List<Absence>) session.createQuery("from Absence").list();
        session.getTransaction().commit();
        return result;
	}
	
	public List<Absence> getById(long id){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Absence> result =(List<Absence>) session.createQuery("from Absence where id = " + id + "").list();
		session.getTransaction().commit();
		return result;
	}
	
	public void delete(Long long1){
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		org.hibernate.Query q = session.createQuery("from Absence where idabsence = " + long1 + "");
		//q.setParameter("value", Long.parseLong(long1));
		System.out.println("\n\n" + long1);
		Absence absence = (Absence)q.list().get(0);
		absence.getEmployee().getAbsences().remove(absence);
		session.flush();
		session.delete(q.list().get(0)); 
		//q.executeUpdate();
		session.getTransaction().commit();
	}
	
}
