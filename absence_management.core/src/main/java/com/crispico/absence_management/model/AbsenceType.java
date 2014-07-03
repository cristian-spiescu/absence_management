package com.crispico.absence_management.model;

import java.util.Set;

public class AbsenceType {
	private long absence_type_id;

	private String type;
	
//	private Set<Absence> absence_per_type;

//	public Set<Absence> getAbsence_per_type() {
//		return absence_per_type;
//	}

//	public void setAbsence_per_type(Set<Absence> absence_per_type) {
//		this.absence_per_type = absence_per_type;
//	}

	public long getAbsence_type_id() {
		return absence_type_id;
	}

	public void setAbsence_type_id(long absence_type_id) {
		this.absence_type_id = absence_type_id;
	}

		
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	

	@Override
	public String toString() {
		return "AbsenceType [absence_type_id=" + absence_type_id + ", type="
				+ type + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (absence_type_id ^ (absence_type_id >>> 32));
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
		if (absence_type_id != other.absence_type_id)
			return false;
		return true;
	}
	
}
