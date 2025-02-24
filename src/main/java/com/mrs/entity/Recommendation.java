package com.mrs.entity;

import jakarta.persistence.*;

import java.util.UUID;

/**
 * The Recommendation class represents a precomputed movie recommendation for a user.
 * It is a JPA entity that links a user to a recommended movie.
 */
@Entity
@Table(name = "recommendations")
public class Recommendation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id; // Unique identifier for the recommendation

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // The user for whom the recommendation is generated

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie; // The recommended movie

    private Double score; // A ranking score (e.g., relevance, predicted rating)

    // Constructors
    public Recommendation() {}

    public Recommendation(User user, Movie movie, double score) {
        this.user = user;
        this.movie = movie;
        this.score = score;
    }

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
