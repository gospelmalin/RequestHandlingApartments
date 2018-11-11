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
import model.Request;
import repository.ApartmentRepository;
import repository.HouseRepository;
import repository.RequestRepository;
import util.Util;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Observable;

public class AddRequestController {
//TODO
	
    @FXML
    private TextArea messageConsoleTextArea;
 
	@FXML
	private ChoiceBox<String> addRequestApartmentChoiceBox;
	
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
		
		/*
		//Moved this to separate method updateListOfApartments()
		//Create a arraylist
		ArrayList<String> getList = new ArrayList<String>();
		//Grab the repository
		ApartmentRepository apartments = new ApartmentRepository();
		getList.add(apartments.getAll().toString());
		ObservableList<String> apartmentlist = FXCollections.observableArrayList(getList);
		selectApartment.setItems(apartmentlist);
		System.out.println("List: " + apartmentlist);
*/
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
	    /*	
		//Create a arraylist
			ArrayList<String> getList = new ArrayList<String>();
			//Grab the repository
			ApartmentRepository apartments = new ApartmentRepository();
			getList.add(apartments.getAll().toString());
			ObservableList<String> apartmentlist = FXCollections.observableArrayList(getList);
			selectApartment.setItems(apartmentlist);
			System.out.println("List: " + apartmentlist);
	*/
		 //ApartmentRepository ar = new ApartmentRepository();
		 //ObservableList<String> list = FXCollections.observableArrayList(ar.getAll().toString());
		// addRequestApartmentChoiceBox.setItems((ObservableList<String>) list);
		 
		 //get repository
		 ApartmentRepository ar = new ApartmentRepository();
		 
		 //test from here
		 /*
		 //get Apartment
		 Apartment apartment = new Apartment();
		 
		 ArrayList<Apartment> apartments = ar.getAll();
		 apartment.apartmentId = apartments.get(1);
		 
		 
			int personIdFromPerson = person.getPersonId();
			int apartmentIdFromPerson = ap.getApartmentId();
			String descriptionFromPerson = t.getDescription();
			Date requestDateFromPerson = t.getRequestDate();
		*/ //until here
		 //To get the items in the choice box: 
		 ObservableList<String> availableChoices = addRequestApartmentChoiceBox.getItems();
		 
		// To set the items in the choice box: 
		 availableChoices = FXCollections.observableArrayList("15","25","35","45","4","5","6","7","31", "32","33", "34"); //TODO working example
		 addRequestApartmentChoiceBox.setItems(availableChoices);

		 
	    }
	 
	 
	 private void updateListOfHouses() {
		//get repository
		 HouseRepository hr = new HouseRepository();
		 
		 //TODO
		 
		 //To get the items in the choice box: 
		 ObservableList<String> availableChoices1 = addRequestHouseChoiceBox.getItems();
		 
		// To set the items in the choice box: 
		 availableChoices1 = FXCollections.observableArrayList("10A","3510","2045"); //TODO working example
		 addRequestHouseChoiceBox.setItems(availableChoices1);

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
	 	
	 	String apartmentString = addRequestApartmentChoiceBox.getValue().toString(); 
	 	int apartment = Integer.parseInt(apartmentString);
	 	String house = addRequestHouseChoiceBox.getValue().toString();
		 
	 	String fullName = firstName + ' ' + lastName;
	 	
	 	Util util = new Util();
	 	java.sql.Date requestDate = util.getCurrentDate();
	 	
	 	System.out.println("Requester name: " + firstName +" " + lastName 
	 			+ ", apartment number " + apartment + ", house number " + house 
	 			+ "\nRequest description: " + description +"\nRequest date: " + requestDate);
	 	//TODO submit addRequest
	 	//Request request = new Request(fullName, apartment, description);
	 	Request request = new Request(fullName, apartment, house, description, requestDate);
	 	RequestRepository rr = new RequestRepository();
	 	rr.add(request);
	 	System.out.println("Your request is submitted and will be handled.");
	 	 
	 }

	//Go back to home screen
	@FXML
	public void goHome(ActionEvent actionEvent) {

		ViewController.activate("StartView");
	}
	

}
