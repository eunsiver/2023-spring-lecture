package com.example.springbootlecture.service;


import com.example.springbootlecture.domain.entity.Log;
import com.example.springbootlecture.domain.entity.Movie;
import com.example.springbootlecture.domain.reponse.MovieResponse;
import com.example.springbootlecture.domain.request.MovieRequest;
import com.example.springbootlecture.repository.LogRepository;
import com.example.springbootlecture.repository.MovieRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MovieService {

    //내부 도메인은 repository로
    private final MovieRepository movieRepository;
    //외부 도메인은 service로 분리해주는 것이 layered architecture에 맞다.
    private final LogService logService;
    public MovieResponse getMovie(long movieId) {

        Movie movie = movieRepository.findById(movieId).orElseThrow();
        return MovieResponse.of(movie);
    }

    @Transactional
    public void saveMovie(MovieRequest movieRequest) {

        Movie movie = new Movie(movieRequest.getName(), movieRequest.getProductionYear());

        movieRepository.save(movie);
        logService.saveLog();
        throw new RuntimeException("강제 에러");
    }

//    public List<MovieResponse> getMovies() {
//
//    }
//
//    public void createMovie(MovieRequest movieRequest) {
//
//    }
//
//    public void updateMovie(long movieId, MovieRequest movieRequest) {
//
//    }
//
//    public void deleteMovie(long movieId) {
//     }
}
