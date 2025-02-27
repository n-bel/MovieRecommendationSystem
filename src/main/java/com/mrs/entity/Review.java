package com.mrs.entity;

import jakarta.persistence.*; // Import necessary JPA annotations for persistence

import java.util.UUID;

/**
 * The Review class represents a review for a movie.
 * It is a JPA entity that links a user with a movie and stores their rating and comment.
 */
@Entity // Marks this class as a JPA entity, corresponding to a database table.

@Table(name = "reviews")
public class Review {

    // The 'id' field is the primary key for the 'Review' entity.
    @Id // Specifies that this field is the primary key for the entity.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates the 'id' using the database's identity column (auto-increment).
    private UUID id; // Unique identifier for the review (automatically generated by the database).

    // 'user' represents the user who wrote the review (many reviews can be written by the same user).
    @ManyToOne // Specifies a many-to-one relationship between Review and User (many reviews can belong to one user).
    @JoinColumn(name = "user_id") // Defines the foreign key column that links the 'Review' to the 'User' entity.
    private User user; // Reference to the 'User' entity.

    // 'movie' represents the movie that the review is associated with (many reviews can belong to one movie).
    @ManyToOne// Specifies a many-to-one relationship between Review and Movie (many reviews can belong to one movie).
    @JoinColumn(name = "movie_id") // Defines the foreign key column that links the 'Review' to the 'Movie' entity.
    private Movie movie; // Reference to the 'Movie' entity.

    // 'rating' stores the rating given by the user for the movie (e.g., on a scale of 1 to 5).
    private int rating;

    // 'comment' stores the user's textual review or comment about the movie.
    private String comment;

    public Review(UUID id, User user, Movie movie, String comment) {
        this.id = id;
        this.user = user;
        this.movie = movie;
        this.rating = 0;
        this.comment = comment;
    }

    public Review(User user, Movie movie, String comment) {
        this.user = user;
        this.movie = movie;
        this.rating = 0;
        this.comment = comment;
    }

    public Review(UUID id, Integer rating, String comment) {
        this.id = id;
        this.rating = rating;
        this.comment = comment;
    }

    public Review(){}

    // Getter method for the 'id' field
    public UUID getId() {
        return id; // Returns the unique ID for the review.
    }

    // Getter method for the 'user' field
    public User getUser() {
        return user; // Returns the 'User' who wrote the review.
    }

    // Getter method for the 'movie' field
    public Movie getMovie() {
        return movie; // Returns the 'Movie' associated with the review.
    }

    // Getter method for the 'rating' field
    public int getRating() {
        return rating; // Returns the rating given by the user for the movie.
    }

    // Getter method for the 'comment' field
    public String getComment() {
        return comment; // Returns the comment (review) left by the user.
    }

    // Setter method for the 'id' field
    public void setId(UUID id) {
        this.id = id; // Sets the unique ID for the review.
    }

    // Setter method for the 'user' field
    public void setUser(User user) {
        this.user = user; // Sets the 'User' who wrote the review.
    }

    // Setter method for the 'movie' field
    public void setMovie(Movie movie) {
        this.movie = movie; // Sets the 'Movie' associated with the review.
    }

    // Setter method for the 'rating' field
    public void setRating(Integer rating) {
        this.rating = rating; // Sets the rating given by the user for the movie.
    }

    // Setter method for the 'comment' field
    public void setComment(String comment) {
        this.comment = comment; // Sets the textual comment/review left by the user.
    }
}
