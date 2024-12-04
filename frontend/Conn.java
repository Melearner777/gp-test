package com.user.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Conn {
    private Connection connection;

    public Conn() {
        this.connection = createConnection();
    }

    private Connection createConnection() {
        String url = "jdbc:mysql://localhost:3306/hotelmanagementsystem";
        String username = "root";
        String password = "802301";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Error connecting to the database.");
        }
        return null;
    }

    public List<Driver> getAllDrivers() {
        List<Driver> drivers = new ArrayList<>();
        String query = "SELECT * FROM Driver";
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
