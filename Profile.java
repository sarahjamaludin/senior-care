package com.example.models;

public class Profile {
    private int id;
    private String name;
    private String email;
    private String contact;
    private String role;
    private String password; // Added password field

    public Profile(int id, String name, String email, String contact, String role, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.role = role;
        this.password = password;
    }

    // Getters and Setters for all fields including password
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
