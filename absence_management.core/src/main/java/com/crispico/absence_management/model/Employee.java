package com.crispico.absence_management.model;

import java.util.HashSet;
import java.util.Set;

public class Employee {

	private long id;

	private String firstName;

	private String lastName;
	
	Set<Absence> absenceList = new HashSet<>();
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}



	public Set<Absence> getAbsenceList() {
		return absenceList;
	}

	public void setAbsenceList(Set<Absence> absenceList) {
		this.absenceList = absenceList;
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

	@Override
	public String toString() {
		return id+ " " + firstName + " "+ lastName ;
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
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
