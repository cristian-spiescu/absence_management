package com.crispico.absence_management.service;

import java.util.List;

import com.crispico.absence_management.dao.AbsenceHibernateDao;
import com.crispico.absence_management.model.Absence;

public class AbsenceService {

	protected AbsenceHibernateDao daoa = new AbsenceHibernateDao();
	
	public String sayHello(String name) {
		System.out.println(name);
		return "Hello " + name;
	}

	public List<Absence> getAllAbsences() {
		return daoa.getAll();
	}
	
	/*Adaugare Absence to DB*/
	public void addAbsenceFromEdit(Absence a)
	{	
		daoa.save(a);
	}
	
	/*Stergere Absence to DB*/
	public void DelAbsenceFromEdit(Absence a)
	{			
		System.out.println("am ajuns aici2");
		daoa.delete(a);
	}
	
	/*Edit Absence to DB*/
	public void editAbsenceFromEdit(Absence a)
	{	
		daoa.update(a);
	}

}
