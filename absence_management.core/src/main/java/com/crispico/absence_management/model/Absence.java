package com.crispico.absence_management.model;

import java.util.ArrayList;
import java.util.Date;

public class Absence {
	private AbsenceType type;
	private Employee employee;
	private long absence_id;
	
	private Date start;
	private Date finish;
		
	public AbsenceType getType() {
		return type;
	}
	public void setType(AbsenceType type) {
		this.type = type;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
//		ArrayList<Absence> aal = employee.getAbsences();
//		aal.add(this);
//		employee.setAbsences(aal);
	}
	public long getAbsence_id() {
		return absence_id;
	}
	public void setAbsence_id(long absence_id) {
		this.absence_id = absence_id;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getFinish() {
		return finish;
	}
	public void setFinish(Date finish) {
		this.finish = finish;
	}
	@Override
	public String toString() {
		return "Absence [type=" + type + ", employee=" + employee + ", id="
				+ absence_id + ", start=" + start + ", finish=" + finish + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (absence_id ^ (absence_id >>> 32));
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
		if (absence_id != other.absence_id)
			return false;
		return true;
	}
	
	
	
}
