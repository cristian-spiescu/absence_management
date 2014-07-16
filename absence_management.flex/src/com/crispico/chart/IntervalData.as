package com.crispico.chart
{
	public class IntervalData
	{
		[Bindable]
		private var _value:Number;
		[Bindable]
		private var _color:uint;
		
		public function IntervalData() {
			super();
		}

		public function get value():Number {
			return _value;
		}

		public function set value(value:Number):void {
			_value = value;
		}

		public function get color():uint {
			return _color;
		}

		public function set color(value:uint):void {
			_color = value;
		}

	}
}