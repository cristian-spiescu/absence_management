package com.crispico.absence_management.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.crispico.absence_management.dao.EmployeeHibernateDao;

public class Employee {

	private long id;

	private String firstName;

	private String lastName;

	private Set<Absence> absences; 
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public void setAbsences(Set<Absence> abs){
		absences = abs;
	}
	
	public Set<Absence> getAbsences(){
		return absences;
	}
	
	public String printAbsences(){
		String rez = new String();
		for(Absence abs : absences){
			rez += abs.getStart_date().toString();
			rez += ":";
			rez += abs.getEnd_date().toString();
			rez += " ";
			rez += abs.getType().getType();
			rez += ";";
		}
		return rez;
	}
	
	public void deleteEmployee(long id){
		EmployeeHibernateDao dao = new EmployeeHibernateDao();
		dao.delete(id);
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

}
