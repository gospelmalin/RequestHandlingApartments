package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.District;
import repository.DistrictRepository;


public class DistrictController{

	DistrictRepository dr = new DistrictRepository();
	
	@FXML
	private Button btnCreateDistrict;
	@FXML
	private Button btnUpdateDistrict;
	@FXML
	private Button btnDeleteDistrict;
	@FXML
	private Button btnHome;
	
	@FXML
	private TextField districtName;
	@FXML
	private TextField tfActiveDistrict;
	
	@FXML
	private TableView<District> districtTable;
	
	@FXML
    TableColumn<District, String> idDistrict;
	
	@FXML
    TableColumn<District, String> idName;
	
	District district;
	
	@FXML
	private void initialize () {
		
		// mouseclick eventhandlers
		btnCreateDistrict.setOnMouseClicked(this::handleOnMouseClicked);
		btnUpdateDistrict.setOnMouseClicked(this::handleUpdateOnMouseClicked);
		btnDeleteDistrict.setOnMouseClicked(this::handleDeleteOnMouseClicked);
		btnHome.setOnMouseClicked(this::goHome);
		districtTable.setOnMouseClicked(this::handleTableOnMouseClicked);
		

		// Match column with property
		idDistrict.setCellValueFactory(new PropertyValueFactory<District, String>("id"));
		idName.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		// Update table
		updateTable();
		
	}
 
   @FXML
    private void handleUpdateOnMouseClicked(MouseEvent event)
    {
	   // Check for empty str
	   if(tfActiveDistrict.getText() == "") {
		   return;
	   }
	   
	   // Get text
	   district.setName(tfActiveDistrict.getText());
	   
	   // Update
	   dr.update(district);
	   
	   // Update table
	   updateTable();
    }

   @FXML
   private void handleDeleteOnMouseClicked(MouseEvent event)
   {
	   // Check for empty str
	   if(district == null) {
		   return;
	   }
	   
	   // Delete
	   dr.remove(district);
	   
	   // Update table
	   updateTable();
   }

	@FXML
    private void handleTableOnMouseClicked(MouseEvent event)
    {
    	district = districtTable.getSelectionModel().getSelectedItem();
    	tfActiveDistrict.setText(district.getName());
    	
    }
   
    // Check that text field is not empty
    @FXML
    private void handleOnMouseClicked(MouseEvent event)
    {
    	// Check that text field is not empty
    	if (!(districtName.getText().length() > 0)){
    		return;
    	}
		
    	// Create a district object and add it to the database
		District district = new District();
		district.setName(districtName.getText());
		dr.add(district);

		// Empty input text field and update the table
		districtName.setText("");
		updateTable();
    }
    
    private void updateTable() {
    	
		ObservableList<District> list = FXCollections.observableArrayList(dr.getAll());
		districtTable.setItems((ObservableList<District>) list);
		
	
    }

	//Go back to home screen
	@FXML
	public void goHome(MouseEvent event) {

		ViewController.activate("StartView");
	}

}
