package com.crispico.absence_management.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Employee {

	private long id;

	private String firstName;

	private String lastName;
	
	private Set<Absence> absences = new HashSet<Absence>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Set<Absence> getAbsences() {
		if (absences.size()!=0)
			return absences;
		return new HashSet<Absence>();
	}

	public void setAbsences(Set<Absence> lista) {
		this.absences = lista;
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
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
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
	
	public void addToAbsences(Absence ab) {
        this.getAbsences().add(ab);
        ab.setEmployee(this);
    }

    public void removeFromAbsences(Absence ab) {
        this.getAbsences().remove(ab);
    }

    public String showAbsences() {
    	String st = "";
    	for (Absence ab : absences) {
    		st += ab.getType().getType() + " [ " + ab.getStart() + " - " + ab.getFinish() + " ]<br />";
    	}
    	return st;	
    }
    
}
