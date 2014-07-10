package com.crispico.absence_management.model {
	import mx.collections.ArrayCollection;
	
	[Bindable]
	[RemoteClass(alias="com.crispico.absence_management.model.Employee")]
	public class Employee {
	
		public var id:Number;
		
		public var firstName:String;
		
		public var lastName:String;
		
		
		public var absences:ArrayCollection;
		
		

	}
}