package com.crispico.absence_management.model;

import java.util.Date;

public class Absence {

	/* Atribute */
	private long id;
	private Date startDate;
	private Date endDate;
	private Employee employee;
	private AbsenceType absenceType;

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

	public void setEmployee(Employee e) {
		this.employee = e;
	}

	public Employee getEmployee() {
		return employee;
	}

	@Override
	public String toString() {
		return "Absence [id=" + id + ", startDate=" + startDate + ", endDate="
				+ endDate + ", employee=" + employee + ", absenceType="
				+ absenceType + "]";
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
