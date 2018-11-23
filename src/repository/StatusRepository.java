package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.Status;
import util.Database;

public class StatusRepository {

	public Status getStatus(int id) {

		
		// get by id 
		String query = "SELECT * FROM status WHERE status_id = " + id;
		
		// The resultset
		ResultSet rs = Database.executeQuery(query);
		
		// Status to return
		Status status = new Status();
		
		try {
			
			// to move cursor to firts row
			// TODO checking for null result
			rs.next();
			
			// Set status memebers
			status.setId(rs.getInt("status_id"));
			status.setStatus(rs.getString("status_description"));
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return status;
	}
	
	public void addStatus(String description) {
		
		String query = "INSERT INTO status(status_description) VALUES('" + description + "');";
		Database.executeUpdate(query);
		
	}
	
}
