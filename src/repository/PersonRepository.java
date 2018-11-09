package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Apartment;
import model.Person;
import util.Database;

public class PersonRepository implements IRepository<Person>{

	@Override
	public Person get(int id) { //TODO update to include role, apartment, requests...
		
		// get by id 
		String query = "SELECT * FROM person WHERE person_id = " + id; 
		
		//select person.*, role.* person_role.*
		
		// The resultset
		ResultSet rs = Database.executeQuery(query);
		
		// Person to return
		Person person = new Person();
		
		try {
			
			// to move cursor to first row
			// TODO checking for null result
			rs.next();
			
			// Set person members
			person.setPersonId(rs.getInt("person_id"));
			person.setFirstName(rs.getString("first_name"));
			person.setLastName(rs.getString("last_name"));
			person.setFullName(rs.getString("first_name"), rs.getString("last_name"));
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return person;
	}

	@Override
	public ArrayList<Person> getAll() {
		
		// get by id 
		String query = "SELECT * FROM person";
		
		// The resultset
		ResultSet rs = Database.executeQuery(query);
		
		// Status to return
		ArrayList<Person> persons = new ArrayList<Person>(); 
		
		try {
			
			while(rs.next()) {
				
				// add person to list
				persons.add(new Person(rs.getInt("person_id"),rs.getString("first_name"), rs.getString("last_name"), (rs.getString("first_name")+ " "+ rs.getString("last_name"))));
				
			}
			
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return persons;
	}

	@Override
	public void add(Person t) {
		
		String query = "INSERT INTO person(first_name, last_name) VALUES('" + t.getFirstName() + "', '" + t.getLastName() + "');";
		Database.executeUpdate(query);
		
	}

	@Override
	public void update(Person t) {
		
		String query = "UPDATE person SET first_name = '"+ t.getFirstName() +"', last_name = '"+ t.getLastName() +"' WHERE person_id="+ t.getPersonId(); 
		Database.executeUpdate(query);
	}

	@Override
	public void remove(Person t) {
		
		String query = "DELETE FROM person WHERE person_id=" + t.getPersonId();
		Database.executeUpdate(query);
		
	}

	//TODO 
	public Person getPersonByFullName(String fullname, String houseNo, int apartmentNo) {
		String query ="SELECT p.person_id AS " + "'Person id', "
				+ "CONCAT(p.first_name, " +"' '" + ", p.last_name)" + " AS " + "'Full name',"
				+ "p.first_name" + " AS " + "'First name',"
				+ " p.last_name" + " AS " + "'Last name',"
				+ "a.apartment_id" + " AS " + "'Apartment id',"
				+ "h.house_address" + " AS " + "'Address',"
				+ "h.house_no" + " AS " + "'House number',"
				+ "a.apartment_no" + " AS " + "'Apartment'," 
				+ " h.house_id" + " AS " + "'House id'"
				+ "	FROM person p inner join person_apartment pa" 
				+ "	ON pa.person_id=p.person_id" 
				+ "	INNER JOIN apartment a" 
				+ "	ON a.apartment_id = pa.apartment_id"
				+ "	INNER JOIN house h"
				+ "	ON h.house_id = a.house_id" 
				+ "	WHERE CONCAT(p.first_name," +  "' '" + ", p.last_name)= " + fullname
				+ "	AND h.house_no = " + houseNo
				+ " AND a.apartment_no= " + apartmentNo
				+ "	; ";
		
		// The resultset
			ResultSet rs = Database.executeQuery(query);
				
		// Person to return
		Person person = new Person();
		
		try {
			
			// to move cursor to first row
			// TODO checking for null result
			rs.next();
			
			// Set person members
			person.setPersonId(rs.getInt("Person id"));
			person.setFirstName(rs.getString("First name"));
			person.setLastName(rs.getString("Last name"));
			person.setFullName(rs.getString("Full name"));
			person.setFullName(rs.getString("Full name"));
			
			Apartment currentApartment = new Apartment((rs.getInt("Apartment id")), (rs.getInt("Apartment")),(rs.getInt("House id")) );
			person.setCurrentApartment(currentApartment);

			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return person;
	}


}

