package com.example.dao;

import java.sql.*;
import com.example.models.Profile;

public class ProfileDAO {
    private Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/oldies_care_db", "username", "password");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addProfile(Profile profile) {
        try (Connection connection = getConnection()) {
            String query = "INSERT INTO profiles (name, email, contact, role, password) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, profile.getName());
            statement.setString(2, profile.getEmail());
            statement.setString(3, profile.getContact());
            statement.setString(4, profile.getRole());
            statement.setString(5, profile.getPassword());
            statement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public Profile getProfile(int id) {
        Profile profile = null;
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM profiles WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                profile = new Profile(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("email"),
                    resultSet.getString("contact"),
                    resultSet.getString("role"),
                    resultSet.getString("password")
                );
            }
        } catch (SQLException e) {
        }
        return profile;
    }

    public Profile getProfileByEmail(String email) {
        Profile profile = null;
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM profiles WHERE email = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                profile = new Profile(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("email"),
                    resultSet.getString("contact"),
                    resultSet.getString("role"),
                    resultSet.getString("password")
                );
            }
        } catch (SQLException e) {
        }
        return profile;
    }

    public void updateProfile(Profile profile) {
        try (Connection connection = getConnection()) {
            String query = "UPDATE profiles SET name = ?, email = ?, contact = ?, role = ?, password = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, profile.getName());
            statement.setString(2, profile.getEmail());
            statement.setString(3, profile.getContact());
            statement.setString(4, profile.getRole());
            statement.setString(5, profile.getPassword());
            statement.setInt(6, profile.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void deleteProfile(int id) {
        try (Connection connection = getConnection()) {
            String query = "DELETE FROM profiles WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
        }
    }
}
