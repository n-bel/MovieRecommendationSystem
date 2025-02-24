package com.mrs.service;

import com.mrs.entity.Movie;
import com.mrs.entity.Review;
import com.mrs.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Review getReviewById(UUID id) {
        return reviewRepository.findById(id).orElseThrow(() -> new RuntimeException("Review not found"));
    }

    public List<Review> getReviewByUserID(UUID userId){
        List<Review> reviews = reviewRepository.findByUserId(userId);
        if(reviews.isEmpty())throw  new RuntimeException("No reviews found with the given user");
        return reviews;
    }

    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    public void deleteReview(UUID id) {
        reviewRepository.deleteById(id);
    }

    public Review updateReview(UUID id, Integer rating, String comment) {
        reviewRepository.findById(id).orElseThrow(() -> new RuntimeException("Review not found"));
        return reviewRepository.save(new Review(id, rating, comment));
    }
}

