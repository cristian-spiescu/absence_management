package com.crispico.absence_management.model;

public class Absence {
	
	private long id;

	private AbsenceType absType;

	private String lastName;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public AbsenceType getAbsType() {
		return absType;
	}

	public void setAbsType(AbsenceType absType) {
		this.absType = absType;
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public String toString() {
		return "Absence [id=" + id + ", absType=" + absType + ", lastName="
				+ lastName + "]";
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}