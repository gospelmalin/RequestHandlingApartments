package model;

public class Apartment {

	private int apartmentId;
	private int apartmentNo;
	private int houseId;
	private String houseNumber;

	
	public Apartment() {}

	public Apartment(int apartmentId, int apartmentNo, int houseId, String houseNumber ) {
		this.apartmentId = apartmentId;
		this.apartmentNo = apartmentNo;
		this.houseId = houseId;
		this.houseNumber = houseNumber;
	}


	public Apartment(int apartmentId, int apartmentNo, int houseId) {
		this.apartmentId = apartmentId;
		this.apartmentNo = apartmentNo;
		this.houseId = houseId;

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
	 * @return the houseId
	 */
	public int getHouseId() {
		return houseId;
	}

	/**
	 * @return the houseId
	 */
	public String getHouseNumber() {return houseNumber;}

	/**
	 * @param houseId the houseId to set
	 */
	public void setHouseId(int houseId) {
		this.houseId = houseId;
	}
	
	@Override
	public String toString() {
		return "Apartment [Apartmentid=" + apartmentId + ", apartmentNo=" + apartmentNo + ", houseId=" + houseId +  ", houseNumber=" + houseNumber +", toString()=" + super.toString() + "]";
	}
}
