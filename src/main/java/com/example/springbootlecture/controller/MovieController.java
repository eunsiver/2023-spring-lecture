package com.example.springbootlecture.controller;

import com.example.springbootlecture.common.Response;
import com.example.springbootlecture.domain.reponse.MovieResponse;
import com.example.springbootlecture.domain.request.MovieRequest;
import com.example.springbootlecture.service.MovieService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "무비 컨트롤러다")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MovieController {

    private final MovieService movieService;

    @GetMapping("v1/movies/{movieId}")
    public Response<MovieResponse> getMovie(@PathVariable long movieId) {
        return Response.of(movieService.getMovie(movieId));
    }

    @GetMapping("v1/movies")
    public Response<List<MovieResponse>> getMovies() {
        return Response.of(movieService.getMovies());
    }

    @DeleteMapping("v1/movies/{movieId}")
    public void removeMovie(@PathVariable long movieId){
        movieService.removeMovie(movieId);
    }


    @PostMapping("v1/movies")
    public void createMovie(@RequestBody MovieRequest movieRequest){
        movieService.saveMovie(movieRequest);
    }

    @PutMapping("v1/movies/{movieId}")
    public void updateMovie(@PathVariable long movieId, @RequestBody MovieRequest movieRequest){

        movieService.updateMovie(movieId, movieRequest);
    }

}
