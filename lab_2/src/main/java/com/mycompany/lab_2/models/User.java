package com.mycompany.lab_2.models;

/**
 *
 * @author ezkab
 */
public class User {
    private int id;
    private String name;
    private String username;
    private String password;
    private String role; // "usuario", "admin", "admin supremo"
    private String status; // "activo", "inactivo"
    private String position; // puesto

    // Constructor CORREGIDO
    public User(int id, String name, String username, String password, 
                String role, String status, String position) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.role = role;
        this.status = status;
        this.position = position;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }
}