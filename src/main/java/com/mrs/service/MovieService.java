package com.mrs.service;

import com.mrs.entity.Movie;
import com.mrs.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(UUID id) {
        return movieRepository.findById(id).orElseThrow(() -> new RuntimeException("Movie not found"));
    }

    public List<Movie> getMovieByGenreAndTitle(String genre, String title) {
        List<Movie> movies = movieRepository.findByGenreAndTitle(genre, title);
        if(movies.isEmpty())throw  new RuntimeException("No movies found with the given genre and title");
        return movies;
    }

    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public void deleteMovie(UUID id) {
        movieRepository.deleteById(id);
    }
}
