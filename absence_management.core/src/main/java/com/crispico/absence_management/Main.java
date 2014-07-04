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
		
		/* AbsenceType */
		
		AbsenceTypeHibernateDao absTypeDao = new AbsenceTypeHibernateDao();
		ArrayList<String> absType = new ArrayList<String>();
		
		absType.add("maternitate");
		absType.add("medical");
		absType.add("odihna");
		absType.add("nemotivat");
		
		
		/* save type -> BD */
		AbsenceType abstype;
		for(String abs_type : absType){
			abstype = new AbsenceType();
			abstype.setTypeAbsence(abs_type);
			//absTypeDao.save(abstype);
		}
		
		/* print type from BD */
		List<AbsenceType> absTypeList = absTypeDao.getAll();
		for (AbsenceType absences : absTypeList) {
			System.out.println(absences);
		}	
		
		/* Employee */
		
		EmployeeHibernateDao dao = new EmployeeHibernateDao();
		AbsenceHibernateDao absDao = new AbsenceHibernateDao();
		
		/* vectors for date_start/date_end */
		String []start_vect = {"01-02-2000","02-05-1998","23-04-2014","09-10-2013"};
		String []end_vect = {"10-05-2001","13-06-1998","25-04-2014","11-10-2013"};
		
		List<Employee> employees = dao.getAll();
		for (Employee employee : employees) {
			System.out.println(employee);
			
			int nrAbs = (int)(Math.random() * 10);
			Absence absence;
			Set<Absence> absSet = new HashSet<Absence>();
			int j,absenceIndex;
			
			for(int i = 0; i < nrAbs ; i++){
				j = (int)(Math.random() * start_vect.length); 
				absenceIndex = (int)(Math.random() * absType.size());
				
				absence = new Absence();
				absence.setDate_start(new SimpleDateFormat("dd-mm-yyyy").parse(start_vect[j]));
				absence.setDate_end(new SimpleDateFormat("dd-mm-yyyy").parse(end_vect[j]));
				absence.setEmp(employee);
				absence.setTypeAbs(absTypeList.get(absenceIndex));
				//absDao.save(absence);
				absSet.add(absence);
			}
			
			employee.setAbsenceList(absSet);
		}	
		
		HibernateUtil.getSessionFactory().close();
	}

}
