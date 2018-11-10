package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;

public class AdminViewController {

	 @FXML
	 private Button openEditRequestFormBtn;
	 @FXML
	 private Button openViewRequestFormBtn;
	 @FXML
	 private Button openViewEditStatusFormBtn;
	 @FXML
	 private Button openViewEditPersonFormBtn1;
	 @FXML
	 private Button openViewEditAreaFormBtn;
	 @FXML
	 private Button openViewEditHouseFormBtn;
	 @FXML
	 private Button openViewEditRolesFormBtn;
	 @FXML
	 private Button openViewEditApartmentFormBtn;
	 @FXML
	 private ChoiceBox selectRequestIdChoice;
	 @FXML
	 private TextArea startMessageConsole;
	 @FXML
	 private Button goHome;
	 
	    
	 //Initializing the controller class.
    //This method is automatically called after the fxml file has been loaded.
    @FXML
    private void initialize () {
    	//TODO
    }
	@FXML
	private void openNewRequestForm(ActionEvent event) {
		ViewController.activate("AddRequest");
        System.out.println("RequestView should open");
	}
    
    @FXML
    private void openEditRequestForm(ActionEvent event){
    	ViewController.activate("EditRequest");
    	System.out.println("EditRequest should open");
    }
    @FXML
    private void openViewRequestsForm(ActionEvent event){
    	ViewController.activate("RequestView");
    	System.out.println("ViewRequests should open");
    }
	@FXML
    private void openViewEditStatusForm(ActionEvent event){
		//TODO
		System.out.println("ViewEditStatus should open");
	}
	@FXML
    private void openViewEditPersonForm(ActionEvent event){
		//TODO	
		System.out.println("ViewEditPerson should open");
	}
	@FXML
    private void openViewEditDistrictForm(ActionEvent event){
		ViewController.activate("DistrictView"); //TODO
		System.out.println("ViewEditDistrict should open");
	}
	@FXML
    private void openViewEditHouseForm(ActionEvent event){
		//TODO
		System.out.println("ViewEditHouse should open");
	}
	@FXML
    private void openViewEditRolesForm(ActionEvent event){
		//TODO
		System.out.println("ViewEditRoles should open");
	}
	@FXML
    private void openViewEditApartmentForm(ActionEvent event) {
		//TODO
		System.out.println("ViewEditApartment should open");
	}

	//Go back to home screen
	@FXML
	public void goHome(ActionEvent actionEvent) {

		ViewController.activate("StartView");
	}
    		
}
