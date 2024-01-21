package com.vivaventura.database;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteRecord {
    private static final Logger logger = LogManager.getLogger(DeleteRecord.class);

    private Connection connect() {
        String url = "jdbc:sqlite:src/main/resources/sqlite/vivaventura.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            logger.error("Error connecting", e);
        }
        return conn;
    }

    public void deleteRecord(int recordId, String tableName) {
        String sql = "DELETE FROM " + tableName + " WHERE id = ?";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, recordId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error deleting record from " + tableName, e);
        }
    }
}
