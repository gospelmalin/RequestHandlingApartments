package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.Request;
import repository.RequestRepository;
import java.sql.Date;

public class RequestViewController {
	
	RequestRepository rr = new RequestRepository();
	Request request = new Request();
	
	 @FXML
    private Button goHome;
	 
	 @FXML
	private Button refreshBtn;

		@FXML
	private TableView<Request> requestTable;
	
	 @FXML
	 private ComboBox<String> selectApartmentCombo;
	 
	 @FXML
	 private ComboBox<String> selectStatusCombo;
	
	 @FXML
	 private TextField numberOfResultsText;
	 
	 @FXML
    private TableColumn<Request, Integer> requestIdColumn;

    @FXML
    private TableColumn<Request, String> reportedByColumn;

    @FXML
    private TableColumn<Request, Date> requestDateColumn;

    @FXML
    private TableColumn<Request, String> addressColumn;

    @FXML
    private TableColumn<Request, String> houseNoColumn;

    @FXML
    private TableColumn<Request, Integer> apartmentNoColumn;

    @FXML
    private TableColumn<Request, String> districtColumn;

    @FXML
    private TableColumn<Request, String> descriptionColumn;

    @FXML
    private TableColumn<Request, String> statusColumn;

    @FXML
    private TableColumn<Request, Date> completionDateColumn;

    @FXML
    private TableColumn<Request, String> resolvedByColumn;

    @FXML
    private Button requestInformationSubmitButton;

    @FXML
    private TextField requestIdText;

    @FXML
    private Button showSelectedRequestBtn;

    @FXML
    private Button showEditSelectedRequestBtn;
	
	//TODO
	
	
	@FXML
	private void initialize () {
		
		selectStatusCombo.getItems().addAll("Not started","In progress","Completed","Any");
		selectStatusCombo.setValue("Any");
		
		//TODO
		//mouseclick eventhandler
	//	btnCreateDistrict.setOnMouseClicked(this::handleOnMouseClicked); //TODO
		requestTable.setOnMouseClicked(this::handleTableOnMouseClicked);

		//TODO
		// Match column with property
		requestIdColumn.setCellValueFactory(new PropertyValueFactory<Request, Integer>("requestId"));
		reportedByColumn.setCellValueFactory(new PropertyValueFactory<Request, String>("reportedBy"));
		requestDateColumn.setCellValueFactory(new PropertyValueFactory<Request, Date>("requestDate"));
		addressColumn.setCellValueFactory(new PropertyValueFactory<Request, String>("address"));
		houseNoColumn.setCellValueFactory(new PropertyValueFactory<Request, String>("houseNo"));
		apartmentNoColumn.setCellValueFactory(new PropertyValueFactory<Request, Integer>("apartmentNo"));
		districtColumn.setCellValueFactory(new PropertyValueFactory<Request, String>("district"));
		descriptionColumn.setCellValueFactory(new PropertyValueFactory<Request, String>("description"));
		statusColumn.setCellValueFactory(new PropertyValueFactory<Request, String>("status"));
		completionDateColumn.setCellValueFactory(new PropertyValueFactory<Request, Date>("completionDate"));
		resolvedByColumn.setCellValueFactory(new PropertyValueFactory<Request, String>("completedBy"));
		
		
		// Update table
		updateTable();
	}
	
	
	@FXML
    private void handleTableOnMouseClicked(MouseEvent event)
    {
    	request = requestTable.getSelectionModel().getSelectedItem();
    //	tfActiveRequest.setText(request.getName());
    	
    }
	
	
	 @FXML
    public void goHome(ActionEvent actionEvent) {
        ViewController.activate("StartView");
    }
	
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
			ViewController.activate("EditRequest"); //TODO correct view?
	    	System.out.println("EditRequestForm? should show selected request and allow editing");
		}
		
		
		 private void updateTable() {
		    	
				ObservableList<Request> list = FXCollections.observableArrayList(rr.getAll());
				requestTable.setItems((ObservableList<Request>) list);
		    }
		
		 
		 @FXML
		 private void refreshData() {
		 updateTable();
		 }

		    @FXML
		 private void showRequestsForSelectedApartmentsAndStatusByLimit(ActionEvent event) {
		    	String apartment = null; //TODO get text from selection of combobox selectApartmentCombo		  
		    	//String apartment = selectApartmentCombo.getValue();
		    	
		    	String status = selectStatusCombo.getValue(); //TODO get text from selection of combobox selectStatusCombo
		    	
			    	// Check that text field is not empty
			    	if (!(numberOfResultsText.getText().length() > 0)){
			    		return;
			    	}
		    	int limit = Integer.parseInt(numberOfResultsText.getText());
		    	System.out.println(limit + " requests for apartment " + apartment + " with " + status + " status should be shown in the table in RequestView");
		    	
		    	//TODO add code to show selected requests. Need sql like
		    	// select and from as for get all, + WHERE a.apartment_no = apartment AND s.status_description= status
		    	// ORDER by r.request_id, r.apartment_id
		    	//LIMIT BY limit
		    }


}


   
   

