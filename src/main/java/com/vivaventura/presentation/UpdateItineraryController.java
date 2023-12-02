package com.vivaventura.presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class UpdateItineraryController {
    @FXML
    private TextField itineraryNameField;

    @FXML
    private void switchToViewItineraries() throws IOException {
        Driver.setRoot("view_itineraries");
    }

    public void switchToCreateActivity() {
        //add logic
    }
}
