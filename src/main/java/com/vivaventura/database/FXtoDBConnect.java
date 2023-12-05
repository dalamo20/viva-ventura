package com.vivaventura.database;

import com.vivaventura.model.domain.Activity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class FXtoDBConnect {
    private static Connection connect() {
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

    public static ObservableList<Activity> getActivityData(){
        Connection conn = connect();
        ObservableList<Activity> activityList = FXCollections.observableArrayList();
        String sql = "SELECT * FROM activity";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
//                int id = Integer.parseInt(rs.getString("id"));
//                String name = rs.getString("activity_name");
//                String date = rs.getString("date");
//                String time = rs.getString("time");
//
//                activityList.add(new Activity(id, name, date, time));
                activityList.add(new Activity(Integer.parseInt(rs.getString("id")), rs.getString("activity_name"), rs.getString("date"), rs.getString("time")));
            }
//            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return activityList;
    }
}
