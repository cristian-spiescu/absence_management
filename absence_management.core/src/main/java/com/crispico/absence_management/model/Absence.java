package com.crispico.absence_management.model;

import java.util.Date;


public class Absence {
	private long id;
	private Date startDate;
	private Date endDate;
	private Employee employee;
	private AbsenceType absenceType;
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date date) {
		this.startDate = date;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	@Override
	public String toString() {
		return "Absence [ Start date=" + startDate + ", End date=" + endDate + "]";
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public AbsenceType getAbsenceType() {
		return absenceType;
	}
	public void setAbsenceType(AbsenceType absenceType) {
		this.absenceType = absenceType;
	}


	
}
