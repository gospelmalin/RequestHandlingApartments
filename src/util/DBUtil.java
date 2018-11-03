package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
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
    }
    
    
  //Close Connection
    public static void dbDisconnect() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e){
        	System.err.println("An SQL exception occured when closing connection " + e);
        }
    }
    
  //DB Execute Select Query Operation
    public static ResultSet dbExecuteQuery(String queryStmt) {
    	//TODO
    	return null;
    	
    }
    
  //DB Execute Update (For Update/Insert/Delete) Operation
    public static void dbExecuteUpdate(String sqlStmt) {
    	
    }
}