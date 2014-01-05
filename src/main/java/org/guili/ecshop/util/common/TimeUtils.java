package org.guili.ecshop.util.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {
	/**
	04    * 毫秒转日期字符串
	05    * 
	06    * @param str
	07    * @return
	08    */
	  public static String getDateTimeByMillisecond(String str) {
	 
	     Date date = new Date(Long.valueOf(str));
	
	     SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	 
	     String time = format.format(date);
	
	     return time;
   }
}
