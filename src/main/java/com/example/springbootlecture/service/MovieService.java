package com.example.springbootlecture.service;

import com.example.springbootlecture.domain.entity.Movie;
import com.example.springbootlecture.domain.reponse.MovieResponse;
import com.example.springbootlecture.domain.request.MovieRequest;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    private final static List<Movie> movies = new ArrayList<>();

    @PostConstruct//MovieService가 생성되면 init()메소드를 실행하라는 어노테이션
    public void init(){
        movies.addAll( List.of(new Movie(1L, "스타워즈", 1977, LocalDateTime.now()),
                new Movie(2L, "아바타", 2009, LocalDateTime.now()),
                new Movie(3L, "인터스텔라", 2014, LocalDateTime.now()),
                new Movie(4L, "인셉션", 2010, LocalDateTime.now()),
                new Movie(5L, "테넷", 2020, LocalDateTime.now())));
    }

    public Movie getMovie(long movieId) {
        return movies.stream()
                .filter(movie -> movie.getId() == movieId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당하는 영화가 없습니다."));
    }

    public List<MovieResponse> getMovies() {
        return movies.stream().map(MovieResponse::of).toList();
    }

    public void createMovie(MovieRequest movieRequest) {
        Movie movie = new Movie(movies.size() + 1, movieRequest.getName(), movieRequest.getProductionYear(), LocalDateTime.now());
        movies.add(movie);
    }

    public void updateMovie(long movieId, MovieRequest movieRequest) {
        Movie movie = getMovie(movieId);
        movie.setName(movieRequest.getName());
        movie.setProductionYear(movieRequest.getProductionYear());
    }

    public void deleteMovie(long movieId) {
        Movie movie = getMovie(movieId);
        movies.remove(movie);
    }
}
