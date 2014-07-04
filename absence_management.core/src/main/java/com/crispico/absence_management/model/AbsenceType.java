package com.crispico.absence_management.model;

//import java.util.List;

public class AbsenceType {
	
	private long id;
	
	private String typeAbsence;
	
	public String getTypeAbsence() {
		return typeAbsence;
	}

	public void setTypeAbsence(String typeAbsence) {
		this.typeAbsence = typeAbsence;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return typeAbsence;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result
				+ ((typeAbsence == null) ? 0 : typeAbsence.hashCode());
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
		if (typeAbsence == null) {
			if (other.typeAbsence != null)
				return false;
		} else if (!typeAbsence.equals(other.typeAbsence))
			return false;
		return true;
	}
}
