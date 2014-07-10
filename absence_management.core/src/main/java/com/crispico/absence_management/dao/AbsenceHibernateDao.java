package com.crispico.absence_management.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.crispico.absence_management.HibernateUtil;
import com.crispico.absence_management.model.Absence;
import com.crispico.absence_management.model.Employee;

public class AbsenceHibernateDao {

	public void save(Absence absence) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(absence);
		session.getTransaction().commit();
	}

	public List<Absence> getAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Absence> result = (List<Absence>) session.createQuery(
				"from Absence").list();
		session.getTransaction().commit();
		return result;
	}

	public List<Absence> getAbsences(Employee emp) {
		/*
		 * Session session =
		 * HibernateUtil.getSessionFactory().getCurrentSession();
		 * session.beginTransaction();
		 * 
		 * @SuppressWarnings("unchecked") List<Absence> result = (List<Absence>)
		 * session.createQuery( "from Absence").list();
		 * session.getTransaction().commit(); return result;
		 */
		List<Absence> l = new ArrayList<Absence>();
		if (emp == null)
			System.out.println(emp.getAbsences().size());
		else
			System.out.println("emp e null");
		// l.addAll(emp.getAbsences());
		return l;
	}

	public long addAbsenceForEmployee(Absence abs, Employee e) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		// le incarca in memorie; daca vreau ca totul sa aiba loc doar in BD,
		// fac un querry tip update de mana (are si hibernate asta)
		abs.setEmployee(e);
		System.out.println("(dao)salvez absenta " + abs);
		session.save(abs);
		session.getTransaction().commit();
		return abs.getID();
	}

	public void deleteAbsence(long id) throws Exception {
		Session sess;
		sess = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			// long id = Integer.parseInt(request.getParameter("id"));
			sess.beginTransaction();
			Absence absence = (Absence) sess.get(Absence.class, id);
			sess.delete(absence);
			sess.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			sess.getTransaction().rollback();
		} catch (Exception e) {
			// System.out.println("am murit " + e);
			throw new Exception("A aparut o eroare la stergerea absentei " + e);
		}

	}

	public void editAbsence(Absence abs) throws Exception {
		System.out.println("actualizez " + abs.getID());
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.update(abs);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} catch (Exception e) {
			// System.out.println("am murit " + e);
			throw new Exception("A aparut o eroare la editarea absentei " + e);
		}
	}
}
