package com.vivaventura.database;

import java.sql.*;

public class SelectRecord {
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

    public void selectAll() {
        try {
            Connection conn = this.connect();
            DatabaseMetaData metaData = conn.getMetaData();
            // Get the list of tables
            ResultSet tables = metaData.getTables(null, null, null, new String[]{"TABLE"});
            while (tables.next()) {
                String tableName = tables.getString("TABLE_NAME");
                System.out.println("Table: " + tableName);

                // Get the columns for each table
                ResultSet columns = metaData.getColumns(null, null, tableName, null);
                while (columns.next()) {
                    String columnName = columns.getString("COLUMN_NAME");
                    System.out.print(columnName + "\t");
                }
                System.out.println();

                // Fetch and display data for each table
                selectTable(conn, tableName);

                System.out.println();
            }

            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void selectTable(String tableName) {
        try {
            Connection conn = this.connect();
            selectTable(conn, tableName);
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void selectTable(Connection conn, String tableName) throws SQLException {
        // Fetch and display data for the specified table
        String selectQuery = "SELECT * FROM " + tableName;
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(selectQuery);

        // Loop through the result set
        while (rs.next()) {
            ResultSetMetaData rsMetaData = rs.getMetaData();
            int columnCount = rsMetaData.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                System.out.print(rs.getString(i) + "\t");
            }
            System.out.println();
        }
    }
}