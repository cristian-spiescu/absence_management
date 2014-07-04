package com.crispico.absence_management.model;

import java.util.Date;

public class Absence {
	
	private long id;
	
	private Employee emp;
	
	private Date date_start;
	
	private Date date_end;
	
	private AbsenceType typeAbs;	
	
	public AbsenceType getTypeAbs() {
		return typeAbs;
	}

	public void setTypeAbs(AbsenceType typeAbs) {
		this.typeAbs = typeAbs;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public Date getDate_start() {
		return date_start;
	}

	public void setDate_start(Date date_start) {
		this.date_start = date_start;
	}

	public Date getDate_end() {
		return date_end;
	}

	public void setDate_end(Date date_end) {
		this.date_end = date_end;
	}

	
	@Override
	public String toString() {
		return "Date_start:" + date_start + ", Date_end:" + date_end
				+ ", Type :" + typeAbs + "]" + "\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((date_end == null) ? 0 : date_end.hashCode());
		result = prime * result
				+ ((date_start == null) ? 0 : date_start.hashCode());
		result = prime * result + ((emp == null) ? 0 : emp.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((typeAbs == null) ? 0 : typeAbs.hashCode());
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
		if (date_end == null) {
			if (other.date_end != null)
				return false;
		} else if (!date_end.equals(other.date_end))
			return false;
		if (date_start == null) {
			if (other.date_start != null)
				return false;
		} else if (!date_start.equals(other.date_start))
			return false;
		if (emp == null) {
			if (other.emp != null)
				return false;
		} else if (!emp.equals(other.emp))
			return false;
		if (id != other.id)
			return false;
		if (typeAbs == null) {
			if (other.typeAbs != null)
				return false;
		} else if (!typeAbs.equals(other.typeAbs))
			return false;
		return true;
	}
}
