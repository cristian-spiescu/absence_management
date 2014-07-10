package com.crispico.absence_management.dao;

import java.util.List;

import org.hibernate.Session;

import com.crispico.absence_management.HibernateUtil;
import com.crispico.absence_management.model.Absence;
import com.crispico.absence_management.model.Employee;

public class AbsenceHibernateDao {

	public long save(Absence absence) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(absence);
        session.getTransaction().commit();
        long aux = absence.getId();
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
	
	public List<Absence> getAbsencesById(long id){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        //session.delete(employee);
        List<Absence> result = (List<Absence>) session.createQuery("from Absence where id = " + id + "").list();
        //session.delete(query.list().get(0));
        session.getTransaction().commit();
        return result;
	}
	
	public void delete(long id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        //session.delete(employee);
        org.hibernate.Query query = session.createQuery("from Absence where absence_id = " + id + "");
        
         
        Absence absence = (Absence)query.list().get(0); 
        absence.getEmployee().getAbsences().remove(absence); 
        session.flush(); 
        
        session.delete(absence);
        
        //session.delete(query.list().get(0));
        session.getTransaction().commit();
	}
	
}
