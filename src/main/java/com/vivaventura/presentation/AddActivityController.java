package com.vivaventura.presentation;

import com.vivaventura.database.FXtoDBConnect;
import com.vivaventura.model.domain.Activity;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class AddActivityController implements Initializable {
    @FXML
    private TableColumn<Activity, String> col_activityName;

    @FXML
    private TableColumn<Activity, String> col_date;

    @FXML
    private TableColumn<Activity, Integer> col_id;

    @FXML
    private TableColumn<Activity, String> col_time;

    @FXML
    private TableView<Activity> table_activity;

    ObservableList<Activity> activityList;

    int index = -1;

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pstmt = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        col_id.setCellValueFactory(new PropertyValueFactory<Activity, Integer>("id"));
        col_activityName.setCellValueFactory(new PropertyValueFactory<Activity, String>("name"));
        col_date.setCellValueFactory(new PropertyValueFactory<Activity, String>("date"));
        col_time.setCellValueFactory(new PropertyValueFactory<Activity, String>("time"));

        activityList = FXtoDBConnect.getActivityData();
        table_activity.setItems(activityList);
    }

}
