package com.crispico.absence_management.model{
	
	[Bindable]
	[RemoteClass(alias="com.crispico.absence_management.model.Absence")]
	public class Absence{
		
		public var id:Number;
		
		public var start_date:Date;
		
		public var end_date:Date;
		
		public var employee:Employee;
		
		public var type:AbsenceType;
		
	}
}