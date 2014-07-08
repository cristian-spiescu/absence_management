package com.crispico.absence_management.model {
	
	[Bindable]
	[RemoteClass(alias="com.crispico.absence_management.model.Absence")]
	
	public class Absence {
	
		public var id:Number;
		
		public var startDate:Date;
		
		public var endDate:Date;
		
		public var type:AbsenceType;
		
		public var employee:Employee;
		
//		public function asdfsda(){
//			//endDate.
//		}

	}
}