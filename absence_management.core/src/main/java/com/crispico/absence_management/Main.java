package com.crispico.absence_management;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.crispico.absence_management.dao.AbsenceHibernateDao;
import com.crispico.absence_management.dao.AbsenceTypeHibernateDao;
import com.crispico.absence_management.dao.EmployeeHibernateDao;
import com.crispico.absence_management.model.Absence;
import com.crispico.absence_management.model.AbsenceType;
import com.crispico.absence_management.model.Employee;

public class Main {

	public static void main(String[] args) throws ParseException {

		/*
		 * Populate AbsenceType
		 */
		AbsenceTypeHibernateDao absTypeDao = new AbsenceTypeHibernateDao();
		
		List<String> absenceList = new ArrayList<String>();
		absenceList.add("medical");
		absenceList.add("odihna");
		absenceList.add("nemotivat");
		absenceList.add("maternitate");
		
		/*
		 * Save absence
		 */
		AbsenceType absenceType;
		for (String absenceName: absenceList) {
			absenceType = new AbsenceType();
			absenceType.setAbsenceName(absenceName);
			/*
			 * Add to BD absenceType instance
			 */
			//absTypeDao.save(absenceType);
		}
		
		/*
		 * Get all absences
		 */
		List<AbsenceType> absences = absTypeDao.getAll();
		for (AbsenceType absenceTypeList: absences) {
			System.out.println(absenceTypeList);
		}
		
		/*
		 * Populate Employee table
		 */
		EmployeeHibernateDao dao = new EmployeeHibernateDao();
		AbsenceHibernateDao absDao = new AbsenceHibernateDao();
		
		
//		Employee e = new Employee();
//		e.setFirstName("John");
//		e.setLastName("Doe");
//		dao.save(e);
		
		List<Employee> employees = dao.getAll();

		for (Employee employee : employees) {
			System.out.println(employee);
			
			/*
			 * Generate absences number
			 */
			int nrAbsences = (int)(Math.random() * 10);
			Absence absence;
			Set<Absence> absenceSet = new HashSet<Absence>();
			
			/* startDate */
			String[] startDate = {"12/12/2010", "10/04/2011", "15/07/2011", "16/11/2011","09/10/2013"};
			String[] endDate = {"13/12/2010", "11/04/2011", "18/07/2011", "19/11/2011","10/10/2013"};
			
			/*
			 * Populate absences List in Employee
			 * Populate absence in Absence
			 */
			int j, absencesIndex;
			for (int i = 0; i < nrAbsences; i++) {
				absence = new Absence();
				j = (int)(Math.random() * startDate.length);
				absence.setStartDate(new SimpleDateFormat("dd/mm/yyyy").parse(startDate[j]));
				absence.setEndDate(new SimpleDateFormat("dd/mm/yyyy").parse(endDate[j]));
				absence.setEmployee(employee);
				
				absencesIndex = (int)(Math.random() * absences.size());
				absence.setAbsenceType(absences.get(absencesIndex));
				//absDao.save(absence);
				
				absenceSet.add(absence);
			}
			
			/*
			 * Add absenceSet to employee
			 */
			employee.setAbsences(absenceSet);
		}
				
		/*
		 * Close session
		 */
		HibernateUtil.getSessionFactory().close();
	}

}
