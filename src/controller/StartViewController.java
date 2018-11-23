package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class StartViewController {
	 @FXML
	 private Button openNewRequestFormBtn;
	 @FXML
	 private Button openViewRequestFormBtn;

	 @FXML
	 private TextArea startMessageConsole;
	 @FXML
	 private Button openAdminFormBtn;
	    
	 //Initializing the controller class.
    //This method is automatically called after the fxml file has been loaded.
    @FXML
    private void initialize () {
    	
    }
	@FXML
	private void openNewRequestForm(ActionEvent event) {
        ViewController.activate("AddRequest");
        System.out.println("(Add)RequestView should open");

	}

    @FXML
    private void openAdminForm(ActionEvent event) {
    	ViewController.activate("AdminForm");
    	System.out.println("openAdminForm should open");
    }
    
    @FXML
    private void openViewRequests(ActionEvent event) {
    	 ViewController.activate("RequestView");
    	System.out.println("openViewRequestsForm should open");
    }
}
