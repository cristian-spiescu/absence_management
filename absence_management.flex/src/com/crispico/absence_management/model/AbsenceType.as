package com.crispico.absence_management.model {
	
	import mx.collections.ArrayCollection;
	
	[Bindable]
	[RemoteClass(alias="com.crispico.absence_management.model.AbsenceType")]
	
	public class AbsenceType {
	
		public var idT: Number;
		
		public var absenceType: String;
		
		public var absenceList: ArrayCollection = new ArrayCollection(); 

	}
}