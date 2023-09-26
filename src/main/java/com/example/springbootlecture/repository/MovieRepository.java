package com.example.springbootlecture.repository;

import com.example.springbootlecture.domain.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
