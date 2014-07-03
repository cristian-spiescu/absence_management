package com.crispico.absence_management.model;

import java.util.Date;

public class Absence {
	private Date startDate;
	private Date endDate;
	private long employeeID;
	private long ID;
	private long typeId;
	private Employee employee;
	private AbsenceType absenceType;

	public AbsenceType getAbsenceType() {
		return absenceType;
	}

	public void setAbsenceType(AbsenceType absenceType) {
		this.absenceType = absenceType;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public long getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(long employeeId) {
		this.employeeID = employeeId;
	}

	public long getTypeId() {
		return typeId;
	}

	public void setTypeId(long typeId) {
		this.typeId = typeId;
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

	public long getID() {
		return ID;
	}

	public void setID(long ID) {
		this.ID = ID;
	}

	@Override
	public String toString() {
		return "startDate=" + startDate + ", endDate=" + endDate
				+ ", employee=" + employee + ", absenceType=" + absenceType + "<br />";
	}

}
