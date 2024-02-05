package com.vivaventura.database;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connect {
    private static final Logger logger = LogManager.getLogger(Connect.class);

    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
            String propLocation = System.getProperty("prop_location");
            logger.debug("Property location: {}", propLocation);

            InputStream inputStream = new FileInputStream(propLocation);
            Properties props = new Properties();
            props.load(inputStream);

            String url = props.getProperty("jdbc.url");
            String user = props.getProperty("jdbc.user");
            String password = props.getProperty("jdbc.password");

            conn = DriverManager.getConnection(url, user, password);

            logger.info("Connected to MySQL!");
        } catch (Exception e) {
            logger.error("Error connecting to MySQL: ", e);
            throw new SQLException("Error connecting to MySQL", e);
        }
        return conn;
    }
}

