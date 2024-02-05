package com.vivaventura.database;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class CreateTable {
    private static final Logger logger = LogManager.getLogger(CreateTable.class);
    public static void createNewTable() {
        //SQLite connection string
        String url = "jdbc:sqlite:src/main/resources/sqlite/vivaventura.db";

        //Itinerary table
        String itineraryTable = "CREATE TABLE IF NOT EXISTS itinerary (\n"
                + " id INTEGER PRIMARY KEY,\n"
                + " itinerary_name TEXT NOT NULL,\n"
                + " itinerary_composite_id INTEGER,\n"
                + ");";

        //Activity table
        String activityTableSql = "CREATE TABLE IF NOT EXISTS activity (\n"
                + " id INTEGER PRIMARY KEY,\n"
                + " activity_name TEXT NOT NULL,\n"
                + " date TEXT,\n"
                + " time TEXT,\n"
                + " location_id INTEGER,\n"
                + " itinerary_id INTEGER,\n"
                + " itinerary_composite_id INTEGER,\n"
                + " FOREIGN KEY (location_id) REFERENCES location(id),\n"
                + " FOREIGN KEY (itinerary_id) REFERENCES itinerary(id),\n"
                + " FOREIGN KEY (itinerary_composite_id) REFERENCES itinerary_composite(id)\n"
                + ");";

        //Location table
        String locationTableSql = "CREATE TABLE IF NOT EXISTS location (\n"
                + " id INTEGER PRIMARY KEY,\n"
                + " location_name TEXT NOT NULL,\n"
                + " address TEXT,\n"
                + " latitude REAL,\n"
                + " longitude REAL,\n"
                + " rating REAL,\n"
                + " itinerary_id INTEGER,\n"
                + " activity_id INTEGER,\n"
                + " itinerary_composite_id INTEGER,\n"
                + " FOREIGN KEY (itinerary_id) REFERENCES itinerary(id),\n"
                + " FOREIGN KEY (activity_id) REFERENCES activity(id),\n"
                + " FOREIGN KEY (itinerary_composite_id) REFERENCES itinerary_composite(id)\n"
                + ");";

        //Profile table
        String profileTableSql = "CREATE TABLE IF NOT EXISTS profile (\n"
                + " id INTEGER PRIMARY KEY,\n"
                + " name TEXT NOT NULL,\n"
                + " phone_number TEXT,\n"
                + " location TEXT NOT NULL,\n"
                + " two_factor_authentication_enabled BOOLEAN\n"
                + ");";

        //Subscription table
        String subscriptionTableSql = "CREATE TABLE IF NOT EXISTS subscription (\n"
                + " id INTEGER PRIMARY KEY,\n"
                + " is_subscribed BOOLEAN,\n"
                + " payment_confirmed BOOLEAN\n"
                + ");";

        //User table
        String userTableSql = "CREATE TABLE IF NOT EXISTS user (\n"
                + " id INTEGER PRIMARY KEY,\n"
                + " password TEXT NOT NULL,\n"
                + " email TEXT NOT NULL,\n"
                + " profile_id INTEGER,\n"
                + " subscription_id INTEGER,\n"
                + " username TEXT NOT NULL,\n"
                + " FOREIGN KEY (profile_id) REFERENCES profile(id),\n"
                + " FOREIGN KEY (subscription_id) REFERENCES subscription(id)\n"
                + ");";

        try {
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            stmt.execute(itineraryTable);
            stmt.execute(activityTableSql);
            stmt.execute(locationTableSql);
            stmt.execute(profileTableSql);
            stmt.execute(subscriptionTableSql);
            stmt.execute(userTableSql);
            logger.info("Tables created successfully.");
        } catch (SQLException e) {
            logger.error("Error creating tables ", e);
        }
    }
}