package com.crispico.absence_management.model;

import java.util.Set;

public class Employee {

	private long ID;

	private String firstName;

	private String lastName;

	private Set<Absence> absences;

	public Set<Absence> getAbsences() {
		return absences;
	}

	public void setAbsences(Set<Absence> absences) {
		this.absences = absences;
	}

	public long getID() {
		return ID;
	}

	public void setID(long ID) {
		this.ID = ID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	// @Override
	// public String toString() {
	// return "Employee [id=" + ID + ", firstName=" + firstName + ", lastName="
	// + lastName + "]";
	// }

	public String getAllAbsences() {
        String a = "";
		for (Absence absence : absences) {
		    //a += absence.getAbsenceType().getType() + "; ";
		    a += absence.toString();
		}
		return a;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (ID ^ (ID >>> 32));
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
		Employee other = (Employee) obj;
		if (ID != other.ID)
			return false;
		return true;
	}

}
