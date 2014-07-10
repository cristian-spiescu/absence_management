package com.crispico.absence_management.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.crispico.absence_management.HibernateUtil;
import com.crispico.absence_management.dao.EmployeeHibernateDao;
import com.crispico.absence_management.model.Absence;
import com.crispico.absence_management.model.Employee;

public class EmployeeService {

	protected EmployeeHibernateDao dao = new EmployeeHibernateDao();

	// public String sayHello(String name) {
	// System.out.println(name);
	// return "Hello " + name;
	// }

	public List<Employee> getAllEmployees() {
		return dao.getAll();
	}
	
	public List<Employee> getPage(int li, int limit){
		return dao.getPage(li, limit);
	}

	public long countEmployees(){
		return dao.countEmployees();
	}
	public void deleteEmployee(long id) throws Exception {
		Session sess;
		sess = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			// long id = Integer.parseInt(request.getParameter("id"));
			sess.beginTransaction();
			Employee employee = (Employee) sess.get(Employee.class, id);
			sess.delete(employee); // absentele le sterge singur, automat
			sess.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			sess.getTransaction().rollback();
		} catch (Exception e) {
			// System.out.println("am murit " + e);
			throw new Exception("A aparut o eroare la stergerea userului " + e);
		}
	}

	public long addEmployee(Employee employee) throws Exception {
		Session sess;
		sess = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			// long id = Integer.parseInt(request.getParameter("id"));
			sess.beginTransaction();
			sess.save(employee);
			sess.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			sess.getTransaction().rollback();
		} catch (Exception e) {
			// System.out.println("am murit " + e);
			throw new Exception("A aparut o eroare la stergerea userului " + e);
		}
		return employee.getID();
	}

	public List<Absence> getAbsencesByEmployeeId(long ID) {
		return dao.getAbsencesByEmployeeId(ID);
	}

	public void updateName(long ID, String firstName, String lastName)
			throws Exception {
		System.out.println("actualizez " + ID + " cu " + firstName + " "
				+ lastName);
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		// le incarca in memorie; daca vreau ca totul sa aiba loc doar in BD,
		// fac un querry tip update de mana (are si hibernate asta)
		Employee e = (Employee) session.get(Employee.class, ID);
		e.setFirstName(firstName);
		e.setLastName(lastName);
		// session.saveOrUpdate(e);
		session.update(e);
		session.getTransaction().commit();
	}

}
