package com.vivaventura.database;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connect {
    private static final Logger logger = LogManager.getLogger(Connect.class);
    private static final String DB_URL = "jdbc.url";
    private static final String DB_USER = "jdbc.user";
    private static final String DB_PASSWORD = "jdbc.password";
    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            try {
                Properties props = new Properties();
                props.load(Connect.class.getClassLoader().getResourceAsStream("application.properties"));

                connection = DriverManager.getConnection(
                        props.getProperty(DB_URL),
                        props.getProperty(DB_USER),
                        props.getProperty(DB_PASSWORD));
                logger.info("Connected to MySQL!");
            } catch (IOException e) {
                logger.error("Error reading properties file: ", e);
                throw new SQLException("Failed to read properties file");
            } catch (SQLException ex) {
                logger.error("Error connecting to MySQL: ", ex);
                throw new SQLException("MySQL database connection failed");
            }
        }
        return connection;
    }

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
                logger.error("Error closing SQLite connection", ex);
            }
        }
    }

}
