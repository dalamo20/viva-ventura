package com.vivaventura.presentation;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.io.IOException;

public class ViewItinerariesController {
    @FXML
    private ListView<String> itineraryListView;

    @FXML
    private void switchToCreateItinerary() throws IOException {
        Driver.setRoot("create_itinerary");
    }

    // Add logic to initialize and populate the ListView with itinerary names
}
