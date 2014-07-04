package com.crispico.absence_management.model;

import java.util.Date;

public class Absence{

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
	public void setStartDate(Date start) {
		this.startDate = start;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date end) {
		this.endDate = end;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee emp) {
		this.employee = emp;
	}
	public AbsenceType getType() {
		return type;
	}
	public void setType(AbsenceType type) {
		this.type = type;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result
				+ ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (id != other.id)
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return startDate + " - " + endDate + ": " + type;
	}
	
}