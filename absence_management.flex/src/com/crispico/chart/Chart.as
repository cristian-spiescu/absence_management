package com.crispico.chart {
	
	import flash.events.Event;
	import flash.events.MouseEvent;
	import flash.geom.Point;
	
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	import mx.controls.ToolTip;
	import mx.core.IVisualElement;
	import mx.events.CollectionEvent;
	import mx.events.CollectionEventKind;
	import mx.events.PropertyChangeEvent;
	import mx.managers.ToolTipManager;
	
	import spark.components.HGroup;

	public class Chart extends HGroup {
			
		[Bindable]
		private var _dataProvider : ArrayCollection;

		[Bindable]
		private var _selected : ChartRenderer;
		
		private static var DEFAULT_MAX_INTERVAL : Number = 21;

		private var _maxInterval : Number;

		[Bindable]
		private var _remainingSpace : Number;

		private var _visualItems : ArrayCollection;
		
		private var _myTip : ToolTip;

		public function Chart() {
			super();
			
			/* This is the default Value */
			_maxInterval = DEFAULT_MAX_INTERVAL;
						
			/* Instantiate _visualItems */
			_visualItems = new ArrayCollection();
						
			_remainingSpace = new Number();
		}
		
		/* Setter for dataProvider */
		[Bindable]
		public function set dataProvider(value : ArrayCollection): void {
			_dataProvider = value;
			_dataProvider.addEventListener(CollectionEvent.COLLECTION_CHANGE, updateVisualChild);
		}
		
		/* Getter for dataProvider */
		public function get dataProvider() : ArrayCollection {
			return _dataProvider;
		}
		
		/* Setter for maxInterval */
		public function set maxInterval(value : Number) : void {	
			/* check if the new interval fits */
			var checked : Boolean = checkForConsistency(value);
			if (checked == true) {
			
				if (value <= 100) {
					_maxInterval = value;
				} else {
					_maxInterval = DEFAULT_MAX_INTERVAL;
				}
	
				maxIntervalChanged();
			} else {
				Alert.show("No more space in interval! Please choose a higher value for interval", "Interval Limit Exceeded!");
			}
		}
		
		/* Getter for maxInterval */
		public function get maxInterval() : Number {
			return _maxInterval;
		}
		
		/* Setter for selected */
		
		/* Getter for selected */
		public function get selected():ChartRenderer{
			return this._selected;
		}		
		
		/* Setter for the value of selected Item */
		[Bindable]
		public function set selectedValue(value : Number) : void {
			if (this._selected != null) { 
				
				var space : Number = parent.width;
				var selectedItemIndex : Number = _visualItems.getItemIndex(_selected);
				for (var i:int = 0; i < _visualItems.length; i++) {
					if (i != selectedItemIndex) {
						space -= ChartRenderer(_visualItems.getItemAt(i)).data.value;
					}
				}
				var addedValue : int = value * parent.width / this._maxInterval;
				space -= addedValue;
				if (space >= 0) {
					this._selected.data.value = addedValue; 
				} else {
					Alert.show("Cannot resize with this value", "Interval Limit Exceeded");
				}
			}
		}
		
		/* Getter for the value of selected Item */ 
		public function get selectedValue() : Number { 
			if (this._selected != null) {
				return this._selected.data.value;
			} else {
				return 0;
			}
		}
		
		/* function to check if there is enough space */
		public function enoughSpace() : Boolean {
			_remainingSpace = this.parent.width;
			
			for each (var chartRenderer:ChartRenderer in _visualItems) {
				_remainingSpace -= chartRenderer.data.value;
				
				if (_remainingSpace < 0) {
					return false;
				}
			}
			return true;
		}
		
		/* function called when _dataProvider is changed */
		protected function updateVisualChild(event:CollectionEvent):void {		
			
			/* first remove old listeners */
			for each (var visualItem:ChartRenderer in this._visualItems) {
				visualItem.removeEventListener(MouseEvent.CLICK, mouseEventClickHandler);
				visualItem.removeEventListener(MouseEvent.MOUSE_OVER, mouseEventMouseOverHandler);
				visualItem.removeEventListener(MouseEvent.MOUSE_OUT, mouseEventMouseOutHandler);
			}
			
			this.removeAllElements();
			this._visualItems.removeAll();
			
			for each (var intervalData:IntervalData in this._dataProvider) {				
				var chartRenderer : ChartRenderer = new ChartRenderer();
				
				var newIntervalData : IntervalData = new IntervalData();
				newIntervalData.color = intervalData.color;
				
				newIntervalData.value = int(intervalData.value * parent.width / this._maxInterval);

				chartRenderer.data = newIntervalData;
				chartRenderer.addEventListener(MouseEvent.CLICK, mouseEventClickHandler);
				chartRenderer.addEventListener(MouseEvent.MOUSE_OVER, mouseEventMouseOverHandler);
				chartRenderer.addEventListener(MouseEvent.MOUSE_OUT, mouseEventMouseOutHandler);
							
				/* add children and to visual Items */
				this.addElement(chartRenderer);
				this._visualItems.addItem(chartRenderer);
			}
			
			/* check if ADD worked */
			if (event.kind == CollectionEventKind.ADD && !enoughSpace() && _dataProvider != null) {
				Alert.show("No more space in interval!" , "Interval Limit Exceeded!");
				this.removeElement(ChartRenderer(this._visualItems.getItemAt(this._visualItems.length - 1)));
			}
		}
		
		/* function called on Mouse Click on selected item */
		protected function mouseEventClickHandler(event : Event) : void {
			if (_selected != null) {
				_selected.data.color += 0x111111;
			}
			
			_selected = ChartRenderer(event.target);			
			_selected.data.color -= 0x111111;
		}
				
		/* override removeElement */
		override public function removeElement(element:IVisualElement):IVisualElement { 
			var index : int = _visualItems.getItemIndex(element);

			if (index != -1) {
				_dataProvider.removeItemAt(index);
			}

			return element; 
		}
		
		/* redraw when maxInterval changes */
		protected function maxIntervalChanged() : void {
			var newEvent : CollectionEvent = new CollectionEvent(CollectionEvent.COLLECTION_CHANGE);
			updateVisualChild(newEvent);
		}
		
		/* check if the new interval fits */
		protected function checkForConsistency(value : Number) : Boolean {
			if (_dataProvider != null){
				var space : Number = parent.width;
				for each (var chartRenderer:ChartRenderer in this._visualItems) {				
					space -= chartRenderer.data.value * this._maxInterval / value;

					if (space < 0) {
						return false;
					}
				}
				return true;
			}
			return true;
		}
		
		/* event when mouse Over */
		public function mouseEventMouseOverHandler(event:Event) : void {
			var theSelected : ChartRenderer = ChartRenderer(event.currentTarget);
			
			var s:String = (int(theSelected.data.value * this._maxInterval / parent.width) + 1) + "";
			
			var pt:Point = new Point(theSelected.x + 5, theSelected.y + 5);
			pt = localToGlobal(pt);
			_myTip = ToolTipManager.createToolTip(s,
				pt.x,
				pt.y) as ToolTip;
			
			_myTip.setStyle("backgroundColor",0xFFFF99);
			_myTip.width = 80;
			_myTip.height = 40;
		}
		
		/* event when mouse Out */
		public function mouseEventMouseOutHandler(event:Event) : void {
			ToolTipManager.destroyToolTip(_myTip);
		}
	}

}