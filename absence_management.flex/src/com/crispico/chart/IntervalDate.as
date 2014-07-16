package com.crispico.chart
{
	public class IntervalDate
	{
		private var _id:Number;
		
		private var _period:Number;
		
		private var _color:String;

		public function get id():Number
		{
			return _id;
		}

		public function set id(value:Number):void
		{
			_id = value;
		}

		public function get color():String
		{
			return _color;
		}

		public function set color(value:String):void
		{
			_color = value;
		}

		public function get period():Number
		{
			return _period;
		}

		public function set period(value:Number):void
		{
			_period = value;
		}

	}
}