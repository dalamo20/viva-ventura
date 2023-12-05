package com.vivaventura.presentation;

import com.vivaventura.database.FXtoDBConnect;
import com.vivaventura.model.domain.Activity;
import com.vivaventura.model.domain.Itinerary;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class CreateItineraryController implements Initializable {
    @FXML
    private TableColumn<Itinerary, Integer> col_id;

    @FXML
    private TableColumn<Itinerary, String> col_itineraryName;

    @FXML
    private TextField input_id;

    @FXML
    private TextField input_name;

    @FXML
    private TableView<Itinerary> table_itinerary;

    ObservableList<Itinerary> itineraryList;
    int index = -1;
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

    public void tableRefresh(){
        //setting the cell values to the fields in Itinerary class
        col_id.setCellValueFactory(new PropertyValueFactory<Itinerary, Integer>("id"));
        col_itineraryName.setCellValueFactory(new PropertyValueFactory<Itinerary, String>("name"));

        //calling the getItineraryData method from FXtoDBConnect class to execute SELECT statement on itinerary table
        itineraryList = FXtoDBConnect.getItineraryData();
        //set the observable list in the table view
        table_itinerary.setItems(itineraryList);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableRefresh();
    }

    //select data from itinerary table
    @FXML
    void getItinerary(MouseEvent event){
        index = table_itinerary.getSelectionModel().getSelectedIndex();
        if(index <= -1){
            return;
        }
        //the setText will make the selected row visible in the input fields
        input_id.setText(col_id.getCellData(index).toString());
        input_name.setText(col_itineraryName.getCellData(index).toString());
    }

    public void addItinerary() {
        String sql = "INSERT INTO itinerary(itinerary_name) VALUES(?)";
        try {
            Connection conn = connect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, input_name.getText());
            pstmt.execute();
            conn.close();
            tableRefresh();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteItinerary() {
        String sql = "DELETE FROM itinerary WHERE id = ?";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // set the corresponding param
            pstmt.setString(1, input_id.getText());
            // execute the delete statement
            pstmt.executeUpdate();
            tableRefresh();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateItinerary() {
        String sql = "UPDATE itinerary SET itinerary_name = ? WHERE id = ?";

        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, input_name.getText());
            pstmt.setString(2, input_id.getText());
            pstmt.executeUpdate();
            conn.close();
            tableRefresh();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void switchToAddActivity() throws IOException {
        Driver.setRoot("activities_page");
    }

    @FXML
    void switchToSecondary() throws IOException {
        Driver.setRoot("secondary");
    }

}
