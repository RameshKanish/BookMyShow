package com.example.BookMyShow.repository;

import com.example.BookMyShow.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Integer> {
    // Custom query to find a movie by id where is_deleted is false
    @Query("SELECT m FROM movie m WHERE m.id = :id AND m.isDeleted = false")
    Optional<Movie> findByIdIsDeletedFalse(@Param("id") int movieId);

    // Custom query to get all movies where is_deleted is false
    @Query("SELECT m FROM movie m WHERE m.isDeleted = false")
    List<Movie> findAllIsDeletedFalse();
}