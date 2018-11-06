package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	
	public DBUtil(){
		
	}
	
	// static final String connectionString = "jdbc:mariadb://malin:Ilgdatabas@192.168.1.83/requesthandling";
		static final String timezoneFix = "?useLegacyDatetimeCode=false&serverTimezone=Europe/Stockholm";
		static final String databaseName="requesthandling";
		static final String connectionString = "jdbc:mariadb://192.168.1.83:3306/requesthandling";
		String username = "yhAdmin";
		String password = "yhsipi17";

	//Declare driver
	//TODO private static final String...
	
	//Connection
    private static Connection conn = null;
    
    //Connection String
    //TODO String connStr = 
    
    private static final String connStr ="xxxx"; //TODO
    
  //Connect to DB
    public static void dbConnect() {
    	//TODO
    	//set driver
    	
    	//Establish connection using connection String
    	
		try {
	    	//set driver
	    	
	    	//Establish connection using connection String
	    	
			//Connection conn = DriverManager.getConnection("jdbc:mysql://username:password@ipadress");
			//Connection conn = DriverManager.getConnection("jdbc:mariadb://IP Adress:PORT/Databas", "user",  "password");
			
			Connection conn = DriverManager.getConnection("jdbc:mariadb://192.168.1.83:3306/requesthandling", "yhAdmin", "yhsipi17");
			
			
				System.out.println("Got a connection!");
				
			//	conn.close();
	    	} catch (SQLException e) {
				System.err.println("Error! Connection Failed! Check output console: " + e.getMessage());
			}
	
    }
    
    
  //Close Connection
    public static void dbDisconnect() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e){
        	System.err.println("An SQL exception occured when closing connection " + e.getMessage());
        }
    }
    
  //DB Execute Select Query Operation
    public static ResultSet dbExecuteQuery(String queryStmt) {
    	//TODO
    	return null;
    	
    }
    
  
    //TODO Check that this one works - currently does not
  //DB Execute Update (For Update/Insert/Delete) Operation
    public static void dbExecuteUpdate1(String sqlStmt) {
    	//Declare statement as null
        Statement stmt = null;
        try {
            //Connect to DB
            dbConnect();
            //Create Statement
            stmt = conn.createStatement();
            //Run executeUpdate operation with given sql statement
            stmt.executeUpdate(sqlStmt);
        } catch (SQLException e) {
            System.err.println("Problem occurred at executeUpdate operation : " + e.getMessage());
        } finally {
            if (stmt != null) {
                //Close statement
                try {
					stmt.close();
				} catch (SQLException eclose) {
					System.err.println("Problem occurred when closing statement: " + eclose.getMessage());
				}
            }
            //Close connection
            dbDisconnect();
        }
    }

 
}