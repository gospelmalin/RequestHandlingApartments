package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class EditApartmentController {
    @FXML
    private Button goHome;



    //Go back to home screen
    @FXML
    public void goHome(ActionEvent actionEvent) {

        ViewController.activate("StartView");
    }

}
