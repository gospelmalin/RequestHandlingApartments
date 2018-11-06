package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	
	private static final String DATABASE = "requesthandling";
	private static final String CONN_STR = "jdbc:mariadb://172.20.10.3:3306/" + DATABASE;
	private static final String USER = "yhAdmin";
	private static final String PWD = " yhsipi17";
	
	//Connection
    private static Connection conn = null;
    
    
    //Connect to DB
    private static void dbConnect() {
    
    	try {
			conn = DriverManager.getConnection( CONN_STR,USER,PWD);
		} catch (SQLException e) {
			System.err.println("An SQL exception occured when opening connection " + e);
			}
    }
    
    
  //Close Connection
    private static void dbClose() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e){
        	System.err.println("An SQL exception occured when closing connection " + e);
        }
    }
    
    //DB Execute Select Query Operation
    public static ResultSet executeQuery(String query) {
    	
    	// connect to db
    	dbConnect();

    	// statment for query
    	Statement stmt;
    	
    	// resultset for the result
    	ResultSet rs = null;
    	
    	// do querying
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			stmt.close();
			
		} catch (SQLException e) {
			System.err.println("An SQL exception occured when while executing query " + e);
		}
		
		// close db
		dbClose();
		
    	return rs;
    	
    }
    
    //DB Execute Update (For Update/Insert/Delete) Operation
    public static void executeUpdate(String query) {

    	// connect to db
    	dbConnect();

    	// do querying
    	// TODO Change to preparedstatment
		try {
			Statement stmt = conn.createStatement();
			stmt.executeQuery(query);
			stmt.close();
			
		} catch (SQLException e) {
			System.err.println("An SQL exception occured when while executing query " + e);
		}
		
		// close db
		dbClose();
		
    }
}