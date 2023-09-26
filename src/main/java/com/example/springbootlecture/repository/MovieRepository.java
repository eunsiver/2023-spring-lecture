package com.example.springbootlecture.repository;

import com.example.springbootlecture.domain.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("select distinct m from Movie m left join fetch m.actors a left join m.director d")
    List<Movie> findAllJpqlFetch();

    List<Movie> findByProductionYear(int productionYear);
}
