package repository;

import model.Apartment;
import util.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ApartmentRepository implements IRepository<Apartment> {

    @Override
    public Apartment get(int id) {

        // get by id
        String query = "SELECT * FROM apartment WHERE apartment_id = " + id;

        // The resultset
        ResultSet rs = Database.executeQuery(query);

        // Status to return
        Apartment Apartment = new Apartment();

        try {

            // to move cursor to first row
            // TODO checking for null result
            rs.next();

            // Set members
            Apartment.setApartmentId(rs.getInt("apartment_id"));
            Apartment.setApartmentNo(rs.getInt("apartment_no"));
            Apartment.setHouseId(rs.getInt("house_id"));
            rs.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return Apartment;
    }

    @Override
    public ArrayList<Apartment> getAll() {

        // get by id
        //String query = "SELECT apartment_id, apartment_no, house_id from apartment INNER JOIN house WHERE apartment.house_id = house.house_id";
        String query = "SELECT * FROM apartment";
        // The resultset
        ResultSet rs = Database.executeQuery(query);

        // Status to return
        ArrayList<Apartment> apartment = new ArrayList<Apartment>();

        try {
            while(rs.next()) {
                // add Apartment to list
                apartment.add(new Apartment(rs.getInt("apartment_id"),rs.getInt("apartment_no"), rs.getInt("house_id")));
            }
            rs.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return apartment;
    }



    @Override
    public void update(Apartment t) {
        //TODO IF time
    }
    @Override
    public void add(Apartment t) {

        // Get connection
        Connection conn = Database.getConnection();

        // Setup query
        String query = "INSERT INTO apartment(apartment_no, house_id) VALUES(?, ?);";

        try {

            // Setup statment
            PreparedStatement stmt = conn.prepareStatement(query);

            // Set values
            stmt.setInt(1, t.getApartmentNo());
            stmt.setInt(2, t.getHouseId());

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
    public void remove(Apartment t) {

        String query = "DELETE FROM apartment WHERE apartment_id=" + t.getApartmentId();
        Database.executeUpdate(query);



    }

    public ArrayList<Apartment> getAllWithHouseNumber() {
        String query = "SELECT apartment.apartment_id, apartment.apartment_no, apartment.house_id, house.house_no FROM apartment INNER JOIN house WHERE apartment.house_id = house.house_id";
        ResultSet rs = Database.executeQuery(query);
        ArrayList<Apartment> apartment = new ArrayList<Apartment>();

        try{
            while(rs.next()) {
                apartment.add(new Apartment(rs.getInt("apartment_id"),rs.getInt("apartment_no"), rs.getInt("house_id"), rs.getString("house_no")));
            }
        }catch (SQLException sql) {
            System.out.println("Error in ApartmentRepo: " + sql);
        }
        ;
        return apartment;
    }

}