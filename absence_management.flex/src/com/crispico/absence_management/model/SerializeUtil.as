package com.crispico.absence_management.model
{
	import flash.utils.ByteArray;

	public class SerializeUtil
	{
		public static function ObjectToString(object: *): String
		{
			var ba: ByteArray = new ByteArray();
			ba.writeObject(object);
			return ba.toString();
		}
		public static function ObjectToByteArray(object: *): ByteArray
		{
			var ba: ByteArray = new ByteArray();
			ba.writeObject(object);
			ba.position = 0;
			return ba;
		}
	}
}