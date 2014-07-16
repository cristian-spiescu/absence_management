package com.crispico.absence_management.model;

import java.util.Date;

public class Absence {

	private long absenceId;

	private Date startDate;

	private Date endDate;

	private Employee employee;

	private AbsenceType absenceType;

	public long getAbsenceId() {
		return absenceId;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setAbsenceId(long absenceId) {
		this.absenceId = absenceId;
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

	//public void setEndDate(Date endDate) {
	//	EndDate = endDate;
	//}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public AbsenceType getAbsenceType() {
		return absenceType;
	}

	public void setAbsenceType(AbsenceType absenceType) {
		this.absenceType = absenceType;
	}

	
	
}
