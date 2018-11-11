package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Apartment;
import model.House;
import repository.ApartmentRepository;
import repository.HouseRepository;

import java.util.ArrayList;

public class EditApartmentController {
    ApartmentRepository apart = new ApartmentRepository();
    @FXML
    private Button goHome;
    @FXML
    ChoiceBox<String> HouseChoiceBox;
    @FXML
    TableView<Apartment> districtTable;

    @FXML
    TableColumn<Apartment, Integer> id;
    @FXML
    TableColumn<Apartment, Integer> idApartment;
    @FXML
    TableColumn<Apartment, String> idHouseNumber;


    @FXML
    private void initialize () {
        id.setCellValueFactory(new PropertyValueFactory<Apartment, Integer>("apartmentId"));
        idApartment.setCellValueFactory(new PropertyValueFactory<Apartment, Integer>("apartmentNo"));
        idHouseNumber.setCellValueFactory(new PropertyValueFactory<Apartment, String>("houseId"));
        updateListOfHouses();
        updateListOfApartmentsField();
    }


    private void updateListOfApartmentsField() {
        ObservableList<Apartment> list = FXCollections.observableArrayList(apart.getAll());
        districtTable.setItems(list);

    }



    private void updateListOfHouses() {
        //get repository
        HouseRepository hr = new HouseRepository();

        ArrayList<House> HouseArray = hr.getAll();

        //Create a String arraylist to store the house numbers
        ArrayList<String> getHouseNoList = new ArrayList<String>();

        //We loop through every houseno in the House array.
        for(House house : HouseArray) {
            String grabHouse = house.getHouseNo();//For every object get the house no
            getHouseNoList.add(grabHouse); //Add the ID to the new Integer arraylist
        }

        //To get the items in the choice box:�
        //ObservableList<String> availableChoices1 = addRequestHouseChoiceBox.getItems();

        // To set the items in the choice box:�
        ObservableList<String> availableHouseChoices = FXCollections.observableArrayList(getHouseNoList);
        HouseChoiceBox.setItems(availableHouseChoices);

    }



    //Go back to home screen
    @FXML
    public void goHome(ActionEvent actionEvent) {

        ViewController.activate("StartView");
    }

}
