package com.crispico.absence_management.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.crispico.absence_management.HibernateUtil;
import com.crispico.absence_management.model.Absence;

public class AbsenceHibernateDao {

	public long save(Absence absence) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(absence);
		session.getTransaction().commit();
		
		return absence.getId();
	}

	public void delete(String id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "from Absence where id = :absId";
		Query query = session.createQuery(hql);
		query.setParameter("absId", Long.parseLong(id));
		
//		if (query.list().size() != 0) {
			Absence absence = (Absence) query.list().get(0);
			
			absence.getEmployee().getAbsences().remove(absence);
			session.flush();
			session.delete(absence);
//		}
		
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

}
