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
		
		public static function getDaysBetweenDates(date1:Date,date2:Date):int {
			var one_day:Number = 1000 * 60 * 60 * 24
			var date1_ms:Number = date1.getTime();
			var date2_ms:Number = date2.getTime();
			var difference_ms:Number = Math.abs(date1_ms - date2_ms); 
			return Math.round(difference_ms/one_day) + 1;
		}
	}

}