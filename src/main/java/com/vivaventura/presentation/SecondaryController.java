package com.vivaventura.presentation;

import javafx.fxml.FXML;

import java.io.IOException;

public class SecondaryController {
    @FXML
    private void switchToPrimary() throws IOException {
        Driver.setRoot("primary");
    }
}
