package com.crispico.absence_management.model;

import java.util.HashSet;
import java.util.Set;

public class AbsenceType {
	private long id;
	private String type;
	
	private Set<Absence> absences = new HashSet<Absence>();

	public Set<Absence> getAbsences() {
		return absences;
	}

	public void setAbsences(Set<Absence> absences) {
		this.absences = absences;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[type = "+type+" ]";
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
