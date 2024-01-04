package com.vivaventura.presentation;

import javafx.fxml.FXML;

import java.io.IOException;

public class PrimaryController {
    @FXML
    private void switchToSecondary() throws IOException {
        Driver.setRoot("secondary");
    }
}
