package com.vivaventura.presentation;

import com.vivaventura.database.FXtoDBConnect;
import com.vivaventura.model.domain.Activity;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class AddActivityController implements Initializable {
    private static final Logger logger = LogManager.getLogger(AddActivityController.class);
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
    private TextField input_filter;

    @FXML
    private TableView<Activity> table_activity;

    ObservableList<Activity> activityList;
    ObservableList<Activity> dataList;

    int index = -1;
    PreparedStatement pstmt = null;

    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:src/main/resources/sqlite/vivaventura.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            logger.error("Error connecting to the database. URL: " + url, e);
        }
        return conn;
    }

    public void tableRefresh(){
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableRefresh();
        searchActivity();
    }

    //select data from the activity table
    @FXML
    void getActivity(MouseEvent event){
        index = table_activity.getSelectionModel().getSelectedIndex();
        if(index <= -1){
            return;
        }
        //the setText will make the selected row visible in the input fields
        input_id.setText(col_id.getCellData(index).toString());
        input_activity.setText(col_activityName.getCellData(index).toString());
        input_date.setText(col_date.getCellData(index).toString());
        input_time.setText(col_time.getCellData(index).toString());
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
            tableRefresh();
            searchActivity();
        } catch (SQLException e) {
            logger.error("Error adding activity ", e);
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
            pstmt.setString(4, input_id.getText());
            pstmt.executeUpdate();
            conn.close();
            tableRefresh();
            searchActivity();
        } catch (SQLException e) {
            logger.error("Error updating activity ", e);
        }
    }

    public void deleteActivity(){
        String sql = "DELETE FROM activity WHERE id = ?";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // set the corresponding param
            pstmt.setString(1, input_id.getText());
            // execute the delete statement
            pstmt.executeUpdate();
            tableRefresh();
            searchActivity();
        } catch (SQLException e) {
            logger.error("Error deleting activity ", e);
        }
    }

    @FXML
    void searchActivity(){
        col_id.setCellValueFactory(new PropertyValueFactory<Activity, Integer>("id"));
        col_activityName.setCellValueFactory(new PropertyValueFactory<Activity, String>("name"));
        col_date.setCellValueFactory(new PropertyValueFactory<Activity, String>("date"));
        col_time.setCellValueFactory(new PropertyValueFactory<Activity, String>("time"));

        dataList = FXtoDBConnect.getActivityData();
        table_activity.setItems(dataList);
        FilteredList<Activity> filterList = new FilteredList<Activity>(dataList, b -> true);
        input_filter.textProperty().addListener((observable, oldValue, newValue) -> {
            filterList.setPredicate(activity -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (activity.getName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    //filter matches name field
                    return true;
                } else if (activity.getDate().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    //filter matches date field
                    return true;
                } else if (activity.getTime().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    //filter matches time field
                    return true;
                } else {
                    //no match
                    return false;
                }
            });
        });

        SortedList<Activity> sortedList = new SortedList<Activity>(filterList);
        sortedList.comparatorProperty().bind(table_activity.comparatorProperty());
        table_activity.setItems(sortedList);
    }

    @FXML
    void switchToItinerary() throws IOException {
        Driver.setRoot("create_itinerary");
    }

}
