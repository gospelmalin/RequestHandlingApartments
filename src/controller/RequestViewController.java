package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class RequestViewController {

    @FXML
    private Button goHome;


    @FXML
    public void goHome(ActionEvent actionEvent) {

        ViewController.activate("StartView");
    }
}
