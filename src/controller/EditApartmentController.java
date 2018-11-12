package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.Apartment;
import model.House;
import repository.ApartmentRepository;
import repository.HouseRepository;

import java.util.ArrayList;
import java.util.HashMap;

public class EditApartmentController {
    ApartmentRepository apartRepo = new ApartmentRepository();
    HashMap<String, Integer> houseWithId = new HashMap<>(); //Will store "House_no" and "house_id"
    @FXML
    private Button goHome;
    @FXML
    TextField fieldApartments;
    @FXML
    ChoiceBox<String> HouseChoiceBox;
    @FXML
    TableView<Apartment> apartmentTable;
    @FXML
    TableColumn<Apartment, Integer> id;
    @FXML
    TableColumn<Apartment, Integer> idApartment;
    @FXML
    TableColumn<Apartment, String> idHouseNumber;
    @FXML
    Button btnCreateApartment;



    Apartment apartment;

    @FXML
    private void initialize () {
        apartmentTable.setOnMouseClicked(this::TableClicked);
        id.setCellValueFactory(new PropertyValueFactory<Apartment, Integer>("apartmentId"));
        idApartment.setCellValueFactory(new PropertyValueFactory<Apartment, Integer>("apartmentNo"));
        idHouseNumber.setCellValueFactory(new PropertyValueFactory<Apartment, String>("houseNumber"));
       updateListOfHouses();
       updateListOfApartmentsField();
    }

    private void updateListOfApartmentsField() {
        ObservableList<Apartment> list = FXCollections.observableArrayList(apartRepo.getAllWithHouseNumber());
        apartmentTable.setItems(list);


    }
    //Update Apartmenttextfield with the selected apartmentno picked from the list

    @FXML
    private void TableClicked(MouseEvent event) {
        apartment = apartmentTable.getSelectionModel().getSelectedItem();
        fieldApartments.setText(String.valueOf(apartment.getApartmentNo())); //Konvertera detta till en String.
        HouseChoiceBox.setValue(apartment.getHouseNumber()); //Set housechoicebox to apartment house number

    }

    @FXML
    private void CreateApartment(ActionEvent event) {
        //Textfield and Choicebox can't be empty
        if(!(fieldApartments.getText().length() > 0)) {
            return;
        }
        if(!(HouseChoiceBox.getValue().length() > 0)) {
            return;
        }

        //New apartment instance
        int ID = houseWithId.get(HouseChoiceBox.getValue());

        Apartment tempApart = new Apartment();
        tempApart.setApartmentNo(Integer.parseInt(fieldApartments.getText()));
        tempApart.setHouseId(ID);
        apartRepo.add(tempApart);
        fieldApartments.setText("");
        updateListOfApartmentsField();

    }

    @FXML
    private void DeleteApartment(ActionEvent event) {
        //Check if fields are empty
        if(!(fieldApartments.getText().length() > 0)) {
            return;
        }
        if(!(HouseChoiceBox.getValue().length() > 0)) {
            return;
        }
        //Get the selected item from the Table list
        apartment = apartmentTable.getSelectionModel().getSelectedItem();
        Apartment tempApart = new Apartment(); //Create a temporary apartment model
        tempApart.setApartmentId(apartment.getApartmentId()); //set the apartment id
        apartRepo.remove(tempApart); //Call the remove query on ApartmentRepository
        updateListOfApartmentsField(); //Update the list

    }

    private void updateListOfHouses() {

        //get repository
        HouseRepository hr = new HouseRepository();
        ArrayList<House> HouseArray = hr.getAll();

        //We loop through every houseno in the house hashmap array.
        for(House house : HouseArray) {
            houseWithId.put(house.getHouseNo(), house.getHouseId());
        }

        // To set the items in the choice box:
        ObservableList<String> availableHouseChoices = FXCollections.observableArrayList(houseWithId.keySet());
        HouseChoiceBox.setItems(availableHouseChoices);

    }



    //Go back to home screen
    @FXML
    public void goHome(ActionEvent actionEvent) {

        ViewController.activate("StartView");
    }



}
