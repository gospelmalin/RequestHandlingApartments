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
	 
	    
	 //Initializing the controller class.
    //This method is automatically called after the fxml file has been loaded.
    @FXML
    private void initialize () {
    	
    }
	@FXML
	private void openNewRequestForm(ActionEvent event) {
        ViewController.activate("RequestView");
        System.out.println("RequestView should open");

	}

    @FXML
    private void openAdminForm(ActionEvent event) {
    	//TODO
    	System.out.println("openAdminForm should open");
    }
    
    @FXML
    private void openEditRequestForm(){
    	//TODO
    }
    @FXML
    private void openViewRequestsForm(){
    	//TODO
    }
	@FXML
    private void openViewEditStatusForm(){
		//TODO
	}
	@FXML
    private void openViewEditPersonForm(){
		//TODO	
	}
	@FXML
    private void openViewEditAreaForm(){
		//TODO
	}
	@FXML
    private void openViewEditHouseForm(){
		//TODO
	}
	@FXML
    private void openViewEditRolesForm(){
		//TODO
	}
	@FXML
    private void openViewEditApartmentForm() {
		//TODO
	}
    		
}
