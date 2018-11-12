package controller;

import java.sql.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.Request;
import repository.RequestRepository;
import util.Util;

public class EditRequestController {
	RequestRepository rr1 = new RequestRepository();
	Request request1 = new Request();
	Util util = new Util();
/*
	  @FXML
	    private ComboBox<?> selectRequestIdCombo1;

	    @FXML
	    private ComboBox<?> selectResolverNameCombo1;

	    @FXML
	    private ComboBox<?> selectStatusCombo1;
*/
	    @FXML
	    private Button updateRequestBtn;

	    @FXML
	    private TableView<Request> requestTable1;

	 @FXML
	    private TableColumn<Request, Integer> requestIdColumn1;

	    @FXML
	    private TableColumn<Request, String> reportedByColumn1;

	    @FXML
	    private TableColumn<Request, java.util.Date> requestDateColumn1;

	    @FXML
	    private TableColumn<Request, String> addressColumn1;

	    @FXML
	    private TableColumn<Request, String> houseNoColumn1;

	    @FXML
	    private TableColumn<Request, Integer> apartmentNoColumn1;

	    @FXML
	    private TableColumn<Request, String> districtColumn1;

	    @FXML
	    private TableColumn<Request, String> descriptionColumn1;

	    @FXML
	    private TableColumn<Request, String> statusColumn1;

	    @FXML
	    private TableColumn<Request, java.util.Date> completionDateColumn1;

	    @FXML
	    private TableColumn<Request, String> resolvedByColumn1;

	    @FXML
	    private TextField tfActiveStatus;

	    @FXML
	    private TextField tfActiveCompletionDate;

	    @FXML
	    private TextField tfActiveRequestId;

	    @FXML
	    private TextField tfActiveResolver;

	    @FXML
		private void initialize () {
	    	//Mouse click eventhandlers
	    	updateRequestBtn.setOnMouseClicked(this::handleUpdateOnMouseClicked);
	    	requestTable1.setOnMouseClicked(this::handleTableOnMouseClicked);
	    	
	    	//btnHome.setOnMouseClicked(this::goHome);
	   
	    	// Match column with property
			//requestIdColumn1.setCellValueFactory(new PropertyValueFactory<Request, Integer>("requestId"));
	    	requestIdColumn1.setCellValueFactory(new PropertyValueFactory<Request, Integer>("requestId"));
			reportedByColumn1.setCellValueFactory(new PropertyValueFactory<Request, String>("reportedBy"));
			requestDateColumn1.setCellValueFactory(new PropertyValueFactory<Request, java.util.Date>("requestDate"));
			addressColumn1.setCellValueFactory(new PropertyValueFactory<Request, String>("address"));
			houseNoColumn1.setCellValueFactory(new PropertyValueFactory<Request, String>("houseNo"));
			apartmentNoColumn1.setCellValueFactory(new PropertyValueFactory<Request, Integer>("apartmentNo"));
			districtColumn1.setCellValueFactory(new PropertyValueFactory<Request, String>("district"));
			descriptionColumn1.setCellValueFactory(new PropertyValueFactory<Request, String>("description"));
			statusColumn1.setCellValueFactory(new PropertyValueFactory<Request, String>("status"));
			completionDateColumn1.setCellValueFactory(new PropertyValueFactory<Request, java.util.Date>("completionDate"));
			resolvedByColumn1.setCellValueFactory(new PropertyValueFactory<Request, String>("completedBy"));
	 
			// Update table
			updateTable();
	  
	    }
				  
		
	    @FXML
	    private void handleUpdateOnMouseClicked(MouseEvent event) {
	    /*
	    	  // Check for empty str
	 	   if(tfActiveRequestId.getText() == "") {
	 		   return;
	 	   }
	 	   */
	 	   // Get text
	 	   request1.setRequestId(Integer.parseInt(tfActiveRequestId.getText()));
	 	   request1.setStatus(tfActiveStatus.getText());
	 	   java.util.Date completionDate = util.stringToDate(tfActiveCompletionDate.getText());
	 	   request1.setCompletionDate((Date) completionDate);
	 	   
	 	   request1.setStatus(tfActiveResolver.getText());
	 	 
	 	   
	 	   // Update record in database
	 	   rr1.update(request1);
	 	   
	 	   // Update table
	 	   updateTable();
	    }
	    
	    
	    @FXML
	    private void handleTableOnMouseClicked(MouseEvent event)
	    {
	    	request1 = requestTable1.getSelectionModel().getSelectedItem();
	    	System.out.println(request1); //TODO temp
	    	System.out.println("Request Id: "); //TODO temp
	    	System.out.println(request1.getRequestId()); // TODO temp
	    	String strId = Integer.toString(request1.getRequestId());
	    	System.out.println(strId); //TODO temp
	    	tfActiveRequestId.setText(strId);
	    	tfActiveStatus.setText(request1.getStatus());
	    	//tfActiveCompletionDate.setText((request1.getCompletionDate())+"");
	    	//String completionDate = (""+request1.getCompletionDate());
	    	tfActiveCompletionDate.setText(util.dateToString(request1.getCompletionDate()));
	    	//tfActiveCompletionDate.setText(request1.getCompletionDate()+"");
	    	//tfActiveCompletionDate.setDate(request1.getCompletionDate()) 
	    	tfActiveResolver.setText(request1.getCompletedBy());
	    	
	    	
	    }


		private void updateTable() {
	    	
			ObservableList<Request> list1 = FXCollections.observableArrayList(rr1.getAll());
			requestTable1.setItems((ObservableList<Request>) list1);
	    }
	    
	    @FXML
	    void goHome(ActionEvent event) {
	    	ViewController.activate("StartView");
	    }
}
