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
		return "[type = " + type + " ]";
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbsenceType other = (AbsenceType) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
