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

public class EditRequestController {
	RequestRepository rr1 = new RequestRepository();
	Request request1 = new Request();
/*
	  @FXML
	    private ComboBox<?> selectRequestIdCombo1;

	    @FXML
	    private ComboBox<?> selectResolverNameCombo1;

	    @FXML
	    private ComboBox<?> selectStatusCombo1;
*/
	    @FXML
	    private Button updateRequestBtn1;

	    @FXML
	    private TableView<Request> requestTable1;

	 @FXML
	    private TableColumn<Request, Integer> requestIdColumn1;

	    @FXML
	    private TableColumn<Request, String> reportedByColumn1;

	    @FXML
	    private TableColumn<Request, Date> requestDateColumn1;

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
	    private TableColumn<Request, Date> completionDateColumn1;

	    @FXML
	    private TableColumn<Request, String> resolvedByColumn1;

	    @FXML
	    private TextField statusTextField1;

	    @FXML
	    private TextField completionDateTextField1;

	    @FXML
	    private TextField requestIdTextField1;

	    @FXML
	    private TextField resolverTextField1;

	    @FXML
		private void initialize () {
	    	
	    	requestTable1.setOnMouseClicked(this::handleTableOnMouseClicked);
	   
	    	// Match column with property
			requestIdColumn1.setCellValueFactory(new PropertyValueFactory<Request, Integer>("requestId"));
			reportedByColumn1.setCellValueFactory(new PropertyValueFactory<Request, String>("reportedBy"));
			requestDateColumn1.setCellValueFactory(new PropertyValueFactory<Request, Date>("requestDate"));
			addressColumn1.setCellValueFactory(new PropertyValueFactory<Request, String>("address"));
			houseNoColumn1.setCellValueFactory(new PropertyValueFactory<Request, String>("houseNo"));
			apartmentNoColumn1.setCellValueFactory(new PropertyValueFactory<Request, Integer>("apartmentNo"));
			districtColumn1.setCellValueFactory(new PropertyValueFactory<Request, String>("district"));
			descriptionColumn1.setCellValueFactory(new PropertyValueFactory<Request, String>("description"));
			statusColumn1.setCellValueFactory(new PropertyValueFactory<Request, String>("status"));
			completionDateColumn1.setCellValueFactory(new PropertyValueFactory<Request, Date>("completionDate"));
			resolvedByColumn1.setCellValueFactory(new PropertyValueFactory<Request, String>("completedBy"));
	 
			// Update table
			updateTable();
	  
	    }
				  
		    
	    @FXML
	    private void handleTableOnMouseClicked(MouseEvent event)
	    {
	    	request1 = requestTable1.getSelectionModel().getSelectedItem();
	    //	tfActiveRequest.setText(request.getName());
	    	
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
