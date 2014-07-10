package com.crispico.absence_management.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.crispico.absence_management.dao.AbsenceHibernateDao;
import com.crispico.absence_management.dao.AbsenceTypeHibernateDao;
import com.crispico.absence_management.dao.EmployeeHibernateDao;
import com.crispico.absence_management.model.Absence;
import com.crispico.absence_management.model.AbsenceType;
import com.crispico.absence_management.model.Employee;

public class AbsenceService {
	AbsenceHibernateDao dao = new AbsenceHibernateDao();
	EmployeeHibernateDao daoEmp = new EmployeeHibernateDao();
	AbsenceTypeHibernateDao absTypeDao = new AbsenceTypeHibernateDao();
	
	public void addAbsence(long id, String startDate, String endDate, String description) throws ParseException{
		List<Employee> employees = new ArrayList<Employee>();
		employees = daoEmp.getAll();
		for(Employee e:employees)
			if(e.getId()==id){
				startDate = startDate.replaceAll("/","-");
				endDate = endDate.replaceAll("/","-");
				DateFormat inputFormat = new SimpleDateFormat("MM-dd-yyyy");
				DateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
				Date sdate = inputFormat.parse(startDate);
				Date edate = inputFormat.parse(endDate);
				Absence a = new Absence();
				a.setStartDate(outputFormat.format(sdate));
				a.setEndDate(outputFormat.format(edate));
				a.setEmployee(e);
				e.getAbsences().add(a);
				AbsenceType at = new AbsenceType();
				at.setDescription(description);
				a.setAbsenceType(at);
				absTypeDao.save(at);
				dao.save(a);
			}
	}
	
	public void editAbsence(Absence absence, String sDate, String eDate, String description) throws ParseException{
		sDate = sDate.replaceAll("/","-");
		eDate = eDate.replaceAll("/","-");
		DateFormat inputFormat = new SimpleDateFormat("MM-dd-yyyy");
		DateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date sdate = inputFormat.parse(sDate);
		Date edate = inputFormat.parse(eDate);
		dao.update(absence, outputFormat.format(sdate), outputFormat.format(edate));
		absTypeDao.update(absence, description);
	}
	
	public void deleteAbsence(Absence absence){
		List<Absence> absences = new ArrayList<Absence>();
        absences = dao.getAll();
        for(Absence a:absences){
        	if(a.getStartDate().equals(absence.getStartDate()) && a.getEndDate().equals(absence.getEndDate()))
        		dao.delete(a.getId());
        }
	}
}
