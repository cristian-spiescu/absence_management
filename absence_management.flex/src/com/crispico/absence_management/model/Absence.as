package com.crispico.absence_management.model {
	
	[Bindable]
	[RemoteClass(alias="com.crispico.absence_management.model.Absence")]
	public class Absence {
		
		public var absence_id:Number;
		
		public var employee:Employee;
		
		public var type:AbsenceType;
		
		public var start:Date;
		
		public var finish:Date;
		
	}
}
