package model;

import java.sql.Date;

public class Request {
//TODO
	
	private int requestId;
	private int requesterId;
	private String reportedBy;
	private Date requestDate; //TODO type?
	private int apartmentId;
	private String address;
	private String houseNo;
	private int apartmentNo;
	private String district;
	private String description;
	private String status;
	private int statusId;
	private Date completionDate; //TODO type?
	private int solverId;
	private String completedBy;
	
	public Request() {}


	public Request(int requestId, String reportedBy, Date requestDate, String address, String houseNo, int apartmentNo,
			String district, String description, String status, Date completionDate, String completedBy) {
		this.requestId = requestId;
		this.reportedBy = reportedBy;
		this.requestDate = requestDate;
		this.address = address;
		this.houseNo = houseNo;
		this.apartmentNo = apartmentNo;
		this.district = district;
		this.description = description;
		this.status = status;
		this.completionDate = completionDate;
		this.completedBy = completedBy;
	}


	public Request(int requestId, int requesterId, String reportedBy, Date requestDate, int apartmentId, String address,
			String houseNo, int apartmentNo, String district, String description, String status, int statusId,
			Date completionDate, int solverId, String completedBy) {
		this.requestId = requestId;
		this.requesterId = requesterId;
		this.reportedBy = reportedBy;
		this.requestDate = requestDate;
		this.apartmentId = apartmentId;
		this.address = address;
		this.houseNo = houseNo;
		this.apartmentNo = apartmentNo;
		this.district = district;
		this.description = description;
		this.status = status;
		this.statusId = statusId;
		this.completionDate = completionDate;
		this.solverId = solverId;
		this.completedBy = completedBy;
	}


	public Request(int requestId, int requesterId, String reportedBy, Date requestDate) {
		this.requestId = requestId;
		this.requesterId = requesterId;
		this.reportedBy = reportedBy;
		this.requestDate = requestDate;
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
	 * @return the district
	 */
	public String getDistrict() {
		return district;
	}


	/**
	 * @param district the district to set
	 */
	public void setDistrict(String district) {
		this.district = district;
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
