package com.crispico.absence_management.model{
	
	[Bindable]
	[RemoteClass(alias="com.crispico.absence_management.model.Absence")]
	public class Absence{
		
		public var id:Number;
		
		public var startDate:String;
		
		public var endDate:String;
		
		public var absenceType:AbsenceType;
		
		public var employee:Employee;

	}
}