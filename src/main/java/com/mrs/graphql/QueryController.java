package com.mrs.graphql;

import com.mrs.entity.Movie;
import com.mrs.entity.Recommendation;
import com.mrs.entity.Review;
import com.mrs.entity.User;
import com.mrs.service.MovieService;
import com.mrs.service.RecommendationService;
import com.mrs.service.ReviewService;
import com.mrs.service.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Controller
public class QueryController {
    private final MovieService movieService;
    private final ReviewService reviewService;
    private final RecommendationService recommendationService;
    private final UserService userService;

    public QueryController(MovieService movieService, ReviewService reviewService, RecommendationService recommendationService, UserService userService) {
        this.movieService = movieService;
        this.reviewService = reviewService;
        this.recommendationService = recommendationService;
        this.userService = userService;
    }

    @QueryMapping
    public List<User> users() {
        return userService.getAllUsers();
    }

    @QueryMapping
    public Movie movie(@Argument UUID id) {
        return movieService.getMovieById(id);
    }

    @QueryMapping
    public List<Movie> movies(@Argument String genre, @Argument String title) {
        return movieService.getMovieByGenreAndTitle(genre, title);
    }

    @QueryMapping
    public List<Review> userReviews(@Argument UUID userId) {
        return reviewService.getReviewByUserID(userId);
    }

    @QueryMapping
    public List<Recommendation> movieRecommendations(@Argument UUID userId) {
        return recommendationService.getRecommendationByUserID(userId);
    }

    @MutationMapping
    public Movie addMovie(@Argument String genre, @Argument String title, @Argument String director, @Argument String releaseDate) {
        return movieService.createMovie(new Movie(genre, title, director, releaseDate));
    }

    @MutationMapping
    public Review addReview(@Argument UUID userId, @Argument UUID movieId, @Argument String comment) {
        return reviewService.createReview(new Review(new User(userId), new Movie(movieId), comment));
    }

    @MutationMapping
    public Review updateReview(@Argument UUID id, @Argument Integer rating, @Argument String comment) {
        return reviewService.updateReview(id, rating, comment);
    }

    @MutationMapping
    public Boolean deleteReview(@Argument UUID id) {
        reviewService.deleteReview(id);
        return true;
    }
}

