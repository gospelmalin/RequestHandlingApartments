package util;

public class Util {
	
	public Util() {}
	
	//method to return current date, and convert it java.sql.Date
		public static java.sql.Date getCurrentDate() {
		    java.util.Date today = new java.util.Date();
		    return new java.sql.Date(today.getTime());
		}
}
