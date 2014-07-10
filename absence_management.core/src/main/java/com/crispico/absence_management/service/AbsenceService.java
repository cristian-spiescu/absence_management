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
	
	public void deleteAbsence(Absence absence){
		dao.delete(absence);
	}
	
	public void updateAbsence(Absence absence){
		dao.update(absence);
	}
	
	public Absence addAbsence(Absence absence) {
		dao.save(absence);
		return absence;
	}
}
