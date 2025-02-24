package com.mrs.repository;

import com.mrs.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MovieRepository extends JpaRepository<Movie, UUID> {

    @Query("SELECT m FROM Movie m WHERE m.genre = :genre and m.title = :title")
    List<Movie> findByGenreAndTitle(@Param("genre") String genre, @Param("title") String title);
}

