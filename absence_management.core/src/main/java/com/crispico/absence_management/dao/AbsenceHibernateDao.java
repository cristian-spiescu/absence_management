package com.crispico.absence_management.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.hibernate.Session;

import com.crispico.absence_management.HibernateUtil;
import com.crispico.absence_management.model.Absence;
import com.crispico.absence_management.model.Employee;

public class AbsenceHibernateDao {
	public boolean save(Absence absence) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
	        session.save(absence);
	        session.getTransaction().commit();
	        return true;
		}
        catch (Exception ex) {
        	System.out.println(ex.getMessage());
			session.getTransaction().rollback();
			return false;
        }
		
	}
	
	public List<Absence> getAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        @SuppressWarnings("unchecked")
		List<Absence> result = (List<Absence>) session.createQuery("from Absence").list();
        session.getTransaction().commit();
        
        return result;
	}
	
	public List<Absence> getAbsence(long i) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Absence> result = (List<Absence>) session.createQuery("from Absence where absence_id = " + i).list();
        session.getTransaction().commit();
        
        return result;
	}
	
	public boolean deleteAbsence(long i) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Absence absence = (Absence) session.get(Absence.class, i);
			Employee emp = absence.getEmployee();
			Set<Absence> lista = (Set<Absence>) emp.getAbsences();
			for (Absence a : lista) {
				if (a.equals(absence)) {
					emp.removeFromAbsences(a);
				}
			}
			session.delete(absence);
	        session.getTransaction().commit();
			return true;
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			session.getTransaction().rollback();
			return false;
		}
	}
	
	public boolean editAbsence(Absence a) {
		Session session= HibernateUtil.getSessionFactory().getCurrentSession();;
		try {
			session.beginTransaction();
	        
	        session.update(a);
	        session.getTransaction().commit();
			return true;
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			session.getTransaction().rollback();
			return false;
		}
	}
}
