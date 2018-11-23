package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Apartment;
import model.House;
import util.Database;

public class HouseRepository implements IRepository<House>{

	@Override
	public House get(int id) {
		// get by id
        String query = "SELECT * FROM house WHERE house_id = " + id;

        // The resultset
        ResultSet rs = Database.executeQuery(query);

        // Status to return
        House house = new House();

        try {

            // to move cursor to first row
            // TODO checking for null result
            rs.next();

            // Set members
            house.setHouseId(rs.getInt("house_id"));
            house.setHouseNo(rs.getString("house_no"));
            house.setDistrictId(rs.getInt("district_id"));
            house.setHouseAddress(rs.getString("house_address"));
          
            rs.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return house;
	}

	@Override
	public ArrayList<House> getAll() { //TODO check and test
		 // get by id
        String query = "SELECT * FROM house";

        // The resultset
        ResultSet rs = Database.executeQuery(query);

        // Status to return
        ArrayList<House> houses = new ArrayList<House>();

        try {
            while(rs.next()) {
                // add House to list
                houses.add(new House(rs.getInt("house_id"),rs.getString("house_no"), rs.getInt("district_id"), rs.getString("house_address")));
            	//houses.add(new House(rs.getInt("house_id"),rs.getString("house_no"), rs.getString("house_address")));
            }
            rs.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



        if(houses.isEmpty()) {
            System.out.println("Empty! I most likely did not get any data");
        }
        System.out.println(" Houses " + houses.toString());
        return houses;
 
	}

	@Override
	public void add(House t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(House t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(House t) {
		// TODO Auto-generated method stub
		
	}

}
