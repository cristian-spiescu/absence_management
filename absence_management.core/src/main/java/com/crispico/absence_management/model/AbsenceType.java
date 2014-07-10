package com.crispico.absence_management.model;

import java.util.HashSet;
import java.util.Set;

public class AbsenceType {

	public enum Type {
		MEDICAL, FREEDAY, PAIDDAY, NOTSPECIFIED,
	}

	private long id;
	private String absenceType;
	/* absences sunt cele din clasa Absence, dar la afisare, afisam enum Type-ul */
	private Set<Absence> absences = new HashSet<Absence>();

	
	public String getAbsenceType() {
		return absenceType;
	}

	public void setAbsenceType(String absenceType) {
		this.absenceType = absenceType;
	}

	@Override
	public String toString() {
		return absenceType;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Set<Absence> getAbsences() {
		return absences;
	}

	public void setAbsences(Set<Absence> absences) {
		this.absences = absences;
	}

}
