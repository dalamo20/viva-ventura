package com.vivaventura.database;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    private static final Logger logger = LogManager.getLogger(Connect.class);

    public static void connect() {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:src/main/resources/sqlite/vivaventura.db";
            conn = DriverManager.getConnection(url);

            logger.info("Connected to SQLite!");

        } catch (SQLException e) {
            logger.error("Error connecting to SQLite", e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                logger.error("Error closing connection", ex);
            }
        }
    }
}
