package com.crispico.absence_management;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.crispico.absence_management.dao.AbsenceHibernateDao;
import com.crispico.absence_management.dao.EmployeeHibernateDao;
import com.crispico.absence_management.model.Absence;
import com.crispico.absence_management.model.AbsenceType;
import com.crispico.absence_management.model.Employee;

public class Main {

	public static void main(String[] args) {
		EmployeeHibernateDao dao = new EmployeeHibernateDao();
		
		/*Adaugare Employee*/
		
		//Employee e = new Employee();
		//e.setFirstName("Alexandra");
		//e.setLastName("Topoloaga");
		//dao.save(e);

		/* Afisarea angajatilor din BD */
		List<Employee> employees = dao.getAll();
		for (Employee employee : employees) {
			System.out.println(employee);
		}
		
		Employee gogu = employees.get(0);
		System.out.println("Eu sunt " + gogu.getFirstName()+ " "
									  + gogu.getLastName() + "!");
		
		/* Construim o absenta */
		Absence abs = new Absence();
		abs.setEmployee(gogu);		
		abs.setStartDate(new Date());
		abs.setEndDate(new Date());
		
		/* Setam tipul absentei */
		AbsenceType type = new AbsenceType();
		type.setAbsenceType("MEDICAL");
		abs.setAbsenceType(type);
		
		/* Adaugam in lista de absente a angajatului. */
		Set<Absence> absentaNoua = gogu.getAbsences();
		absentaNoua.add(abs);
		gogu.setAbsences(absentaNoua);	
				
		/* Adaugare absente in BD */
		AbsenceHibernateDao ahd = new AbsenceHibernateDao();
		System.out.println("PRINT:"+abs.toString());
		ahd.save(abs);
			
		/* Afisarea absentelor din BD */
		List<Absence> absence = ahd.getAll();
		for (Absence absenta  : absence) {
			System.out.println(absenta);
		}		
		HibernateUtil.getSessionFactory().close();	
	}
}
