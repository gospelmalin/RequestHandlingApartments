package model;

public class House {
	private int houseId;
	private String houseNo;
	private int districtId;
	private String houseAddress;
	
	public House() {}

	public House(int houseId, String houseNo, int districtId, String houseAddress) {
		this.houseId = houseId;
		this.houseNo = houseNo;
		this.districtId = districtId;
		this.houseAddress = houseAddress;
	}

	public House(int houseId, String houseNo) {
		this.houseId = houseId;
		this.houseNo = houseNo;
	}

	public House(int houseId, String houseNo, String houseAddress) {
		this.houseId = houseId;
		this.houseNo = houseNo;
		this.houseAddress = houseAddress;
	}

	public House(String houseNo, String houseAddress) {
		this.houseNo = houseNo;
		this.houseAddress = houseAddress;
	}

	public int getHouseId() {
		return houseId;
	}

	public void setHouseId(int houseId) {
		this.houseId = houseId;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public int getDistrictId() {
		return districtId;
	}

	public void setDistrictId(int districtId) {
		this.districtId = districtId;
	}

	public String getHouseAddress() {
		return houseAddress;
	}

	public void setHouseAddress(String houseAddress) {
		this.houseAddress = houseAddress;
	}
	
	@Override
	public String toString() {
		return "House [Houseid=" + houseId + ", houseNo=" + houseNo + ", districtId=" + districtId + ", toString()=" + super.toString() + "]";
	}

}
