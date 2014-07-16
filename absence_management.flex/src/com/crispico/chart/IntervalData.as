package com.crispico.chart
{
	[Bindable]
	public class IntervalData {
		
		private var _value : Number;
		
		private var _color : uint;
		
		/* Constructor */
		public function IntervalData() {
			super();
		}
		
		/* Setter for value */
		public function set value(val : Number): void {
			_value = val;
		}
		
		/* Setter for color */
		public function set color(col : uint) : void {
			_color = col;
		}

		/* Getter for value */
		public function get value() : Number {
			return _value;
		}
		
		/* Getter for color */
		public function get color() : uint {
			return _color;
		}
	}
}