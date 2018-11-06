package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.Area;
import repository.AreaRepository;


public class AreaController{

	AreaRepository ar = new AreaRepository();
	
	@FXML
	private Button btnCreateArea;
 
	@FXML
	private TextField areaName;
	
	@FXML
	private TableView<Area> areaTable;
	
	@FXML
    TableColumn<Area, String> idArea;
	
	@FXML
    TableColumn<Area, String> idName;
	
	@FXML
	private void initialize () {
		
		// mouseclick eventhandler
		btnCreateArea.setOnMouseClicked(this::handleOnMouseClicked);

		// Match column with property
		idArea.setCellValueFactory(new PropertyValueFactory<Area, String>("id"));
		idName.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		// Uppdatera tabellen
		updateTable();
	}

    @FXML
    private void handleOnMouseClicked(MouseEvent event)
    {
    	// Kolla så inte textfältet är tomt
    	if (!(areaName.getText().length() > 0)){
    		return;
    	}
		
    	// Skapa ett areaobjekt och lägg till det i databasen
		Area area = new Area();
		area.setName(areaName.getText());
		ar.add(area);

		// Töm inmatningsfältet och uppdatera tabellen
		areaName.setText("");
		updateTable();
    }
    
    private void updateTable() {
    	
		ObservableList<Area> list = FXCollections.observableArrayList(ar.getAll());
		areaTable.setItems((ObservableList<Area>) list);
    }

}
