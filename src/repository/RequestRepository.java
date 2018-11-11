package repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Apartment;
import model.Person;
import model.Request;
import util.Database;

public class RequestRepository implements IRepository<Request> {
	
	@Override
	public Request get(int id) { //TODO check and test this 
	// get by id 
		String query = "SELECT r.request_id AS " + "'Request id', " + 
				"CONCAT(t.first_name," + "' '," + "t.last_name)"+ " AS "+ "'Reported by',"
				+ "r.request_date AS " + "'Date reported',"
				+ "h.house_address AS " + "'Address',"
				+ "h.house_no AS " + "'House number',"
				+ "a.apartment_no AS " + "'Apartment',"
				+ "d.district_name AS " + "'District',"
				+ "r.request_description AS " + "'Description',"
				+ "s.status_description AS " + "'Status',"
				+ "r.completion_date AS " + "'Date completed',"
				+ "CONCAT(e.first_name," + "' '," + "e.last_name) " + "'Completed by'"
		+ " FROM request r INNER JOIN person t"
		+ " ON t.person_id = r.requester_id"
		+ " INNER JOIN apartment a"
		+ " ON a.apartment_id=r.apartment_id"
		+ " INNER JOIN house h"
		+ " ON h.house_id = a.house_id"
		+ " INNER JOIN district d"
		+ " ON d.district_id=h.district_id"
		+ " INNER JOIN status s"
		+ " ON s.status_id=r.status_id"
		+ " LEFT OUTER JOIN person e"
		+ " ON e.person_id=r.resolver_id" 
		+ " WHERE request_id = " + id
		+ " ORDER BY r.request_id, r.apartment_id;"
		;		
		
		// The resultset
		ResultSet rs = Database.executeQuery(query);
		
		// Request to return
		Request request = new Request();
		
		try {
			
			// to move cursor to first row
			// TODO checking for null result
			rs.next();
			
			//Set request members
			request.setRequestId(rs.getInt("Request id"));
			request.setReportedBy(rs.getString("Reported by"));
			request.setRequestDate(rs.getDate("Date reported"));
			request.setAddress(rs.getString("Address"));
			request.setHouseNo(rs.getString("House number"));
			request.setApartmentNo(rs.getInt("Apartment"));
			request.setDistrict(rs.getString("District"));
			request.setDescription(rs.getString("Description"));
			request.setStatus(rs.getString("Status"));
			request.setCompletionDate(rs.getDate("Date completed"));
			request.setCompletedBy(rs.getString("Completed by"));
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return request;
	}
	
	
	@Override
	public ArrayList<Request> getAll() { //TODO test and check
		String query = "SELECT r.request_id AS " + "'Request id', " + 
				"CONCAT(t.first_name," + "' '," + "t.last_name)"+ " AS "+ "'Reported by',"
				+ "r.request_date AS " + "'Date reported',"
				+ "h.house_address AS " + "'Address',"
				+ "h.house_no AS " + "'House number',"
				+ "a.apartment_no AS " + "'Apartment',"
				+ "d.district_name AS " + "'District',"
				+ "r.request_description AS " + "'Description',"
				+ "s.status_description AS " + "'Status',"
				+ "r.completion_date AS " + "'Date completed',"
				+ "CONCAT(e.first_name," +"' '," + "e.last_name) " + "'Completed by'"
		+ " FROM request r INNER JOIN person t"
		+ " ON t.person_id = r.requester_id"
		+ " INNER JOIN apartment a"
		+ " ON a.apartment_id=r.apartment_id"
		+ " INNER JOIN house h"
		+ " ON h.house_id = a.house_id"
		+ " INNER JOIN district d"
		+ " ON d.district_id=h.district_id"
		+ " INNER JOIN status s"
		+ " ON s.status_id=r.status_id"
		+ " LEFT OUTER JOIN person e"
		+ " ON e.person_id=r.resolver_id" 
		+ " ORDER BY r.request_id, r.apartment_id;"
		;	
		
		// The resultset
		ResultSet rs = Database.executeQuery(query);
		
		// Status to return
		ArrayList<Request> requests = new ArrayList<Request>(); 
		
		try {
			
			while(rs.next()) {
				
				// add request to list
				requests.add(new Request(rs.getInt("Request id"),rs.getString("Reported by"),rs.getDate("Date reported"), 
						rs.getString("Address"), rs.getString("House number"),rs.getInt("Apartment"),rs.getString("District"), 
						rs.getString("Description"),rs.getString("Status"),
						 rs.getDate("Date completed"),rs.getString("Completed by")));		 
			}
			
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return requests;
	}
	
	@Override
	public void add(Request t) {
		// Prepare connection
		Connection conn = null;

		// Prepare query
		PersonRepository pr = new PersonRepository();
		
		String query ="INSERT INTO request(requester_id, apartment_id, "
				+ "request_description, request_date) VALUES(?, ?, ?, ?)";
		String fullname = t.getReportedBy();
		String houseNo = t.getHouseNo();
		int apartmentNo = t.getApartmentNo();
		Person person = new Person();
		System.out.println("Fullname: "+ fullname + " HouseNo: " + houseNo + " ApartmentNo: " + apartmentNo); //TODO temp
		person=	pr.getPersonByFullName(fullname, houseNo, apartmentNo);
		
		Apartment ap = person.getCurrentApartment();
		int personIdFromPerson = person.getPersonId();
		int apartmentIdFromPerson = ap.getApartmentId();
		String descriptionFromPerson = t.getDescription();
		Date requestDateFromPerson = t.getRequestDate();
		System.out.println("personIdFromPerson: " + personIdFromPerson + 
				" apartmentIdFromPerson: " + apartmentIdFromPerson + 
				" descriptionFromPerson: "+ descriptionFromPerson); //TODO temp
		
		try {
			// get connection
			conn = Database.getConnection();
			// query database
			PreparedStatement prepStatement = conn.prepareStatement(query);
			//TODO read arraylist
			prepStatement.setInt(1, personIdFromPerson);
			prepStatement.setInt(2, apartmentIdFromPerson);
			prepStatement.setString(3, descriptionFromPerson);
			//prepStatement.setDate(4, requestDateFromPerson) ; //TODO use this
			prepStatement.setDate(4, getCurrentDate()); //TODO TEMP for testing
			int rows = prepStatement.executeUpdate();
			System.out.println("INSERT INTO request(requester_id, apartment_id, "
					+ "request_description, request_date) VALUES(" + person.getPersonId() +","+ ap.getApartmentId()+","+ t.getDescription()+","+ "2018-11-09"+");");//TODO temp
			prepStatement.close();
			//System.out.println("Your request is submitted and will be handled.");
			System.out.println("Inserted " + rows + " row(s)");
		} catch (SQLException e1) {
			System.err.println("An SQL exception occured when while executing query: " + e1.getMessage());
		} catch (NullPointerException e) {
			System.err.println("A null pointer exception occured " + e.getMessage());
		}
		// close connection
		//TODO - how??
	}



	@Override
	public void remove(Request t) { //TODO test this method
		String query = "DELETE FROM request WHERE id=" + t.getRequestId();
		Database.executeUpdate(query);
		
	}

	
	//method to return current date, and convert it java.sql.Date
		private static java.sql.Date getCurrentDate() {
		    java.util.Date today = new java.util.Date();
		    return new java.sql.Date(today.getTime());
		}


		@Override
		public void update(Request t) {
			// TODO Auto-generated method stub
			
		}

	
}
