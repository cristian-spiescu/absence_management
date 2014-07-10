package com.crispico.absence_management.model;

public class AbsenceType {

	private long id;

	private String type;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public void setType(String type){
		this.type = type;
	}
	
	public String getType(){
		return this.type;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbsenceType other = (AbsenceType) obj;
		if (!type.equals(other.type))
			return false;
		return true;
	}
	
}
