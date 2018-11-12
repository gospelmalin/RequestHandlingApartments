package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.Apartment;
import model.House;
import model.Request;
import repository.ApartmentRepository;
import repository.HouseRepository;
import repository.RequestRepository;
import util.Util;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;

public class AddRequestController {
//TODO
	
    @FXML
    private TextArea messageConsoleTextArea;
 
	@FXML
	private ChoiceBox<Integer> addRequestApartmentChoiceBox;
	
	@FXML
	private ChoiceBox<String> addRequestHouseChoiceBox;
	
	//Select the apartment from a list
	@FXML
	private ChoiceBox<String> selectApartment;
	
	@FXML
	private Button goHome;
	
	  @FXML
	    private Button submitAddRequestBtn;

	    @FXML
	    private TextField requesterFirstNameTextField;

	    @FXML
	    private TextField requesterLastNameTextField;

	    @FXML
	    private TextArea requestDescriptionTextArea;


	//On init we populate the list with the apartments.
	@FXML
	private void initialize () {

		updateListOfApartments();
		
		updateListOfHouses();
		



	}

	@FXML
	public void ChoiceBoxApartment(ActionEvent actionEvent) {
		String selectedItem = addRequestApartmentChoiceBox.getSelectionModel().getSelectedItem().toString();
		//String selectedItem = selectApartment.getSelectionModel().getSelectedItem().toString();
		System.out.println("You selected the item: " + selectedItem);
	}
	
	@FXML
	public void ChoiceBoxHouse(ActionEvent actionEvent) {
		String selectedItem = addRequestHouseChoiceBox.getSelectionModel().getSelectedItem().toString();
		System.out.println("You selected the item: " + selectedItem);
	}

	 private void updateListOfApartments() {

		 //get repository Apartment
		 ApartmentRepository ar = new ApartmentRepository();
		 //Create a Arraylist with type Apartment and store all apartment object
		 ArrayList<Apartment> ApartmentArray = ar.getAll();
		 //Create a Integer arraylist to store the apartment numbers
		 ArrayList<Integer> getList = new ArrayList<Integer>();

		 //We loop through every apartment in the Apartment array.
		 for(Apartment no : ApartmentArray) {
		 	//int grabID = no.getApartmentId();//And for every apartment in the array we get the id
		 	//getList.add(grabID); //Add the ID to the new Integer arraylist
		 	int grabApartmentNo = no.getApartmentNo();//And for every apartment in the array we get the apartmentNo
		 	getList.add(grabApartmentNo); //Add the apartmentNo to the new Integer arraylist
		 }
		//String buildFinalString = getList.toString(); //choicebox tar bara en lista med strings on inte Integers
		 // To set the items in the choice box:
		 ObservableList<Integer>  availableChoices = FXCollections.observableArrayList(getList);
		 addRequestApartmentChoiceBox.setItems(availableChoices);



	    }
	 
	 
	 private void updateListOfHouses() {
		//get repository
		 HouseRepository hr = new HouseRepository();

		 ArrayList<House> HouseArray = hr.getAll();

		 //Create a String arraylist to store the house numbers
		 ArrayList<String> getHouseNoList = new ArrayList<String>();

		 //We loop through every houseno in the House array.
		 for(House house : HouseArray) {
			 String grabHouse = house.getHouseNo();//For every object get the house no
			 getHouseNoList.add(grabHouse); //Add the ID to the new Integer arraylist
		 }
		 
		 //To get the items in the choice box:
		 //ObservableList<String> availableChoices1 = addRequestHouseChoiceBox.getItems();
		 
		// To set the items in the choice box:
		 ObservableList<String> availableHouseChoices = FXCollections.observableArrayList(getHouseNoList);
		 addRequestHouseChoiceBox.setItems(availableHouseChoices);

	 }
	 
	 @FXML
		public void submitAddRequest(ActionEvent actionEvent) {
		// Check that text field is not empty
	    	if (!(requesterFirstNameTextField.getText().length() > 0)){
	    		return;
	    	}
	 	String firstName = requesterFirstNameTextField.getText();
		 // Check that text field is not empty
			if (!(requesterLastNameTextField.getText().length() > 0)){
				return;
			}
	 	String lastName = requesterLastNameTextField.getText();
		 // Check that text area is not empty
			if (!(requestDescriptionTextArea.getText().length() > 0)){
				return;
			}
	 	String description = requestDescriptionTextArea.getText();
	 	
	 	int apartmentString = addRequestApartmentChoiceBox.getValue();
	 	//int apartment = Integer.parseInt(apartmentString);
	 	String house = addRequestHouseChoiceBox.getValue().toString();
		 
	 	String fullName = firstName + ' ' + lastName;

	 	Util util = new Util();
	 	java.sql.Date requestDate = util.getCurrentDate();
	 	
	 	System.out.println("Requester name: " + firstName +" " + lastName 
	 			+ ", apartment number " + apartmentString + ", house number " + house
	 			+ "\nRequest description: " + description +"\nRequest date: " + requestDate);
	 	//TODO submit addRequest
	 	//Request request = new Request(fullName, apartment, description);
	 	Request request = new Request(fullName, apartmentString, house, description, requestDate);
	 	RequestRepository rr = new RequestRepository();
	 	rr.add(request);
	 
	 	System.out.println("Your request is submitted and will be handled.");
	 	
	 	ViewController.activate("RequestView"); // Will show request view, but not updated :(
	 	/*//TEST showing selected
	 	RequestRepository rr2 = new RequestRepository();
	 	Request latestRequest= rr2.getLastAdded();
	 	System.out.println(latestRequest.getRequestId());
	 	*/
	 }

	//Go back to home screen
	@FXML
	public void goHome(ActionEvent actionEvent) {

		ViewController.activate("StartView");
	}
	

}
