package com.mrs.service;

import com.mrs.entity.Movie;
import com.mrs.entity.Recommendation;
import com.mrs.repository.RecommendationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RecommendationService {
    private final RecommendationRepository recommendationRepository;

    public RecommendationService(RecommendationRepository recommendationRepository) {
        this.recommendationRepository = recommendationRepository;
    }

    public List<Recommendation> getAllRecommendations() {
        return recommendationRepository.findAll();
    }

    public Recommendation getRecommendationById(UUID id) {
        return recommendationRepository.findById(id).orElseThrow(() -> new RuntimeException("Recommendation not found"));
    }

    public List<Recommendation> getRecommendationByUserID(UUID userId){
        List<Recommendation> recommendations = recommendationRepository.findByUserId(userId);
        if(recommendations.isEmpty())throw  new RuntimeException("No recommendations found with the given user");
        return recommendations;
    }

    public Recommendation createRecommendation(Recommendation recommendation) {
        return recommendationRepository.save(recommendation);
    }

    public void deleteRecommendation(UUID id) {
        recommendationRepository.deleteById(id);
    }
}

