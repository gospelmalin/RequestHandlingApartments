package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.Request;
import repository.RequestRepository;

public class RequestViewController {
	
	RequestRepository rr = new RequestRepository();
	
	
	@FXML
	private TableView<Request> requestTable;
	
	
	//TODO
	/*
	@FXML
    TableColumn<District, String> idDistrict;
	
	@FXML
    TableColumn<District, String> idName;
	*/ 
	
	@FXML
	private void initialize () {
		//TODO
		// mouseclick eventhandler
	//	btnCreateDistrict.setOnMouseClicked(this::handleOnMouseClicked); //TODO

		//TODO
		// Match column with property
		//idDistrict.setCellValueFactory(new PropertyValueFactory<District, String>("id"));
	//	idName.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		// Update table
		updateTable();
	}
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
		
		 private void updateTable() {
		    	
				ObservableList<Request> list = FXCollections.observableArrayList(rr.getAll());
				requestTable.setItems((ObservableList<Request>) list);
		    }
		
}


