package com.crispico.absence_management.model;

import java.util.Date;

public class Absence {
	private long id;
	private Date startDate;
	private Date endDate;
	private Employee employee;
	private AbsenceType type;
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public AbsenceType getType() {
		return type;
	}

	public void setType(AbsenceType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Absence [id ="+id+", startDate="+startDate+", endDate="+endDate+"]";
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
		Absence other = (Absence) obj;
		if (id != other.id)
			return false;
		return true;
	}

	
}
