package com.crispico.chart
{
	import flash.events.Event;
	
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	import mx.events.CollectionEvent;
	import mx.events.CollectionEventKind;
	import mx.utils.ColorUtil;
	
	import spark.components.HGroup;
	
	[Event(name="cellSelection")] 
	public class Chart extends HGroup{
		
		private var _dataProvider:ArrayCollection;	
		
		private var _noUnits:Number;
		
		private var _newNoUnits:Number;
		
		private var _unitsUsed:Number;
		
		public var selectedItem:ChartCell;
		
		public function Chart(){
			gap = 0;
			_noUnits = newNoUnits = 21;
			_unitsUsed = 0;
			paddingLeft = 15;			paddingRight = 20;
			paddingBottom = 5;			paddingTop = 5;
			addEventListener("updateUnits", updateUnitsNumber);
		}
		
		public function set dataProvider(d:ArrayCollection):void{
			if(_dataProvider){
				_dataProvider.removeEventListener(CollectionEvent.COLLECTION_CHANGE, updateVisualChild);
			}
			_dataProvider = d;
			if(_dataProvider){
				_dataProvider.addEventListener(CollectionEvent.COLLECTION_CHANGE, updateVisualChild);
			}
		}	
		
		public function get dataProvider():ArrayCollection{
			return _dataProvider;
		}	
		
		public function set newNoUnits(units:Number):void{
			_newNoUnits = units;			
			dispatchEvent(new Event("updateUnits"));			
		}
		
		[Bindable]
		public function get newNoUnits():Number{
			return _newNoUnits;
		}
		
		public function getIntervalDataSelected():IntervalData{
			return IntervalData(selectedItem.data);
		}		
		
		public function addNewItem(item:IntervalData):void{
			if(_noUnits - _unitsUsed == 0)
				Alert.show("You don't have any units left!", "Warning");
			else			
				if(item.value > _noUnits - _unitsUsed)
					Alert.show("You have only " + (_noUnits - _unitsUsed) + " units left!", "Warning");
				else
					dataProvider.addItem(item);			
		}
		
		public function updateItem(newValue:Number, index:Number):void{
			if(newValue <= 0)
				Alert.show("You must enter a value >= 1!", "Warning");
			else
				if(_noUnits - _unitsUsed == 0)
					Alert.show("You don't have any units left!", "Warning");
				else
					if(newValue - IntervalData(dataProvider.getItemAt(index)).value > _noUnits - _unitsUsed)
						Alert.show("You have only " + (_noUnits - _unitsUsed) + " units left!", "Warning");
					else{
						_unitsUsed += (newValue - IntervalData(dataProvider.getItemAt(index)).value);
						IntervalData(dataProvider.getItemAt(index)).value = newValue;			
						var w:Number = width - paddingLeft - paddingRight;
						ChartCell(getElementAt(index)).rect1.width = (newValue * w) / _noUnits;
					}
		}
		
		public function updateVisualChild(event:CollectionEvent):void{
			switch (event.kind) {
				
				case CollectionEventKind.REMOVE: 
					removeElementAt(event.location);
					_unitsUsed -= IntervalData(event.items[0]).value;
					break;
				
				case CollectionEventKind.RESET:
					removeAllElements();
					_unitsUsed = 0;
					break;
				
				case CollectionEventKind.ADD:{					
					var data:IntervalData = IntervalData(dataProvider.getItemAt(dataProvider.length - 1, 0));
					var cell:ChartCell = new ChartCell();
					cell.data = data;
					
					var w:Number = width - paddingLeft - paddingRight;			
					cell.rect1.width = (data.value * w) / _noUnits;
					
					cell.addEventListener("selection", getSelectedItem);
					addElement(cell);
					_unitsUsed += data.value;
					break;
				}
			}			
		}
		
		public function updateUnitsNumber(event:Event):void{
			if(newNoUnits >= _unitsUsed){
				for (var i:int = 0; i < dataProvider.length; i++){
					var w:Number = width - paddingLeft - paddingRight;
					ChartCell(getElementAt(i)).rect1.width *= _noUnits / newNoUnits;
				}
				_noUnits = newNoUnits;
			}			
		}
		
		public function getSelectedItem(event:Event):void{
			if(selectedItem != null){
				IntervalData(selectedItem.data).color = 
								ColorUtil.adjustBrightness(IntervalData(selectedItem.data).color, 40);
			}
			selectedItem = ChartCell(event.target);
			IntervalData(selectedItem.data).color = 
								ColorUtil.adjustBrightness(IntervalData(selectedItem.data).color, -40);
			dispatchEvent(new Event("cellSelection"));
		}		
	}
}