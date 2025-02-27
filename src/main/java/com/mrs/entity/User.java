package com.mrs.entity;

// Importing necessary JPA annotations from Jakarta Persistence API
import jakarta.persistence.*;

import java.util.UUID;

/**
 * The User class represents a user entity in the database.
 * This class is mapped to a table in the database using JPA annotations.
 */
@Entity // Marks this class as a JPA entity, meaning it corresponds to a database table.

@Table(name = "mrs_users")
public class User {

    // The 'id' field is the primary key of the 'User' entity
    @Id // Specifies that this field is the primary key for the entity.
    // Automatically generates the ID value, using the database’s auto-increment feature.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id; // Unique identifier for the user (automatically generated by the database).

    private String username; // Represents the user's username.
    private String email; // Represents the user's email address.
    private String role; // Represents the role of the user (e.g., admin, user).
    private String password; // Represents the user's password.

    public User(UUID id) {
        this.id = id;
    }

    public User(UUID id, String username, String email, String role, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.role = role;
        this.password = password;
    }

    public User() {

    }

    // Getter and Setter methods for the id field
    public UUID getId() {
        return id; // Returns the user's ID
    }

    public void setId(UUID id) {
        this.id = id; // Sets the user's ID
    }

    // Getter and Setter methods for the username field
    public String getUsername() {
        return username; // Returns the user's username
    }

    public void setUsername(String username) {
        this.username = username; // Sets the user's username
    }

    // Getter and Setter methods for the email field
    public String getEmail() {
        return email; // Returns the user's email
    }

    public void setEmail(String email) {
        this.email = email; // Sets the user's email
    }

    // Getter and Setter methods for the role field
    public String getRole() {
        return role; // Returns the user's role (e.g., "admin" or "user")
    }

    public void setRole(String role) {
        this.role = role; // Sets the user's role
    }

    // Getter and Setter methods for the password field
    public String getPassword() {
        return password; // Returns the user's password
    }

    public void setPassword(String password) {
        this.password = password; // Sets the user's password
    }
}
