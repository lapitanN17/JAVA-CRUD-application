/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.java_crud_application;

/**
 *
 * @author lapit
 */
public class User {
    private int id;
    private String name;
    private String age;
    private String emailAddress;
    private String password;
    private String country;
    
    public User(int id, String name, String age, String emailAddress, String password, String country) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.emailAddress = emailAddress;
        this.password = password;
        this.country = country;
    }
    
    //Getters
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getAge() {
         return age;
    }
    
    public String getEmailAddress() {
        return emailAddress;
    }
    
    public String getPassword() {
        return password;
    }
        
    public String getCountry() {
        return country;
    }
    
    //Setters
    public void setId(int id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAge(String age) {
        this.age = age;
    }
    
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    
    public void setPassword(String setPassword) {
        this.password = password;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
}
