package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Request;
import util.Database;

public class RequestRepository implements IRepository<Request> {

	@Override
	public Request get(int id) { //TODO check and test this 
	// get by id 
		String query = "SELECT r.request_id AS " + "'Request id', " + 
				"(t.first_name + ' ' + t.last_name)"+ " AS "+ "'Reported by',"
				+ "r.request_date AS " + "'Date reported',"
				+ "a.apartment_no AS " + "'Apartment',"
				+ "area.area_name AS " + "'Address',"
				+ "h.house_no AS " + "'House number',"
				+ "r.request_description AS " + "'Description',"
				+ "s.status_description AS " + "'Status',"
				+ "r.completion_date AS " + "'Date completed',"
				+ "(e.first_name +' ' + e.last_name) " + "'Completed by'"
		+ " FROM request r INNER JOIN person_request tr"
		+ " ON r.request_id=tr.request_id"
		+ " INNER JOIN person t" 
		+ " ON t.person_id = tr.person_id"
		+ " INNER JOIN apartment a"
		+ " ON a.apartment_id=r.apartment_id"
		+ " INNER JOIN house h"
		+ " ON h.house_id = a.house_id"
		+ " INNER JOIN area area"
		+ " ON area.area_id=h.area_id"
		+ " INNER JOIN status s"
		+ " ON s.status_id=r.status_id"
		+ " LEFT OUTER JOIN person_request er"
		+ " ON r.request_id = er.request_id"
		+ " LEFT OUTER JOIN person e"
		+ " ON e.person_id=er.person_id"
		+ " WHERE request_id = " + id
		+ " ORDER BY r.request_id, r.apartment_id;"
		;
		
		
		// The resultset
		ResultSet rs = Database.executeQuery(query);
		
		// Status to return
		Request request = new Request();
		
		try {
			
			// to move cursor to first row
			// TODO checking for null result
			rs.next();
			
			//Set request members
			request.setRequestId(rs.getInt("Request id"));
			request.setReportedBy(rs.getString("Reported by"));
			request.setApartmentNo(rs.getInt("Apartment"));
			request.setAddress(rs.getString("Address"));
			request.setHouseNo(rs.getString("House number"));
			request.setDescription(rs.getString("Description"));
			request.setStatus(rs.getString("Status"));
			request.setRequestDate(rs.getDate("Date reported"));
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
				"(t.first_name + ' ' + t.last_name)"+ " AS "+ "'Reported by',"
				+ "r.request_date AS " + "'Date reported',"
				+ "a.apartment_no AS " + "'Apartment',"
				+ "area.area_name AS " + "'Address',"
				+ "h.house_no AS " + "'House number',"
				+ "r.request_description AS " + "'Description',"
				+ "s.status_description AS " + "'Status',"
				+ "r.completion_date AS " + "'Date completed',"
				+ "(e.first_name +' ' + e.last_name) " + "'Completed by'"
		+ " FROM request r INNER JOIN person_request tr"
		+ " ON r.request_id=tr.request_id"
		+ " INNER JOIN person t" 
		+ " ON t.person_id = tr.person_id"
		+ " INNER JOIN apartment a"
		+ " ON a.apartment_id=r.apartment_id"
		+ " INNER JOIN house h"
		+ " ON h.house_id = a.house_id"
		+ " INNER JOIN area area"
		+ " ON area.area_id=h.area_id"
		+ " INNER JOIN status s"
		+ " ON s.status_id=r.status_id"
		+ " LEFT OUTER JOIN person_request er"
		+ " ON r.request_id = er.request_id"
		+ " LEFT OUTER JOIN person e"
		+ " ON e.person_id=er.person_id"
		+ " ORDER BY r.request_id, r.apartment_id;"
		;
		
		// The resultset
		ResultSet rs = Database.executeQuery(query);
		
		// Status to return
		ArrayList<Request> requests = new ArrayList<Request>(); 
		
		try {
			
			while(rs.next()) {
				
				// add area to list
				requests.add(new Request(rs.getInt("Request id"),rs.getString("Reported by"),rs.getInt("Apartment"), 
						rs.getString("Address"), rs.getString("House number"),rs.getString("Description"),rs.getString("Status"),
						rs.getDate("Date reported"), rs.getDate("Date completed"),rs.getString("Completed by")));		 
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Request t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Request t) { //TODO test method
		String query = "DELETE FROM request WHERE id=" + t.getRequestId();
		Database.executeUpdate(query);
		
	}

}
