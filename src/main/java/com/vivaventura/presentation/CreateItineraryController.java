package com.vivaventura.presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class CreateItineraryController {
    @FXML
    private TextField itineraryNameField;

    @FXML
    private ListView<String> listOfItineraries;

    @FXML
    void addItinerary(MouseEvent event) {
        listOfItineraries.getItems().add(itineraryNameField.getText());
    }

    @FXML
    void deleteItinerary(MouseEvent event) {
        int selectedIndex = listOfItineraries.getSelectionModel().getSelectedIndex();
        listOfItineraries.getItems().remove(selectedIndex);
    }

    @FXML
    void switchToAddActivity() throws IOException {
        Driver.setRoot("add_activity");
    }

    @FXML
    void switchToSecondary() throws IOException {
        Driver.setRoot("secondary");
    }
}
