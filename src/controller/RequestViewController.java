package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class RequestViewController {
	//TODO
	
		public void openAddNewRequest(ActionEvent actionEvent) {
			//TODO
			ViewController.activate("AddRequest");
	        System.out.println("(Add)RequestView should open");
		}
		
		public void openViewRequests(ActionEvent actionevent) {
			//TODO
			ViewController.activate("RequestView");
	    	System.out.println("openViewRequestsForm should open");
		}
		
		@FXML
	    private void setLimitBy(ActionEvent event) {
	    	//TODO
	    	System.out.println("Limit should be set");
	    }
		
		@FXML
	    private void showSelectedRequest(ActionEvent actionevent) {
			//TODO
			//setLimitBy - used here?
			ViewController.activate("RequestView"); //TODO correct view?
	    	System.out.println("openViewRequestsForm? should show selected request");
		}
		
		@FXML
	    private void showEditSelectedRequest(ActionEvent actionevent) {
			//TODO
			//setLimitBy - used here?
			ViewController.activate("RequestView"); //TODO correct view?
	    	System.out.println("openViewRequestsForm? should show selected request and allow editing");
		}
		
		
		
}


