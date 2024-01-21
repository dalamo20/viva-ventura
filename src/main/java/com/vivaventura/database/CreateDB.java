package com.vivaventura.database;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateDB {
    private static final Logger logger = LogManager.getLogger(CreateDB.class);

    public static void createNewDatabase(String fileName) {

        String url = "jdbc:sqlite:src/main/resources/sqlite/" + fileName;

        try {
            Connection conn = DriverManager.getConnection(url);
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                logger.info("The driver name is " + meta.getDriverName());
                logger.info("Created new db.");
            }
        } catch (SQLException e) {
            logger.error("Error creating database", e);
        }
    }
}
