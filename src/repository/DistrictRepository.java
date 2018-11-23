package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.District;
import util.Database;

public class DistrictRepository implements IRepository<District> {

	@Override
	public District get(int id) {
		
		// The statment to execute
		Statement stmt;
		
		// To hold the result from the query
		ResultSet rs;
		
		// Get connection
		Connection conn = Database.getConnection();
		
		// setup query 
		String query = "SELECT * FROM district WHERE district_id = " + id;
				
		// Status to return
		District district = new District();
		
		try {
			// Create statment
			stmt = conn.createStatement();
			
			// Execute and get the result in a resultset
			rs = stmt.executeQuery(query);
			
			// close statment & connection
			stmt.close();	
			Database.closeConnection();
					
			// Check that the results not empty
			if (!rs.next()) throw new SQLException("No result from query");
			
			// Set district members
			district.setId(rs.getInt("district_id"));
			district.setName(rs.getString("district_name"));
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return district;
	}

	@Override
	public ArrayList<District> getAll() {
		
		// The statment to execute
		Statement stmt;
		
		// To hold the result from query
		ResultSet rs;
		
		// Get connection
		Connection conn = Database.getConnection();
				
		// setup query 
		String query = "SELECT * FROM district";
		
		// districts to return
		ArrayList<District> districts = new ArrayList<District>(); 
		
		try {
		
			// Create statment
			stmt = conn.createStatement();
			
			// Execute and get the result in a resultset
			rs = stmt.executeQuery(query);
			
			// close statment & connection
			stmt.close();	
			Database.closeConnection();
			
			// Loop through the resultset and add the row to a list
			while(rs.next()) {
				
				// add district to list
				districts.add(new District(rs.getInt("district_id"),rs.getString("district_name")));
			}
			
			// close resultset
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return districts;
	}

	@Override
	public void add(District t) {
		
		// Get connection
		Connection conn = Database.getConnection();
		
		// Setup query
		String query = "INSERT INTO district(district_name) VALUES(?);";
		
		try {
			
			// Setup statment
			PreparedStatement stmt = conn.prepareStatement(query);
			
			// Set values
			stmt.setString(1, t.getName());
			
			// Execute statment
			stmt.executeUpdate();
			
			// Statment & conn
			stmt.close();
			Database.closeConnection();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(District t) {
		
		String query = "UPDATE district SET district_name = '"+ t.getName() +"' WHERE district_id="+ t.getId(); 
		Database.executeUpdate(query);
	}

	@Override
	public void remove(District t) {
		
		String query = "DELETE FROM district WHERE district_id=" + t.getId();
		Database.executeUpdate(query);
		
	}

}