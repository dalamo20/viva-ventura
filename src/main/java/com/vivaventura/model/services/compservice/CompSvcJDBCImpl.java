package com.vivaventura.model.services.compservice;

import com.vivaventura.model.domain.Activity;
import com.vivaventura.model.domain.Itinerary;
import com.vivaventura.model.domain.Location;
import com.vivaventura.model.services.exception.CompSvcEx;
import com.vivaventura.database.Connect;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompSvcJDBCImpl implements ICompSvc{
    private final Logger logger = LogManager.getLogger(CompSvcJDBCImpl.class);

    @Override
    public void addItinerary(Itinerary itinerary) throws CompSvcEx {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Connect.getConnection();
            String sql = "INSERT INTO itinerary (name) VALUES (?)";
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, itinerary.getName());
            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating itinerary failed, no rows affected.");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    itinerary.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating itinerary failed, no ID obtained.");
                }
            }

            logger.info("Itinerary added: " + itinerary);
        } catch (SQLException e) {
            logger.error("Error adding itinerary: ", e);
            throw new CompSvcEx("Error adding itinerary", e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                logger.error("Error closing statement or connection: ", ex);
            }
        }
    }


    @Override
    public Itinerary getItinerary(int id) throws CompSvcEx {
        Itinerary itinerary = null;
        try (Connection conn = Connect.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM itinerary WHERE id = ?")) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    itinerary = new Itinerary();
                    itinerary.setId(rs.getInt("id"));
                    itinerary.setName(rs.getString("name"));
                }
            }
        } catch (SQLException e) {
            throw new CompSvcEx("Error fetching itinerary", e);
        }
        if (itinerary == null) {
            throw new CompSvcEx("Itinerary not found with id: " + id);
        }
        return itinerary;
    }


    @Override
    public void updateItinerary(Itinerary itinerary) throws CompSvcEx {
        try (Connection conn = Connect.getConnection();
             PreparedStatement stmt = conn.prepareStatement("UPDATE itinerary SET name = ? WHERE id = ?")) {
            stmt.setString(1, itinerary.getName());
            stmt.setInt(2, itinerary.getId());
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated == 0) {
                throw new CompSvcEx("Itinerary not found for updating");
            }
            logger.info("Itinerary updated: " + itinerary);
        } catch (SQLException e) {
            logger.error("Error updating record in itinerary table ", e);
            throw new CompSvcEx("Error updating record in itinerary table", e);
        }
    }

    @Override
    public void deleteItinerary(int id) throws CompSvcEx {
        try (Connection conn = Connect.getConnection();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM itinerary WHERE id = ?")) {
            stmt.setInt(1, id);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted == 0) {
                throw new CompSvcEx("Itinerary not found for deletion");
            }
            logger.info("Itinerary deleted with id: " + id);
        } catch (SQLException e) {
            logger.error("Error deleting record in itinerary table for id: " + id, e);
            throw new CompSvcEx("Error deleting record in itinerary table", e);
        }
    }

    @Override
    public void addActivity(Activity activity) throws CompSvcEx {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Connect.getConnection();
            String sql = "INSERT INTO activity (name) VALUES (?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, activity.getName());
            stmt.setString(2, activity.getDate());
            stmt.setString(3, activity.getTime());
            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating activity failed, no rows affected.");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    activity.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating activity failed, no ID obtained.");
                }
            }

            logger.info("Activity added: " + activity);
        } catch (SQLException e) {
            logger.error("Error adding activity: ", e);
            throw new CompSvcEx("Error adding activity", e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                logger.error("Error closing statement or connection: ", ex);
            }
        }
    }

    @Override
    public Activity getActivity(int id) throws CompSvcEx {
        Activity activity = null;
        try (Connection conn = Connect.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM activity WHERE id = ?")) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    activity = new Activity();
                    activity.setId(rs.getInt("id"));
                    activity.setName(rs.getString("name"));
                    activity.setDate(rs.getString("date"));
                    activity.setTime(rs.getString("time"));
                }
            }
        } catch (SQLException e) {
            logger.error("Error getting record in activity table for id: " + id, e);
            throw new CompSvcEx("Error getting record in activity table", e);
        }
        return activity;
    }


    @Override
    public void updateActivity(Activity activity) throws CompSvcEx {
        try (Connection conn = Connect.getConnection();
             PreparedStatement stmt = conn.prepareStatement("UPDATE activity SET activity_name = ?, date = ?, time = ? WHERE id = ?")) {
            stmt.setString(1, activity.getName());
            stmt.setString(2, activity.getDate());
            stmt.setString(3, activity.getTime());
            stmt.setInt(4, activity.getId());
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated == 0) {
                throw new CompSvcEx("Activity not found for updating");
            }
            logger.info("Activity updated: " + activity);
        } catch (SQLException e) {
            logger.error("Error updating record in activity table ", e);
            throw new CompSvcEx("Error updating record in activity table", e);
        }
    }

    @Override
    public void deleteActivity(int id) throws CompSvcEx {
        try (Connection conn = Connect.getConnection();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM activity WHERE id = ?")) {
            stmt.setInt(1, id);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted == 0) {
                throw new CompSvcEx("Activity not found for deletion");
            }
            logger.info("Activity deleted with id: " + id);
        } catch (SQLException e) {
            logger.error("Error deleting record in activity table for id: " + id, e);
            throw new CompSvcEx("Error deleting record in activity table", e);
        }
    }

    @Override
    public void addLocation(Location location) throws CompSvcEx {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Connect.getConnection();
            String sql = "INSERT INTO itinerary (name) VALUES (?)";
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, location.getName());
            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating location failed, no rows affected.");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    location.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating location failed, no ID obtained.");
                }
            }

            logger.info("Location added: " + location);
        } catch (SQLException e) {
            logger.error("Error adding location: ", e);
            throw new CompSvcEx("Error adding location", e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                logger.error("Error closing statement or connection: ", ex);
            }
        }
    }

    @Override
    public Location getLocation(int id) throws CompSvcEx {
        Location location = null;
        try (Connection conn = Connect.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM location WHERE id = ?")) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    location = new Location();
                    location.setId(rs.getInt("id"));
                    location.setName(rs.getString("name"));
                    location.setAddress(rs.getString("address"));
                    location.setLatitude(rs.getDouble("latitude"));
                    location.setLongitude(rs.getDouble("longitude"));
                    location.setRating(rs.getFloat("rating"));
                }
            }
        } catch (SQLException e) {
            logger.error("Error getting record in location table for id: " + id, e);
            throw new CompSvcEx("Error getting record in location table", e);
        }
        return null;
    }

    @Override
    public void updateLocation(Location location) throws CompSvcEx {
        try (Connection conn = Connect.getConnection();
             PreparedStatement stmt = conn.prepareStatement("UPDATE location SET location_name = ?, address = ?, latitude = ?, longitude = ?, rating = ? WHERE id = ?")) {
            stmt.setString(1, location.getName());
            stmt.setString(2, location.getAddress());
            stmt.setDouble(3, location.getLatitude());
            stmt.setDouble(4, location.getLongitude());
            stmt.setFloat(5, location.getRating());
            stmt.setInt(6, location.getId());
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated == 0) {
                throw new CompSvcEx("Location not found for updating");
            }
            logger.info("Location updated: " + location);
        } catch (SQLException e) {
            logger.error("Error updating record in location table ", e);
            throw new CompSvcEx("Error updating record in location table", e);
        }
    }

    @Override
    public void deleteLocation(int id) throws CompSvcEx {
        try (Connection conn = Connect.getConnection();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM location WHERE id = ?")) {
            stmt.setInt(1, id);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted == 0) {
                throw new CompSvcEx("Location not found for deletion");
            }
            logger.info("Location deleted with id: " + id);
        } catch (SQLException e) {
            logger.error("Error deleting record in location table for id: " + id, e);
            throw new CompSvcEx("Error deleting record in location table", e);
        }
    }

    @Override
    public List<Itinerary> getAllItineraries() throws CompSvcEx {
        List<Itinerary> allItineraries = new ArrayList<>();
        try (Connection conn = Connect.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM itinerary")) {
            while (rs.next()) {
                Itinerary itinerary = new Itinerary();
                itinerary.setId(rs.getInt("id"));
                itinerary.setName(rs.getString("name"));
                allItineraries.add(itinerary);
            }
        } catch (SQLException e) {
            logger.error("Error getting ALL records in itinerary table ", e);
        }
        return allItineraries;
    }

    @Override
    public List<Activity> getAllActivities() throws CompSvcEx {
        List<Activity> allActivities = new ArrayList<>();
        try  (Connection conn = Connect.getConnection();
              Statement stmt = conn.createStatement();
              ResultSet rs = stmt.executeQuery("SELECT * FROM activity")) {
            while (rs.next()) {
                Activity activity = new Activity();
                activity.setId(rs.getInt("id"));
                activity.setName(rs.getString("name"));
                activity.setDate(rs.getString("date"));
                activity.setTime(rs.getString("time"));
                allActivities.add(activity);
            }
        } catch (SQLException e) {
            logger.error("Error getting ALL records in activity table ", e);        }
        return allActivities;
    }

    @Override
    public List<Location> getAllLocations() throws CompSvcEx {
        List<Location> allLocations = new ArrayList<>();
        try  (Connection conn = Connect.getConnection();
              Statement stmt = conn.createStatement();
              ResultSet rs = stmt.executeQuery("SELECT * FROM location")) {
            while (rs.next()) {
                Location location = new Location();
                location.setId(rs.getInt("id"));
                location.setName(rs.getString("name"));
                location.setAddress(rs.getString("address"));
                location.setLatitude(rs.getDouble("latitude"));
                location.setLongitude(rs.getDouble("longitude"));
                location.setRating(rs.getFloat("rating"));
                allLocations.add(location);
            }
        } catch (SQLException e) {
            logger.error("Error getting ALL records in location table ", e);        }
        return allLocations;
    }
}
