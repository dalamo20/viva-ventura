package com.vivaventura.presentation;

import com.vivaventura.model.domain.Activity;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class AddActivityController {
    @FXML
    private TableColumn<Activity, String> date;

    @FXML
    private TextField dateField;

    @FXML
    private TableView<Activity> listOfActivities;

    @FXML
    private TableColumn<Activity, String> name;

    @FXML
    private TextField nameField;

    @FXML
    private TableColumn<Activity, String> time;

    @FXML
    private TextField timeField;

    @FXML
    private void initialize() {
        //initialize the cell value factories for each column
        name.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        date.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
        time.setCellValueFactory(cellData -> cellData.getValue().timeProperty());
    }

    @FXML
    void addActivity(MouseEvent event) {
        Activity activities = new Activity();
        activities.setName(nameField.getText());
        activities.setDate(dateField.getText());
        activities.setTime(timeField.getText());
        listOfActivities.getItems().add(activities);

        nameField.clear();
        dateField.clear();
        timeField.clear();
    }

    @FXML
    void deleteActivity(MouseEvent event) {
        int selectedIndex = listOfActivities.getSelectionModel().getSelectedIndex();
        listOfActivities.getItems().remove(selectedIndex);
    }
    @FXML
    private void switchToCreateItinerary() throws IOException {
        Driver.setRoot("create_itinerary");
    }
}
