package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
	private TextField districtName;
	
	@FXML
	private TableView<District> districtTable;
	
	@FXML
    TableColumn<District, String> idDistrict;
	
	@FXML
    TableColumn<District, String> idName;
	
	@FXML
	private void initialize () {
		
		// mouseclick eventhandler
		btnCreateDistrict.setOnMouseClicked(this::handleOnMouseClicked);

		// Match column with property
		idDistrict.setCellValueFactory(new PropertyValueFactory<District, String>("id"));
		idName.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		// Update table
		updateTable();
	}

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
	public void goHome(ActionEvent actionEvent) {

		ViewController.activate("StartView");
	}

}
