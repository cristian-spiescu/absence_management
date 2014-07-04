package com.crispico.absence_management.model
{
	[Bindable]
	[RemoteClass(alias="com.crispico.absence_management.model.Absence")]
	public class Absence
	{
		public var absenceId:Number;
		
		public var startDate:Date;
		
		public var EndDate:Date;
		
		public var employee:Employee;
		
		public var absenceType:AbsenceType;
	}
}