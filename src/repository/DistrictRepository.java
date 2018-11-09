package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.District;
import util.Database;

public class DistrictRepository implements IRepository<District> {

	@Override
	public District get(int id) {
		
		// get by id 
		String query = "SELECT * FROM district WHERE district_id = " + id;
		
		// The resultset
		ResultSet rs = Database.executeQuery(query);
		
		// Status to return
		District district = new District();
		
		try {
			
			// to move cursor to first row
			// TODO checking for null result
			rs.next();
			
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
		
		// get by id 
		String query = "SELECT * FROM district";
		
		// The resultset
		ResultSet rs = Database.executeQuery(query);
		
		// Status to return
		ArrayList<District> districts = new ArrayList<District>(); 
		
		try {
			
			while(rs.next()) {
				
				// add district to list
				districts.add(new District(rs.getInt("district_id"),rs.getString("district_name")));
				
			}
			
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return districts;
	}

	@Override
	public void add(District t) {
		
		String query = "INSERT INTO district(district_name) VALUES('" + t.getName() + "');";
		Database.executeUpdate(query);
		
	}

	@Override
	public void update(District t) {
		
		String query = "UPDATE district SET district_name = '"+ t.getName() +"' WHERE district_id="+ t.getId(); 
		Database.executeUpdate(query);
	}

	@Override
	public void remove(District t) {
		
		String query = "DELETE FROM district WHERE id=" + t.getId();
		Database.executeUpdate(query);
		
	}

}