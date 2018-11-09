package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import model.Apartment;
import repository.ApartmentRepository;

import java.util.ArrayList;
import java.util.Observable;

public class AddRequestController {
//TODO

	//Select the apartment from a list
	@FXML
	private ChoiceBox<String> selectApartment;
	@FXML
	private Button goHome;

	//On init we populate the list with the apartments.
	@FXML
	private void initialize () {
		/*
		//Create a arraylist
		ArrayList<String> getList = new ArrayList<String>();
		//Grab the repository
		ApartmentRepository apartments = new ApartmentRepository();
		getList.add(apartments.getAll().toString());
		ObservableList<String> apartmentlist = FXCollections.observableArrayList(getList);
		selectApartment.setItems(apartmentlist);
		System.out.println("List: " + apartmentlist);
		*/
	}

	@FXML
	public void ChoiceBoxApartment(ActionEvent actionEvent) {

		String selectedItem = selectApartment.getSelectionModel().getSelectedItem().toString();
		System.out.println("You selected the item: " + selectedItem);
	}


	//Go back to home screen
	@FXML
	public void goHome(ActionEvent actionEvent) {

		ViewController.activate("StartView");
	}

}
