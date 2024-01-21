package com.vivaventura.database;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class InsertRecord {
    private static final Logger logger = LogManager.getLogger(InsertRecord.class);

    private Connection connect() {
        //SQLite connection string
        String url = "jdbc:sqlite:src/main/resources/sqlite/vivaventura.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            logger.error("Error connecting", e);
        }
        return conn;
    }

    //Insert record into the itinerary table
    public void insertItinerary(String itineraryName) {
        String sql = "INSERT INTO itinerary(itinerary_name) VALUES(?)";

        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, itineraryName);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error inserting itinerary record", e);
        }
    }

    //Insert record into the activity table
    public void insertActivity(String activityName, String date, String time, int locationId, int itineraryId) {
        String sql = "INSERT INTO activity(activity_name, date, time, location_id, itinerary_id) VALUES(?,?,?,?,?)";
        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, activityName);
            pstmt.setString(2, date);
            pstmt.setString(3, time);
            pstmt.setInt(4, locationId);
            pstmt.setInt(5, itineraryId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error inserting activity record", e);
        }
    }

    //Insert record into the location table
    public void insertLocation(String locationName, String address, double latitude, double longitude, float rating, int itineraryId, int activityId) {
        String sql = "INSERT INTO location(location_name, address, latitude, longitude, rating, itinerary_id, activity_id) VALUES(?,?,?,?,?,?,?)";
        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, locationName);
            pstmt.setString(2, address);
            pstmt.setDouble(3, latitude);
            pstmt.setDouble(4, longitude);
            pstmt.setFloat(5, rating);
            pstmt.setInt(6, itineraryId);
            pstmt.setInt(7, activityId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error inserting location record", e);
        }
    }

    //Insert record into the profile table
    public void insertProfile(String name, String phoneNumber, String location, boolean twoFactorAuthenticationEnabled) {
        String sql = "INSERT INTO profile(name, phone_number, location, two_factor_authentication_enabled) VALUES(?,?,?,?)";
        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, phoneNumber);
            pstmt.setString(3, location);
            pstmt.setBoolean(4, twoFactorAuthenticationEnabled);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error inserting profile record", e);
        }
    }

    //Insert record into the subscription table
    public void insertSubscription(boolean isSubscribed, boolean paymentConfirmed) {
        String sql = "INSERT INTO subscription(is_subscribed, payment_confirmed) VALUES(?,?)";
        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setBoolean(1, isSubscribed);
            pstmt.setBoolean(2, paymentConfirmed);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error inserting subscription record", e);
        }
    }
    //Insert record into the user table
    public void insertUser(String password, String email, String profileName, String profilePhone, String profileLocation, boolean isProfileActive, boolean isSubscriptionActive, String username) {
        //use the helper methods below to create id's for profile and subscription
        int profileId = getProfileId(profileName, profilePhone, profileLocation, isProfileActive);
        int subscriptionId = getSubscriptionId(isSubscriptionActive);

        String sql = "INSERT INTO user(password, email, profile_id, subscription_id, username) VALUES(?,?,?,?,?)";

        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, password);
            pstmt.setString(2, email);
            pstmt.setInt(3, profileId);
            pstmt.setInt(4, subscriptionId);
            pstmt.setString(5, username);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error inserting user record", e);
        }
    }
    //id's were giving issue for profile and subscription
    private int getProfileId(String name, String phoneNumber, String location, boolean isActive) {
        Random rand = new Random();
        return Math.abs(rand.nextInt());
    }

    private int getSubscriptionId(boolean isActive) {
        Random rand = new Random();
        return Math.abs(rand.nextInt());
    }
}
