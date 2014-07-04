package com.crispico.absence_management.model;

public class AbsenceType {
	
	private long id;
	
	private String absenceName;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAbsenceName() {
		return absenceName;
	}

	public void setAbsenceName(String absenceName) {
		this.absenceName = absenceName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((absenceName == null) ? 0 : absenceName.hashCode());
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
		if (absenceName == null) {
			if (other.absenceName != null)
				return false;
		} else if (!absenceName.equals(other.absenceName))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return absenceName;
	}
	
}
