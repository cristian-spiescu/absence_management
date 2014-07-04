package com.crispico.absence_management.model;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Absence {

	private long id;
	
	//DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	private Date start_date;
	
	private Date end_date;
	
	private Employee employee;
	
	private AbsenceType type;
	
	public void setId(long id){
		this.id=id;
	}
	
	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	
	public long getId(){
		return this.id;
	}
	
	public AbsenceType getType() {
		return type;
	}

	public void setType(AbsenceType type) {
		this.type = type;
	}

	public void setEmployee(Employee employee){
		this.employee=employee;
	}
	
	public Employee getEmployee(){
		return this.employee;
	}
	
}
