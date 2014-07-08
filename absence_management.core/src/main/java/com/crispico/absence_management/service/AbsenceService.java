package com.crispico.absence_management.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.crispico.absence_management.dao.AbsenceHibernateDao;
import com.crispico.absence_management.model.Absence;

public class AbsenceService {

	protected AbsenceHibernateDao dao = new AbsenceHibernateDao();
	
	public List<Absence> getAllAbsences() {
		return dao.getAbsences();
	}
	
	public void deleteAbsence(long id){
		Absence absence = dao.getAbsenceById(id);
		dao.delete(absence);
	}
	
	public void addAbsence(Absence absence) throws ParseException{
//		SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd"); 
//		absence.setStartDate(dt.parse(absence.getStartDate().)); 
		dao.save(absence);
	}
}
