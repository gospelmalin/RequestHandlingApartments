package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Area;
import util.Database;

public class AreaRepository implements IRepository<Area> {

	@Override
	public Area get(int id) {
		
		// get by id 
		String query = "SELECT * FROM area WHERE area_id = " + id;
		
		// The resultset
		ResultSet rs = Database.executeQuery(query);
		
		// Status to return
		Area area = new Area();
		
		try {
			
			// to move cursor to first row
			// TODO checking for null result
			rs.next();
			
			// Set area memebers
			area.setId(rs.getInt("area_id"));
			area.setName(rs.getString("area_name"));
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return area;
	}

	@Override
	public ArrayList<Area> getAll() {
		
		// get by id 
		String query = "SELECT * FROM area";
		
		// The resultset
		ResultSet rs = Database.executeQuery(query);
		
		// Status to return
		ArrayList<Area> areas = new ArrayList<Area>(); 
		
		try {
			
			while(rs.next()) {
				
				// add area to list
				areas.add(new Area(rs.getInt("area_id"),rs.getString("area_name")));
				
			}
			
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return areas;
	}

	@Override
	public void add(Area t) {
		
		String query = "INSERT INTO area(area_name) VALUES('" + t.getName() + "');";
		Database.executeUpdate(query);
		
	}

	@Override
	public void update(Area t) {
		
		String query = "UPDATE area SET area_name = '"+ t.getName() +"' WHERE area_id="+ t.getId(); 
		Database.executeUpdate(query);
	}

	@Override
	public void remove(Area t) {
		
		String query = "DELETE FROM area WHERE id=" + t.getId();
		Database.executeUpdate(query);
		
	}

}