package com.crispico.absence_management.model {
	import mx.collections.ArrayCollection;
	
	[Bindable]
	[RemoteClass(alias="com.crispico.absence_management.model.AbsenceType")]
	
	public class AbsenceType {
	
		public var id:Number;
		
		public var type:String;
		
		public var absences:ArrayCollection = new ArrayCollection();

	}
}