package com.vivaventura.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class UpdateRecord {
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

    // Update record in itinerary table
    public void updateItinerary(int id, String newItineraryName) {
        String sql = "UPDATE itinerary SET itinerary_name = ? WHERE id = ?";

        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newItineraryName);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Update record in activity table
    public void updateActivity(int id, String newActivityName, String newDate, String newTime) {
        String sql = "UPDATE activity SET activity_name = ?, date = ?, time = ? WHERE id = ?";

        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newActivityName);
            pstmt.setString(2, newDate);
            pstmt.setString(3, newTime);
            pstmt.setInt(4, id);
            pstmt.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Update record in location table
    public void updateLocation(int id, String newActivityName, String newAddress, Double newLatitude, Double newLongitude, Double newRating) {
        String sql = "UPDATE location SET location_name = ?, address = ?, latitude = ?, longitude = ?, rating = ? WHERE id = ?";
        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newActivityName);
            pstmt.setString(2, newAddress);
            pstmt.setDouble(3, newLatitude);
            pstmt.setDouble(4, newLongitude);
            pstmt.setDouble(5, newRating);
            pstmt.setInt(6, id);
            pstmt.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Update record in profile table
    public void updateProfile(int id, String newName, String newPhone_number, String newLocation, Boolean newTwo_factor_authentication_enabled) {
        String sql = "UPDATE profile SET newName = ?, newPhone_number = ?, newLocation = ?, newTwo_factor_authentication_enabled = ?  WHERE id = ?";

        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newName);
            pstmt.setString(2, newPhone_number);
            pstmt.setString(3, newLocation);
            pstmt.setBoolean(4, newTwo_factor_authentication_enabled);
            pstmt.setInt(5, id);
            pstmt.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Update record in subscription table
    public void updateSubscription(int id, Boolean newIs_subscribed, Boolean newPayment_confirmed) {
        String sql = "UPDATE subscription SET newIs_subscribed = ?, newPayment_confirmed = ? WHERE id = ?";

        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setBoolean(1, newIs_subscribed);
            pstmt.setBoolean(2, newPayment_confirmed);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Update record in activity table
    public void updateUser(int id, String newPassword, String newEmail, String newUsername) {
        String sql = "UPDATE user SET newPassword = ?, email = ?, username = ? WHERE id = ?";

        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newPassword);
            pstmt.setString(2, newEmail);
            pstmt.setString(3, newUsername);
            pstmt.setInt(4, id);
            pstmt.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
