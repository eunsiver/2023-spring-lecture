package com.example.springbootlecture.service;

import com.example.springbootlecture.domain.entity.Movie;
import com.example.springbootlecture.domain.reponse.MovieResponse;
import com.example.springbootlecture.domain.request.MovieRequest;
import com.example.springbootlecture.repository.MovieRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MovieService {

    /*
    * 내부 도메인은 repository로
    * 외부 도메인은 service로 분리해주는 것이 layered architecture에 맞다.
    * */
    private final MovieRepository movieRepository;
    private final LogService logService;

    public MovieResponse getMovie(long movieId) {

        Movie movie = movieRepository.findById(movieId).orElseThrow();
        return MovieResponse.of(movie);
    }

    public List<MovieResponse> getMovies(){
        List<Movie> movies = movieRepository.findByProductionYear(2020);
        return movies.stream().map(MovieResponse::of).toList();
    }

    @Transactional
    public void saveMovie(MovieRequest movieRequest) {

        Movie movie = new Movie(movieRequest.getName(), movieRequest.getProductionYear());

        movieRepository.save(movie);
        logService.saveLog();
    }

    @Transactional
    public void updateMovie(long movieId, MovieRequest movieRequest) {
        Movie movie = movieRepository.findById(movieId).orElseThrow();
        movie.setName("변경1");
    }

    @Transactional
    public void removeMovie(long movieId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow();
        movieRepository.delete(movie);
    }

}
