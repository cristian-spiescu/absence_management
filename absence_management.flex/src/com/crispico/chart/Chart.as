package com.crispico.chart
{
	import flash.events.Event;
	import flash.events.MouseEvent;
	
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	import mx.events.CollectionEvent;
	import mx.events.CollectionEventKind;
	
	import spark.components.HGroup;

	public class Chart extends HGroup {
		
		private var _maxInterval:Number;
		
		[Bindable]
		private var _dataProvider:ArrayCollection;
		
		[Bindable]
		private var _selected:ItmRenderer;
		
		private var _items:ArrayCollection = new ArrayCollection();
		
		private var defaultIntervalValue:int = 21;
		
		[Bindable]
		public var space:int;
		
		public function Chart(){
			super();
		}
		
		/* getter for maxInterval */
		public function get maxInterval():Number{
			return this._maxInterval;
		}
		
		/* getter for dataProvider */
		public function get dataProvider():ArrayCollection{
			return this._dataProvider;
		}
		
		/* getter for selected */
		public function get selected():ItmRenderer{
			return this._selected;
		}
		
		[Bindable]
		/* setter for dataProvider */
		public function set dataProvider(value:ArrayCollection):void{
			this._dataProvider = value;
			this._dataProvider.addEventListener(CollectionEvent.COLLECTION_CHANGE,dataProviderEvent);
		}	
		
		/* setter for maxInterval */
		public function set maxInterval(value:Number):void{
			if(checkSpace(value)){
				if(value > this.defaultIntervalValue){
					this._maxInterval = defaultIntervalValue;	
				} else {
					this._maxInterval = value;	
				}
				var eventCollectionChange:CollectionEvent = new CollectionEvent(CollectionEvent.COLLECTION_CHANGE);
				dataProviderEvent(eventCollectionChange);
			}
		}

		/* setter for selectedValue */
		public function set selectedValue(value:Number):void{
			if(this._selected != null){
				this._selected.data.value = (value * parent.width) / this.maxInterval;
			}
		}
		
		/* check space */
		public function checkSpace(value:Number):Boolean{
			if(this._dataProvider != null){
				space = parent.width;
				for each(var items:ItmRenderer in this._items){
					space -= int(items.data.value * this.maxInterval / value);
					if(space < 0){
						Alert.show("Not enough space:check space");
						return false;
					}
				}
			}
			return true;
		}
		
		/* check space when a new item is added */
		public function addCheckSpace():Boolean{
			var space:Number = parent.width;
			for each(var item:ItmRenderer in this._items){
				space -= item.data.value;
				if(space < 0) {
					Alert.show("Not enough space:addCheckSpace");
					return false;
				}
			}
			return true;
		}
		
		/* event to populate Chart with dataProvider */
		protected function dataProviderEvent(event:CollectionEvent):void{
			
			for each(var visualItems:ItmRenderer in this._items){
				visualItems.removeEventListener(MouseEvent.CLICK,mouseEventClickForSelected);
			}
			
			this.removeAllElements();
			this._items.removeAll();
			
			for each(var intervalDate:IntervalDate in this._dataProvider){
				var newInterval:IntervalDate = new IntervalDate();
				newInterval.color = intervalDate.color;
				newInterval.value = int (intervalDate.value * parent.width / this._maxInterval);
				
				var itemRenderer:ItmRenderer = new ItmRenderer();
				itemRenderer.data = newInterval;
				itemRenderer.addEventListener(MouseEvent.CLICK,mouseEventClickForSelected);
				
				this._items.addItem(itemRenderer);
				this.addElement(itemRenderer);
			}
			
			if(event.kind == CollectionEventKind.ADD && !addCheckSpace() && this._dataProvider != null){
				var index:int = this._items.length - 1;
				this._items.removeItemAt(index);
				this._dataProvider.removeItemAt(index);
			}
		}
		
		/* event for selected Item */
		protected function mouseEventClickForSelected(event:Event):void{
			if(_selected != null){
				_selected.data.color += 0x001111;
			}
			
			_selected = ItmRenderer(event.target);
			_selected.data.color -= 0x001111;
			
			//parentDocument.newIntervalValue.text = _selected.data.value;	
		}
		
		/* delete selected Item */
		public function deleteItem(item:ItmRenderer):void {
			for each(var interval:ItmRenderer in this._items){
				if((interval.data.value == item.data.value) && (interval.data.color == item.data.color)){
					var index:int = this._items.getItemIndex(interval);
					this._items.removeItemAt(index);
					this._dataProvider.removeItemAt(index);
				}
			}
		}
	}
}
