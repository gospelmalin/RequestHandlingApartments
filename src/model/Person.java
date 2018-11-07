package model;

public class Person {
	
	private int personId;
	private String firstName;
	private String lastName;
	private String fullName;
	
	public Person() {}

	public Person(int personId, String firstName, String lastName, String fullName) {
		this.personId = personId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.fullName = fullName;
	}
	
	public Person(int personId, String firstName, String lastName) {
		setPersonId(personId);
		setFirstName(firstName);
		setLastName(lastName);
		setFullName(firstName, lastName);
	}
	
	//TODO list of roles
	//TODO list of requests
	//TODO list of apartments (holding one or none)

	/**
	 * @return the personId
	 */
	public int getPersonId() {
		return personId;
	}

	/**
	 * @param personId the personId to set
	 */
	public void setPersonId(int personId) {
		this.personId = personId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String firstName, String lastName) {
		this.fullName = firstName + " " + lastName;
	}


	@Override
	public String toString() {
		return "Person [id=" + personId + ", first name=" + firstName + ", last name=" + lastName +", name=" + fullName + ", toString()=" + super.toString() + "]";
	}
	

}
