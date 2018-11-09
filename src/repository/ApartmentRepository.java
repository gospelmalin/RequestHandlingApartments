package repository;

import model.Apartment;
import util.Database;
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
        String query = "SELECT * FROM apartment";

        // The resultset
        ResultSet rs = Database.executeQuery(query);

        // Status to return
        ArrayList<Apartment> apartment = new ArrayList<Apartment>();

        try {
            while(rs.next()) {
                // add Apartment to list
                apartment.add(new Apartment(rs.getInt("apartment_id"),rs.getInt("apartment_id")));
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

        //TODO IF time

    }


    @Override
    public void remove(Apartment t) {

       //TODO IF time

    }

}