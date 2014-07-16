package com.crispico.chart
{
	import flash.events.Event;
	import flash.events.MouseEvent;
	import flash.geom.Point;
	
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	import mx.controls.ToolTip;
	import mx.events.CollectionEvent;
	import mx.managers.ToolTipManager;
	
	import spark.components.HGroup;

	public class Chart extends HGroup   
		
	{
		public var maxIntervar:Number;
		
		private var _dataProvider:ArrayCollection;
		
		public var selected:DataRenderer;
		
		private var _lengthOfChart:Number;
		
		public var myTip:ToolTip;
		  
		
		
		public function Chart() {
			super();
		}
		
		[Bindable]
		public function get lengthOfChart():Number {
			return _lengthOfChart;
		}

		public function set lengthOfChart(value:Number):void {
			_lengthOfChart = value;
		}

		public function get dataProvider():ArrayCollection {
			return _dataProvider;
		}

		public function set dataProvider(value:ArrayCollection):void {
			if(_dataProvider != null){
				_dataProvider.removeEventListener(CollectionEvent.COLLECTION_CHANGE, modify);
			}
			_dataProvider = value;
			_dataProvider.addEventListener(CollectionEvent.COLLECTION_CHANGE,modify);
		}


		
		public function modify(event:Event):void {
			this.removeAllElements();
			for each(var i:IntervalData in _dataProvider){
				var item:DataRenderer = new DataRenderer();
				item.data = i;
				addElement(item);
				item.addEventListener(MouseEvent.CLICK,clickedColumn);
				item.addEventListener(MouseEvent.MOUSE_OVER,showIntervalValue);
				item.addEventListener(MouseEvent.MOUSE_OUT,destroyBigTip);
			}
		}
		
		public function clickedColumn(event:MouseEvent):void {
			if(selected != null){
				selected.data.color += 0x333333
			}
			var item:DataRenderer = new DataRenderer();
			item = DataRenderer(event.target);
			item.data.color -= 0x333333;
			selected = item;
			parentDocument.intervalText.text = String(int(selected.data.value / parentDocument.width * lengthOfChart));
			
			
		}
		
		public function showIntervalValue(event:MouseEvent):void {
			var item:DataRenderer = new DataRenderer();
			item = DataRenderer(event.target);
			var pt:Point = new Point();
			pt.x = item.x;
			pt.y = item.y;
			pt = localToGlobal(pt);
			
			myTip = ToolTipManager.createToolTip(String(int(item.data.value / parentDocument.width * lengthOfChart)),pt.x,pt.y) as ToolTip;
			myTip.setStyle("backgroundColor",0xf5f5dc);
			myTip.width = 50;
			myTip.height = 25;
		}
		
		private function destroyBigTip(event:MouseEvent):void {
			ToolTipManager.destroyToolTip(myTip);
		}
		
		public function redimensionChart(coeficient:Number):void {
			var sumOfIntervals:Number = this.lengthOfChart - this.getFreeIntervalSpace();
			
			if(sumOfIntervals > coeficient){
				Alert.show("Nu se poate redimensiona! Intervale prea mari!");
				return;
			}
			for each(var item:IntervalData in dataProvider){
				item.value = (item.value * lengthOfChart) / coeficient;
			}
			lengthOfChart = coeficient;
		}
		
		public function getFreeIntervalSpace():Number {
			var result:Number = 0;
			for each(var item:IntervalData in dataProvider){
				result += item.value  / parentDocument.width * lengthOfChart;
			}
			return lengthOfChart - result;
		}
		
		
	}
}