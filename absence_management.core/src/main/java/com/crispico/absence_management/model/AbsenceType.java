package com.crispico.absence_management.model;

import java.util.HashSet;
import java.util.Set;


public class AbsenceType {
	private long idT;
	private String absenceType;
	Set<Absence> absenceList = new HashSet<>();
	
	public Set<Absence> getAbsenceList() {
		return absenceList;
	}
	public void setAbsenceList(Set<Absence> absenceList) {
		this.absenceList = absenceList;
	}
	public String getAbsenceType() {
		return absenceType;
	}
	public void setAbsenceType(String absenceType) {
		this.absenceType = absenceType;
	}
	@Override
	public String toString() {
		return absenceType ;
	}
	public long getIdT() {
		return idT;
	}
	public void setIdT(long id) {
		this.idT = id;
	}


}
