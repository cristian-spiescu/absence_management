package com.crispico.chart
{
	[Bindable]
	public class IntervalDate {
		
		private var _value:Number;

		private var _color:uint;
		
		public function IntervalDate(){
		}
		
		/* getter for value */
		public function get value():Number{
			return this._value;
		}
		
		/* getter for color */
		public function get color():uint{
			return this._color;
		}
		
		/* setter for value */
		public function set value(value:Number):void{
			this._value = value;
		}
		
		/* setter for color */
		public function set color(color:uint):void{
			this._color = color;
		}
		
	}
}