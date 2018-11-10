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
import repository.ApartmentRepository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Observable;

public class AddRequestController {
//TODO
	
    @FXML
    private TextArea messageConsoleTextArea;
 
	@FXML
	private ChoiceBox<String> addRequestApartmentChoiceBox;
	
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

		String selectedItem = selectApartment.getSelectionModel().getSelectedItem().toString();
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
		 availableChoices = FXCollections.observableArrayList("1","2","3"); //TODO working example
		 addRequestApartmentChoiceBox.setItems(availableChoices);

		 
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
	 	
	 	String apartment = addRequestApartmentChoiceBox.getValue().toString(); 
	 	
	 	System.out.println("Requester name: " + firstName +" " + lastName + ", apartment number " + apartment + "\nRequest description: " + description);
		 
	 	//TODO submit addRequest
	 
	 }

	//Go back to home screen
	@FXML
	public void goHome(ActionEvent actionEvent) {

		ViewController.activate("StartView");
	}
	

}
