/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.java_crud_application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lapit
 */
public class User_DataAccessObject {
    private Connection connection;
    
    public User_DataAccessObject() throws SQLException {
        connection = DBConnection.getConnection();
    }
    
    public int createUser(User user) throws SQLException {
        String sql = "INSERT INTO users (name, age, emailAddress, password, country) VALUES(?,?,?,?,?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, user.getName());
        stmt.setString(2, user.getAge());
        stmt.setString(3, user.getEmailAddress());
        stmt.setString(4, user.getPassword());
        stmt.setString(5, user.getCountry());
        stmt.executeUpdate();
        return 1;
    }
    
    public void deleteUser(int id) throws SQLException {
        String sql = "DELETE FROM users WHERE id=?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
    }
    
    public List<User> getUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        
        String sql = "Select * FROM users";
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String age = rs.getString("age");
            String emailAddress = rs.getString("emailAddress");
            String password = rs.getString("password");
            String country = rs.getString("country");
        
            users.add(new User(id, name, age, emailAddress, password, country));
        }
        return users;
    }
    
    public int updateUser(User user) throws SQLException {
        String sql = "UPDATE users SET name=?, age=?, emailAddress=?, password=?, country=? WHERE id=?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, user.getName());
        stmt.setString(2, user.getAge());
        stmt.setString(3, user.getEmailAddress());
        stmt.setString(4, user.getPassword());
        stmt.setString(5, user.getCountry());
        stmt.setInt(6, user.getId());
        stmt.executeUpdate();
        return 1;
    }
    
    public User userLogin(String inputEmail, String inputPassword) throws SQLException {
        List<User> users = new ArrayList<>();
        
        String sql = "Select * FROM users";
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String age = rs.getString("age");
            String emailAddress = rs.getString("emailAddress");
            String password = rs.getString("password");
            String country = rs.getString("country");
        
            users.add(new User(id, name, age, emailAddress, password, country));
            
            for (User u: users) {
                if (u.getEmailAddress().equals(inputEmail) && u.getPassword().equals(inputPassword)) {
                    System.out.println("Current Email: " + u.getEmailAddress());
                    return u;
                }
            } 
        }
        return null;
    }
}