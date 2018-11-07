package model;

import java.sql.Date;

public class Request {
//TODO
	
	private int requestId;
	private int requesterId;
	private int apartmentId;
	private String requestDescription;
	private Date requestDate; //TODO typ?
	private int statusId;
	private Date completionDate;
	private int solverId;
	
	public Request() {}

	public Request(int requestId, int requesterId, int apartmentId, String requestDescription, Date requestDate,
			int statusId, Date completionDate, int solverId) {
		this.requestId = requestId;
		this.requesterId = requesterId;
		this.apartmentId = apartmentId;
		this.requestDescription = requestDescription;
		this.requestDate = requestDate;
		this.statusId = statusId;
		this.completionDate = completionDate;
		this.solverId = solverId;
	}

	/**
	 * @return the requestId
	 */
	public int getRequestId() {
		return requestId;
	}

	/**
	 * @param requestId the requestId to set
	 */
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	/**
	 * @return the requesterId
	 */
	public int getRequesterId() {
		return requesterId;
	}

	/**
	 * @param requesterId the requesterId to set
	 */
	public void setRequesterId(int requesterId) {
		this.requesterId = requesterId;
	}

	/**
	 * @return the apartmentId
	 */
	public int getApartmentId() {
		return apartmentId;
	}

	/**
	 * @param apartmentId the apartmentId to set
	 */
	public void setApartmentId(int apartmentId) {
		this.apartmentId = apartmentId;
	}

	/**
	 * @return the requestDescription
	 */
	public String getRequestDescription() {
		return requestDescription;
	}

	/**
	 * @param requestDescription the requestDescription to set
	 */
	public void setRequestDescription(String requestDescription) {
		this.requestDescription = requestDescription;
	}

	/**
	 * @return the requestDate
	 */
	public Date getRequestDate() {
		return requestDate;
	}

	/**
	 * @param requestDate the requestDate to set
	 */
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	/**
	 * @return the statusId
	 */
	public int getStatusId() {
		return statusId;
	}

	/**
	 * @param statusId the statusId to set
	 */
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	/**
	 * @return the completionDate
	 */
	public Date getCompletionDate() {
		return completionDate;
	}

	/**
	 * @param completionDate the completionDate to set
	 */
	public void setCompletionDate(Date completionDate) {
		this.completionDate = completionDate;
	}

	/**
	 * @return the solverId
	 */
	public int getSolverId() {
		return solverId;
	}

	/**
	 * @param solverId the solverId to set
	 */
	public void setSolverId(int solverId) {
		this.solverId = solverId;
	}
	
	
	
	
	
}
