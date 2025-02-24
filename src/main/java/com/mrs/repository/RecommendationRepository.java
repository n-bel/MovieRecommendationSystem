package com.mrs.repository;

import com.mrs.entity.Movie;
import com.mrs.entity.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RecommendationRepository extends JpaRepository<Recommendation, UUID> {

    @Query("SELECT r FROM Recommendation r WHERE r.user.id = :userId")
    List<Recommendation> findByUserId(@Param("userId") UUID UserId);
}

