package com.user.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class User {

    private Connection connection;

    // Constructor to initialize the database connection
    public User() {
        this.connection = createConnection();
    }

    // Method to create and return a JDBC connection
    private Connection createConnection() {
        String url = "jdbc:mysql://localhost:3306/hms"; 
        String username = "root"; 
        String password = "@avengers1234COC"; 
        
        try {
            // Register the JDBC driver (for MySQL)
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Create and return the connection
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method to retrieve all drivers with additional data from other tables (e.g., Car, Location, etc.)
    public List<Driver> getAllDriversWithAdditionalData() {
        List<Driver> drivers = new ArrayList<>();
        String query = "SELECT d.id, d.name, d.age, d.gender, d.company, d.car_brand, d.availability, d.location, " +
                       "c.car_model, l.city FROM Driver d " +
                       "JOIN Car c ON d.car_brand = c.car_brand " +
                       "JOIN Location l ON d.location = l.location_name";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                drivers.add(new Driver(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getString("gender"),
                    rs.getString("company"),
                    rs.getString("car_brand"),
                    rs.getString("availability"),
                    rs.getString("location")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return drivers;
    }

    // Method to add a new driver (no changes needed for multiple tables)
    public boolean addDriver(Driver driver) {
        String query = "INSERT INTO Driver (name, age, gender, company, car_brand, availability, location) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, driver.getName());
            ps.setInt(2, driver.getAge());
            ps.setString(3, driver.getGender());
            ps.setString(4, driver.getCompany());
            ps.setString(5, driver.getCarBrand());
            ps.setString(6, driver.getAvailability());
            ps.setString(7, driver.getLocation());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Method to retrieve a driver by ID
    public Driver getDriverById(int id) {
        String query = "SELECT * FROM Driver WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Driver(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getString("gender"),
                    rs.getString("company"),
                    rs.getString("car_brand"),
                    rs.getString("availability"),
                    rs.getString("location")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method to update driver information (no changes needed for multiple tables)
    public boolean updateDriver(Driver driver) {
        String query = "UPDATE Driver SET name = ?, age = ?, gender = ?, company = ?, car_brand = ?, availability = ?, location = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, driver.getName());
            ps.setInt(2, driver.getAge());
            ps.setString(3, driver.getGender());
            ps.setString(4, driver.getCompany());
            ps.setString(5, driver.getCarBrand());
            ps.setString(6, driver.getAvailability());
            ps.setString(7, driver.getLocation());
            ps.setInt(8, driver.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Method to delete a driver by ID (no changes needed for multiple tables)
    public boolean deleteDriver(int id) {
        String query = "DELETE FROM Driver WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Method to close the connection
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
