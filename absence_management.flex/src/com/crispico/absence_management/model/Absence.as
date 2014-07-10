package com.crispico.absence_management.model {
	
	import com.crispico.absence_management.model.AbsenceType;
	
	[Bindable]
	[RemoteClass(alias="com.crispico.absence_management.model.Absence")]
	
	public class Absence {
		
		public var id:Number;
		
		public var absenceType: AbsenceType;
		
		public var startDate : Date;
		
		public var endDate : Date;
		
		public var employee : Employee;	
	}
}