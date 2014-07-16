package com.crispico.absence_management.model{
	
	[Bindable]
	[RemoteClass(alias="com.crispico.absence_management.model.Absence")]
	public class Absence {
		
		public var id:Number;
		
		public var emp:Employee;
		
		public var date_start:Date;
		
		public var date_end:Date;
		
		public var typeAbs:AbsenceType;	
	
		public function Absence(){
			super();
		}
		
		
	}
}