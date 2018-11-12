package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	
	private static final String DATABASE = "requesthandling";
	private static final String CONN_STR = "jdbc:mariadb://192.168.10.105:3306/" + DATABASE;
	private static final String USER = "jocke";
	private static final String PWD = "123123";
	
	//Connection
    private static Connection conn = null;
    
    
    //Connect to DB
    private static void dbConnect() {
    	try {
			conn = DriverManager.getConnection( CONN_STR,USER,PWD);
		} catch (SQLException e) {
			System.err.println("An SQL exception occured when opening connection " + e);
			}
    	System.out.println("Connected!");
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
        
        System.out.println("Connection closed!");
    }
   
	//DB Execute Select Query Operation
    public static ResultSet executeQuery(String query) {
    	
    	// connect to db
    	dbConnect();

    	// statement for query
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
    	// TODO Change to prepared statement. How?
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
    
    //How to do this?
    /*
    //DB Execute Update PreparedStatement (For Update/Insert/Delete) Operation
    public static void executeUpdatePreparedStatement(String query, ArrayList<Object> values) {

    	// connect to db
    	dbConnect();

    	// do querying
    	
		try {
			PreparedStatement prepStatement = conn.prepareStatement(query);
			//TODO read arraylist
			prepStatement.executeQuery();
			prepStatement.close();
			
		} catch (SQLException e) {
			System.err.println("An SQL exception occured when while executing query " + e);
		}
		
		// close db
		dbClose();
		
    }
    */

    public static Connection getConnection() {
    	dbConnect();
    	return conn;
    }

    public static void closeConnection() {
    	dbClose();
    }

}