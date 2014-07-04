package com.crispico.absence_management.model;

import java.util.HashSet;
import java.util.Set;

public class AbsenceType {
	
	private long id;
	
	private String description;

	private Set<Absence> absSet = new HashSet<Absence>();
	
	public Set<Absence> getAbsSet() {
		return absSet;
	}

	public void setAbsSet(Set<Absence> absSet) {
		this.absSet = absSet;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return description;
	}	
}
