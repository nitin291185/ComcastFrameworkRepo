package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class javaUtility {
	
	public int RandomNumber() {
		Random random=new Random();
		int random_number = random.nextInt(5000);
		return random_number;
	}
	
	public String DateYYYYMMDD() {
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(d);
		return date;
	}
	
	public String FutureDateAfter2Months() {
		Date d=new Date();
		
		SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
		sdf1.format(d);
		Calendar cal = sdf1.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, 60);
		String futuredate = sdf1.format(cal.getTime());
		
		return futuredate;
		
	}
}
