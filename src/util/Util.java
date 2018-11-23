package util;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Util {
	
	public Util() {}
	
	//method to return current date, and convert it java.sql.Date
		public static java.sql.Date getCurrentDate() {
		    java.util.Date today = new java.util.Date();
		    return new java.sql.Date(today.getTime());
		}
		
		//method to get date from text
		public java.util.Date stringToDate(String dateAsString) {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		//Date date = simpleDateFormat.parse("2018-09-09");
		java.util.Date date = null;
		try {
			date = simpleDateFormat.parse(dateAsString);
		} catch (ParseException e) {
			System.out.println("A Parse exception occured in stringToDate method: " + e.getMessage());
		}
		return date;
		}
		
		//method to get text from date
		public String dateToString(java.util.Date date) {
			date = new java.util.Date();
			//method to get date from text
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			 
	        //to convert Date to String, use formatting method of SimpleDateFormat.
	        String strDate = dateFormat.format(date);
	        return strDate;
		}
		
} 
