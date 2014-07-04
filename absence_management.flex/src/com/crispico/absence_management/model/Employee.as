package com.crispico.absence_management.model {
	
	[Bindable]
	[RemoteClass(alias="com.crispico.absence_management.model.Employee")]
	public class Employee {
	
		public var id:Number;
		
		public var firstName:String;
		
		public var lastName:String;

	}
}