package com.crispico.chart
{
	import flash.events.Event;
	
	import mx.collections.ArrayCollection;
	
	import spark.components.HGroup;

	
	public class Chart extends HGroup
	{
		private var _dataProvider:ArrayCollection;
		private var _maxInterval:Number;
		public var selected:IntervalDate;
		public var selectedItem:MyRender;

		public function get maxInterval():Number
		{
			return _maxInterval;
		}

		public function set maxInterval(value:Number):void
		{
			_maxInterval = value;	
		}

		public function get dataProvider():ArrayCollection
		{
			return _dataProvider;
		}

		public function set dataProvider(value:ArrayCollection):void
		{
			_dataProvider = value;
			dataProviderFill(dataProvider);
			
		}
		public function onSelectionChanged(event:Event):void{
			selectedItem = MyRender(event.target);
		}
		public function dataProviderFill(dataProvider:ArrayCollection):void
		{
			this.removeAllElements();
			this.gap = 0;
			for each(var obj:IntervalDate in dataProvider){
				var newRender:MyRender = new MyRender();
				newRender.addEventListener("selectionChanged", onSelectionChanged);
				newRender.Period = obj.period;
				newRender.idInterval = obj.id;
				newRender.newWidth = uint((obj.period * maxInterval)/21);
				newRender.color = obj.color;
				newRender.colorStroke = obj.color;
				newRender.newAlpha = "0.5";
				this.addElement(newRender);	
			}
		}

	}
}