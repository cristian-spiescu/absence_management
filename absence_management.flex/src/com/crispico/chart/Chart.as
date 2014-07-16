package com.crispico.chart{
	import flash.events.Event;
	import flash.events.MouseEvent;
	
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	import mx.events.CollectionEvent;
	
	import spark.components.HGroup;

	public class Chart extends HGroup{
		
		public var maxInterval:Number;
		private var _dataProvider:ArrayCollection = null;
		[Bindable]
		public var selected:DataRenderer;
		public var parentWidth:Number;
		public var spaceLeft:Number;
		
		private var _totalLengthOfIntervals:Number = 21;
		
		public function Chart(){
		}

		public function checkSpaceLeft():void{
			spaceLeft = _totalLengthOfIntervals;
			for each(var item:IntervalData in _dataProvider){
				spaceLeft -= item.value * _totalLengthOfIntervals /  parentDocument.width;
			}
		}
		
		[Bindable]
		public function get totalLengthOfIntervals():Number{
			return _totalLengthOfIntervals;
		}

		public function set totalLengthOfIntervals(value:Number):void{
			
				_totalLengthOfIntervals = value;
		}

		public function get dataProvider():ArrayCollection{
			return _dataProvider;
		}
		
		public function set dataProvider(value:ArrayCollection):void {
			if(_dataProvider != null){
				_dataProvider.removeEventListener(CollectionEvent.COLLECTION_CHANGE,modified);
			}
			_dataProvider = value;
			_dataProvider.addEventListener(CollectionEvent.COLLECTION_CHANGE,modified);
		}
	
		public function modified(event:Event):void{
			this.removeAllElements();
			for each(var i:IntervalData in _dataProvider){
				var item:DataRenderer = new DataRenderer();
				item.data = i;
				addElement(item);
				item.addEventListener(MouseEvent.CLICK,clicked);
			}
		}
		
		public function clicked(event:MouseEvent):void{
			if(selected != null){
				selected.data.color -= 0x333333;
			}
			selected = DataRenderer(event.target);
			selected.data.color += 0x333333;
			
			if(selected.data.value * totalLengthOfIntervals / parentDocument.width > 0){
				parentDocument.selectedIntervalValueString = String(selected.data.value * totalLengthOfIntervals / parentDocument.width);
				parentDocument.enable = true;
			}
		}
		
		public function scaleValue(chartWidth:Number,data:IntervalData):void{
			data.value = data.value * chartWidth / _totalLengthOfIntervals;
		}
		
		public function scaleChart(newTotalLengthOfIntervals:Number):void{
			for each(var item:IntervalData in _dataProvider){
				item.value = item.value * totalLengthOfIntervals / newTotalLengthOfIntervals;
			}
			totalLengthOfIntervals = newTotalLengthOfIntervals;
		}
		
		
		
	}
}