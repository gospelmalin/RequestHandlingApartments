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
import javafx.scene.layout.AnchorPane;
import model.Request;
import repository.RequestRepository;

public class RequestViewController {
	
	RequestRepository rr = new RequestRepository();
	
	 @FXML
    private Button goHome;

		@FXML
	private TableView<Request> requestTable;
	
	 @FXML
	 private ComboBox selectApartmentCombo;
	 
	 @FXML
	 private ComboBox selectStatusCombo;
	
	 @FXML
	 private TextField numberOfResultsText;
	 
	 @FXML
    private TableColumn<?, ?> requestIdColumn;

    @FXML
    private TableColumn<?, ?> reportedByColumn;

    @FXML
    private TableColumn<?, ?> requestDateColumn;

    @FXML
    private TableColumn<?, ?> addressColumn;

    @FXML
    private TableColumn<?, ?> houseNoColumn;

    @FXML
    private TableColumn<?, ?> apartmentNoColumn;

    @FXML
    private TableColumn<?, ?> districtColumn;

    @FXML
    private TableColumn<?, ?> descriptionColumn;

    @FXML
    private TableColumn<?, ?> statusColumn;

    @FXML
    private TableColumn<?, ?> completionDateColumn;

    @FXML
    private TableColumn<?, ?> resolvedByColumn;

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
		//TODO
		// mouseclick eventhandler
	//	btnCreateDistrict.setOnMouseClicked(this::handleOnMouseClicked); //TODO

		//TODO
		// Match column with property
		//idDistrict.setCellValueFactory(new PropertyValueFactory<District, String>("id"));
	//	idName.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		// Update table
	//	updateTable();
	}
	//TODO
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
			ViewController.activate("RequestView"); //TODO correct view?
	    	System.out.println("openViewRequestsForm? should show selected request and allow editing");
		}
		
		/*
		 private void updateTable() {
		    	
				ObservableList<Request> list = FXCollections.observableArrayList(rr.getAll());
				requestTable.setItems((ObservableList<Request>) list);
		    }
		*/

		    @FXML
		    void showRequestsForSelectedApartmentsAndStatusByLimit(ActionEvent event) {
		    	String apartment = null; //TODO get text from selection of combobox selectApartmentCombo		  
		    	String status = null; //TODO get text from selection of combobox selectStatusCombo
		    	
			    	// Check that text field is not empty
			    	if (!(numberOfResultsText.getText().length() > 0)){
			    		return;
			    	}
		    	int limit = Integer.parseInt(numberOfResultsText.getText());
		    	System.out.println(limit + " requests for apartment " + apartment + " with " + status + " should be shown in the table in RequestView");
		    	
		    	//TODO add code to show selected requests. Need sql like
		    	// select and from as for get all, + WHERE a.apartment_no = apartment AND s.status_description= status
		    	// ORDER by r.request_id, r.apartment_id
		    	//LIMIT BY limit
		    }


}


   
   

