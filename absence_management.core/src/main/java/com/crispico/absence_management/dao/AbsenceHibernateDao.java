package com.crispico.absence_management.dao;

import java.util.ArrayList;
import java.util.List;
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
		try {
			session.beginTransaction();
	        List<Absence> result = (List<Absence>) session.createQuery("from Absence where absence_id = " + i).list();
	        session.getTransaction().commit();
	        
	        return result;
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			session.getTransaction().rollback();
			return null;
		}
	}
	
	public boolean deleteAbsence(long i) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Absence absence = (Absence) session.get(Absence.class, i);
//			System.out.println(" avem de sters "+absence);
			Employee emp = absence.getEmployee();
//			System.out.println(absence + " apartine de "+emp);
			Set<Absence> lista = (Set<Absence>) emp.getAbsences();
//			System.out.println(lista);
//			int j=0;
			for (Absence a : lista) {
//				System.out.println(a.equals(absence)+" pentru "+a);
				if (a.equals(absence)) {
					emp.removeFromAbsences(a);
//					j++;
//					System.out.println(j);
					break;
				}
			}
//			System.out.println(j);
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
	
	public List<Absence> getEmployeeAbsences (long i) {
		Session session= HibernateUtil.getSessionFactory().getCurrentSession();;
		try {
			session.beginTransaction();
			
			List<Absence> result = (List<Absence>) session.createQuery("from Absence where ID = " + i).list();
	        session.getTransaction().commit();
	        //System.out.println(result);
			return result;
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			session.getTransaction().rollback();
			return new ArrayList<Absence>();
		}
	}
	
	public long howManyAbsences() {
		Session session= HibernateUtil.getSessionFactory().getCurrentSession();;
		try {
			session.beginTransaction();
	        Long nr = (Long)session.createQuery("select count (*) from Absence ").uniqueResult();
	        session.getTransaction().commit();
			return nr;
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			session.getTransaction().rollback();
			return -1;
		}
	}
	
	public List<Absence> getFromTo(int i) {
		Session session= HibernateUtil.getSessionFactory().getCurrentSession();;
		try {
			session.beginTransaction();
			List<Absence> rez;
	        rez = (List<Absence>)session.createQuery("from Absence").setFirstResult(i).setMaxResults(10).list();
	        session.getTransaction().commit();
			return rez;
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			session.getTransaction().rollback();
			return null;
		}
	}
}
