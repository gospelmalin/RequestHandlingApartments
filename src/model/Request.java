package model;

import java.sql.Date;

public class Request {
//TODO
	
	private int requestId;
	//private int requesterId;
	private String reportedBy;
	//private int apartmentId;
	private int apartmentNo;
	private String address;
	private String houseNo;
	private String description;
	private String status;
	private Date requestDate; //TODO type?
	//private int statusId;
	private Date completionDate; //TODO type?
	//private int solverId;
	private String completedBy;
	
	public Request() {}

	
	public Request(int requestId, String reportedBy, int apartmentNo, String address, String houseNo,
			String description, String status, Date requestDate, Date completionDate, String completedBy) {
		this.requestId = requestId;
		this.reportedBy = reportedBy;
		this.apartmentNo = apartmentNo;
		this.address = address;
		this.houseNo = houseNo;
		this.description = description;
		this.status = status;
		this.requestDate = requestDate;
		this.completionDate = completionDate;
		this.completedBy = completedBy;
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
	 * @return the reportedBy
	 */
	public String getReportedBy() {
		return reportedBy;
	}


	/**
	 * @param reportedBy the reportedBy to set
	 */
	public void setReportedBy(String reportedBy) {
		this.reportedBy = reportedBy;
	}


	/**
	 * @return the apartmentNo
	 */
	public int getApartmentNo() {
		return apartmentNo;
	}


	/**
	 * @param apartmentNo the apartmentNo to set
	 */
	public void setApartmentNo(int apartmentNo) {
		this.apartmentNo = apartmentNo;
	}


	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}


	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}


	/**
	 * @return the houseNo
	 */
	public String getHouseNo() {
		return houseNo;
	}


	/**
	 * @param houseNo the houseNo to set
	 */
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}


	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}


	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}


	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}


	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
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
	 * @return the completedBy
	 */
	public String getCompletedBy() {
		return completedBy;
	}


	/**
	 * @param completedBy the completedBy to set
	 */
	public void setCompletedBy(String completedBy) {
		this.completedBy = completedBy;
	}

	@Override
	public String toString() {
		return "Request [id=" + requestId + ", reportedBy=" + reportedBy +
				", apartmentNo=" + apartmentNo + ", address=" + address +
				", houseNo=" + houseNo + ", description=" + description +
				", status=" + status + ", requestDate=" + requestDate +
				", completionDate=" + completionDate + ", completedBy=" + completedBy +
				", toString()=" + super.toString() + "]";
	}

	
}
