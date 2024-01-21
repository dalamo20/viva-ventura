package com.vivaventura.database;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class SelectRecord {
    private static final Logger logger = LogManager.getLogger(SelectRecord.class);
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:src/main/resources/sqlite/vivaventura.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            logger.error("Error connecting ", e);
        }
        return conn;
    }

    public void selectAll() {
        try {
            Connection conn = this.connect();
            DatabaseMetaData metaData = conn.getMetaData();
            // Get the list of tables
            ResultSet tables = metaData.getTables(null, null, null, new String[]{"TABLE"});
            while (tables.next()) {
                String tableName = tables.getString("TABLE_NAME");
                logger.info("Table: " + tableName);

                // Get the columns for each table
                ResultSet columns = metaData.getColumns(null, null, tableName, null);
                while (columns.next()) {
                    String columnName = columns.getString("COLUMN_NAME");
                    logger.info(columnName + "\t");
                }
                // Fetch and display data for each table
                selectTable(conn, tableName);
            }

            conn.close();
        } catch (SQLException e) {
            logger.error("Error selecting all tables", e);
        }
    }

    public void selectTable(String tableName) {
        try {
            Connection conn = this.connect();
            selectTable(conn, tableName);
            conn.close();
        } catch (SQLException e) {
            logger.error("Error selecting table: " + tableName, e);
        }
    }

    private void selectTable(Connection conn, String tableName) {
        try {
            String selectQuery = "SELECT * FROM " + tableName;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(selectQuery);

            while (rs.next()) {
                ResultSetMetaData rsMetaData = rs.getMetaData();
                int columnCount = rsMetaData.getColumnCount();

                for (int i = 1; i <= columnCount; i++) {
                    logger.info(rs.getString(i) + "\t");
                }
            }
        } catch (SQLException e) {
            logger.error("Error selecting table: " + tableName, e);
        }
    }
}