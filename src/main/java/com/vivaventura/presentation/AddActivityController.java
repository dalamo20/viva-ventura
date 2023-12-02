package com.vivaventura.presentation;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddActivityController {
    @FXML
    private TextField activityNameField;

    @FXML
    private void createActivity() {
        // Implement logic to create activity and update SQLite database
    }

    @FXML
    private void switchToCreateItinerary() throws IOException {
        Driver.setRoot("create_itinerary");
    }
}
