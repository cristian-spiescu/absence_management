package com.crispico.chart
{
	import flash.events.Event;
	import flash.events.MouseEvent;
	
	import mx.graphics.SolidColor;
	
	import spark.components.Group;
	import spark.primitives.Rect;
	
	[Event(name="click",type="flash.events.Event")]
	
	public class IntervalData extends Group
	{
		private var _color:uint;
		private var _value:Number;
		private var myInterval:Rect;
		private var colorChanged:Boolean;
		private var colorObject:SolidColor;
		
//		[Bindable]
//		public var callerComp:CharRenderer;
		
		public function IntervalData() {
			super();
//			Alert.show("in constructor");
			
		}
		
		override protected function createChildren():void {
			super.createChildren();
			
			if (!myInterval) {
				myInterval = new Rect();
				colorObject = new SolidColor();
				colorObject.color = color;
				myInterval.fill = colorObject;
//				Alert.show("mai am putin");
				myInterval.width = Math.round(parentDocument.pixeliPerUnitate*value); //total va fi lungimea containerului in pixeli
				myInterval.height = 20;
				this.width = myInterval.width;
//				Alert.show(myInterval.width+"");
				myInterval.addEventListener(MouseEvent.MOUSE_DOWN,handleClickEvent);
				this.addElement(myInterval);
			}
		}
		
		public function handleClickEvent(event:MouseEvent):void {
//			this.color = 0xCFCFCF;
			colorChanged = true;
			invalidateProperties();
			parentDocument.parentDocument.selectedInterval = this; //selectedInterval e un ob de tip IntervalData din container
		}
		
		public function set color(i:uint):void {
			_color = i;
		}
		
		public function get color():uint {
			return _color;
		}
		
		public function set value(i:Number):void {
			_value = i;
		}
		
		public function get value():Number {
			return _value;
		}
		
		override protected function commitProperties():void { 
			super.commitProperties(); 
			
			if (colorChanged) {
				color = 0xCFCFCF;
				colorChanged = false;
				colorObject.color =  color;
				myInterval.fill = colorObject;
				invalidateDisplayList();
			}
		}
		
		override protected function measure():void {
			super.measure();
			measuredWidth = measuredMinWidth = myInterval.measuredWidth ;
			
			measuredHeight = measuredMinHeight = myInterval.measuredHeight;
		}
		
		override protected function updateDisplayList(unscaledWidth:Number, unscaledHeight:Number):void {
			super.updateDisplayList(unscaledWidth, unscaledHeight);         
			
			var usableWidth:Number = unscaledWidth - 1;
			
			var usableHeight:Number = unscaledHeight - 1;
//			myInterval.setActualSize(usableWidth, usableHeight);
		}
			
	}
}