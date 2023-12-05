package com.vivaventura.presentation;

import com.vivaventura.database.Connect;
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
import java.sql.*;
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
    private TextField input_activity;

    @FXML
    private TextField input_date;

    @FXML
    private TextField input_time;

    @FXML
    private TextField input_id;

    @FXML
    private TableView<Activity> table_activity;

    ObservableList<Activity> activityList;

    int index = -1;

    ResultSet rs = null;
    PreparedStatement pstmt = null;

    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:src/main/resources/sqlite/vivaventura.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //setting the cell values to the fields in Activity class
        col_id.setCellValueFactory(new PropertyValueFactory<Activity, Integer>("id"));
        col_activityName.setCellValueFactory(new PropertyValueFactory<Activity, String>("name"));
        col_date.setCellValueFactory(new PropertyValueFactory<Activity, String>("date"));
        col_time.setCellValueFactory(new PropertyValueFactory<Activity, String>("time"));

        //calling the getActivityData method from FXtoDBConnect class to execute SELECT statement on activity table
        activityList = FXtoDBConnect.getActivityData();
        //set the observable list in the table view
        table_activity.setItems(activityList);
    }

    public void addActivity() {
        String sql = "INSERT INTO activity(activity_name, date, time) VALUES(?,?,?)";
        try {
            Connection conn = connect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, input_activity.getText());
            pstmt.setString(2, input_date.getText());
            pstmt.setString(3, input_time.getText());
            pstmt.execute();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateActivity(){
        String sql = "UPDATE activity SET activity_name = ?, date = ?, time = ? WHERE id = ?";

        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, input_activity.getText());
            pstmt.setString(2, input_date.getText());
            pstmt.setString(3, input_time.getText());
            pstmt.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
