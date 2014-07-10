package com.crispico.absence_management.service;

import java.util.List;

import com.crispico.absence_management.dao.AbsenceTypeHibernateDao;
import com.crispico.absence_management.model.AbsenceType;

public class AbsenceTypeService {

	protected AbsenceTypeHibernateDao daoa = new AbsenceTypeHibernateDao();
	
	public String sayHello(String name) {
		System.out.println(name);
		return "Hello " + name;
	}

	public List<AbsenceType> getAllAbsencesType() {
		return daoa.getAll();
	}
	

}
