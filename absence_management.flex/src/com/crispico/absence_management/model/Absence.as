package com.crispico.absence_management.model {
	
	[Bindable]
	[RemoteClass(alias="com.crispico.absence_management.model.Absence")]
	public class Absence {
		public var startDate: Date;
		public var endDate: Date;
		public var employeeID: Number;
		public var ID: Number;
		public var typeId: Number;
		public var employee: Employee;
		public var absenceType: AbsenceType;
		
	}
}

