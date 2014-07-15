package com.crispico.chart
{
	import flash.events.Event;
	import flash.events.MouseEvent;
	
	import mx.controls.Alert;
	import mx.controls.ToolTip;
	import mx.graphics.SolidColor;
	import mx.managers.ToolTipManager;
	
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
		private var _selected:Boolean;
		private var valueChanged:Boolean;
		public var info:String;
		public var idul:Number;
		private var tips:ToolTip;
		
		//		[Bindable]
		//		public var callerComp:CharRenderer;
		
		public function IntervalData() {
			super();
			this.addEventListener(MouseEvent.MOUSE_DOWN,handleClickEvent);
			this.addEventListener(MouseEvent.MOUSE_OVER,handleHoverEvent);
			this.addEventListener(MouseEvent.MOUSE_OUT,handleDeHoverEvent);
			
			//			Alert.show("in constructor");
			selected = false;
		}
		
		override protected function createChildren():void {
			super.createChildren();
			
			if (!myInterval) {
				myInterval = new Rect();
				colorObject = new SolidColor();
				colorObject.color = color;
				myInterval.fill = colorObject;
				myInterval.width = makeWidth(); //total va fi lungimea containerului in pixeli
				myInterval.height = 20;
				this.width = myInterval.width;
				this.addElement(myInterval);
			}
		}
		
		public function handleClickEvent(event:MouseEvent):void {
			//			this.color = 0xCFCFCF;
			//			Alert.show("click!");
			colorChanged = true;
			selected = true;
			invalidateProperties();
			parentDocument.changedInterval = true;
			parentDocument.invalidateProperties();
			parentDocument.selectedInterval = this; //selectedInterval e un ob de tip IntervalData din container
			//			Alert.show("in clasa de jos");
		}
		
		public function handleHoverEvent(event:MouseEvent):void {
			tips = ToolTip(ToolTipManager.createToolTip("Colour: " + color.toString() + "\n Value: " + value ,10,20));
			this.addElement(tips);
		}
		public function handleDeHoverEvent(event:MouseEvent):void {
			if (tips!=null) {
				this.removeElement(tips);	
			}
			
		}
		
		public function makeWidth():uint {
			return Math.round(parentDocument.pixeliPerUnitate*value);
		}
		
		public function set color(i:uint):void {
			_color = i;
		}
		
		public function get color():uint {
			return _color;
		}
		
		public function set value(i:Number):void {
			_value = i;
			valueChanged = true;
			invalidateProperties();
		}
		
		public function get value():Number {
			return _value;
		}
		
		public function set selected(b:Boolean):void {
			_selected = b;
			invalidateProperties();
		}
		
		public function get selected():Boolean {
			return _selected ;
		}
		
		override protected function commitProperties():void { 
			super.commitProperties(); 
			
			if (colorChanged) {
				colorChanged = false;
				colorObject.color = 0xCFCFCF;
				for each(var i:IntervalData in parentDocument.intervale) {
					if (i.selected && i!=this) {
						i.selected=false;
					}
				}
				
				myInterval.fill = colorObject;
				invalidateDisplayList();
			}
			if(!selected) {
				colorObject.color = color;
				myInterval.fill = colorObject;
				invalidateDisplayList();
			}
			if(valueChanged) {
				myInterval.width = makeWidth();
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
		}
		
	}
}

