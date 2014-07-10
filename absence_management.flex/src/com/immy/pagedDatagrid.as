/*
Copyright (c) 2010 http://www.immanuelnoel.com

Permission is hereby granted, free of charge, to any person obtaining a copy of
this software and associated documentation files (the "Software"), to deal in
the Software without restriction, including without limitation the rights to
use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
of the Software, and to permit persons to whom the Software is furnished to do
so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/

package com.immy
{
	import flash.display.Sprite;
	import flash.events.MouseEvent;
	
	import mx.collections.ArrayCollection;
	import mx.containers.HBox;
	import mx.controls.DataGrid;
	import mx.controls.Label;
	import mx.controls.LinkButton;
	import mx.controls.Spacer;
	import mx.core.EventPriority;
	import mx.events.CollectionEvent;
	import mx.events.ListEvent;
	
	/**
	 * <code>Paginated Datagrid</code>.
	 *
	 * <p>This component extends dataGrid, displaying only a set of records at a time, 
	 * thereby organizing the entire collection into ‘pages’
	 * </p>
	 */
	
	/*[DefaultProperty("pagination")]
	[DefaultProperty("limit")]
	[DefaultProperty("dataProvider")]*/
	
	public class pagedDatagrid extends DataGrid
	{
		private var hb:HBox = new HBox;
		private var lb:Label = new Label;
		private var llb1:LinkButton = new LinkButton;
		private var llb2:LinkButton = new LinkButton;
		
		// Exposed Properties
		/**
		 * Indicates whether pagination is required. false allows the datagrid to function as the default datagrid.
		 */
		public var pagination:Boolean = true;
		
		/**
		 * Number of records displayed on each page.
		 */
		public var limit:Number = 100;
		// End Exposed Properties
		
		[Bindable]
		/**
		 * The <code>arrayCollection</code> provided as the actual <code>dataProvider</code> to the <code>dataGrid</code> after pagination.
		 */
		private var pDataProvider:Object;
		
		/**
		 * Currently selected <code>Page</code>.
		 */
		private var currentIndex:Number = 0;
		
		/**
		 * Specifies the minimum bounds for the currently selected page
		 */
		private var minBound:Number;
		
		/**
		 * Specifies the maximum bounds for the currently selected page
		 */
		private var maxBound:Number;
			
			
		/**
		 * Constructor
		 */
		public function pagedDatagrid()
		{
			super();
		}
		
		/**
		 * Returns the currently <code>selectedIndex</code> with respect to the provided <code>dataProvider</code>
		 */
		public function itemSelected(event:ListEvent):Number
		{
			return event.rowIndex + minBound;
		}
		
		private function listChange(event:CollectionEvent = null):void
	    {
	    	currentIndex = 0;
	    	filter();
	    }
		
		/**
		 * Method to update data displayed
		 */
		private function filter():void
		{
			minBound = (currentIndex * limit);
			maxBound = minBound + limit;
			
			var arr:ArrayCollection = new ArrayCollection;
			
			for(var i:Number = 0; i < pDataProvider.length; i++)
			{
				if(minBound <= i && i < maxBound)
				{
					arr.addItem(pDataProvider[i]);
				}
			}
		
			arr.refresh();
			super.dataProvider = arr;
			
			lb.text = "Showing " + (pDataProvider.length > 0 ? (minBound + 1) + " to " : "") + (pDataProvider.length < maxBound ? pDataProvider.length : maxBound) + " of " + pDataProvider.length;
		
			if(pDataProvider.length > maxBound)
				llb2.enabled = true;
			else
				llb2.enabled = false;
				
			if(0 < minBound)
				llb1.enabled = true;
			else
				llb1.enabled = false;
		}
		
		/**
		 * Navigate to previous page
		 */
		private function prevPage(event:MouseEvent):void
		{
			if(currentIndex > 0)
			{
				currentIndex--;
		    	if(pDataProvider.length > 0)
		    		filter();
	  		}
		}
		
		/**
		 * Navigate to next page
		 */
		private function nextPage(event:MouseEvent):void
		{
			if(currentIndex < (pDataProvider.length / limit) - 1)
			{
				currentIndex++;
		    	if(pDataProvider.length > 0)
		    		filter();
		 	}
		}
	     
		/**
		 * Replicate data to a temporary arrayCollection on which pagination is performed
		 */
	    override public function set dataProvider(value:Object):void
	    {
	    	if(pagination)
	    	{
		        pDataProvider = value;
		        listChange();
	    	}
	    	else
	    	{
	    		super.dataProvider(value);
	    	}
	    }
	     
		/**
		 * Create navigation controls
		 */
	    override protected function createChildren():void
	    {
	        super.createChildren();
			
			if(pagination)
			{
		        hb = new HBox;
				hb.percentWidth=100;
				hb.height=35;
				hb.setStyle("backgroundColor","#ECE9E9");
				hb.setStyle("borderStyle","solid");
				hb.setStyle("horizontalAlign","center");
				hb.setStyle("verticalAlign","middle");
			
				var spc:Spacer = new Spacer;
				spc.width = 10;
				hb.addChild(spc);
				
				lb = new Label;
				lb.id = "lInfo";
				lb.text = "Loading Data...";
				hb.addChild(lb);
				
				var spc3:Spacer = new Spacer;
				spc3.percentWidth = 100;
				hb.addChild(spc3);
				
				llb1 = new LinkButton;
				llb1.id = "btPrev";
				llb1.label = "Prev";
				llb1.addEventListener(MouseEvent.CLICK, prevPage);
				hb.addChild(llb1);
				
				llb2 = new LinkButton;
				llb2.id = "btNext";
				llb2.label = "Next";
				llb2.addEventListener(MouseEvent.CLICK, nextPage);
				hb.addChild(llb2);
	
				var spc2:Spacer = new Spacer;
				spc2.width = 10;
				hb.addChild(spc2);
				
				this.addChild(hb);
		    }
		}
	    
		/**
		 * Move navigation controls to the bottom of the dataGrid.
		 */
	    override protected function adjustListContent(unscaledWidth:Number = -1, unscaledHeight:Number = -1):void
	    {
			super.adjustListContent(unscaledWidth, unscaledHeight);
	
			if(pagination)
			{
				listContent.setActualSize(listContent.width, listContent.height - 35);
				hb.setActualSize(listContent.width, 35);
				hb.move(listContent.x, listContent.y + listContent.height + 1);
			}
	    }
	
		override public function invalidateDisplayList():void
		{
			super.invalidateDisplayList();
			
			if (hb && pagination)
				hb.invalidateDisplayList();
		}
		
		
	}
}