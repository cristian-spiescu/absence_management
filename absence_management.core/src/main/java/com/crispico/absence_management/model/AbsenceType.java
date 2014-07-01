package com.crispico.absence_management.model;

import java.util.Date;

public class AbsenceType {
	
	private long id;

	private Date start;

	private Date end;

	@Override
	public String toString() {
		return "AbsenceType [id=" + id + ", start=" + start + ", end=" + end
				+ "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}


}
