package com.crispico.absence_management.model;

public class Absence {

	private long id;
	
	private String startDate;
	
	private String endDate;
	
	private Employee employee;
	
	private AbsenceType absenceType;


	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public AbsenceType getAbsenceType() {
		return absenceType;
	}

	public void setAbsenceType(AbsenceType absenceType) {
		this.absenceType = absenceType;
	}

		public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getfullName(){
		return employee.getFirstName() + " " + employee.getLastName();
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

	@Override
	public String toString() {
		return startDate + " - " + endDate +" : " + absenceType.toString();
	}
	
}
