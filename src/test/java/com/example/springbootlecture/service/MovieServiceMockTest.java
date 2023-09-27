package com.example.springbootlecture.service;

import com.example.springbootlecture.domain.entity.Actor;
import com.example.springbootlecture.domain.entity.Director;
import com.example.springbootlecture.domain.entity.Movie;
import com.example.springbootlecture.domain.reponse.MovieResponse;
import com.example.springbootlecture.repository.MovieRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MovieServiceMockTest {

    @Mock
    private MovieRepository movieRepository;
    @Mock
    private LogService logService;

    /*
    * mock을 movieService에 주입
    * */
    @InjectMocks
    MovieService movieService;

    @Test
    @DisplayName("영화_단건_정상_조회_테스트")
    public void 영화_단건_정상_조회_테스트() throws Exception {
        //given
        int movieId=1;
        Movie movie=new Movie();
        movie.setName("하이");
        movie.setActors(List.of(new Actor()));
        movie.setDirector(new Director());
        //when
        when(movieRepository.findById(anyLong())).thenReturn(Optional.of(movie));
        //then
        MovieResponse movieResponse = movieService.getMovie(movieId);
        assertNotNull(movieResponse);
    }
    @Test
    @DisplayName("영화 단건 조회 테스트")
    public void 영화_단건조회_불가_테스트() throws Exception {
        //given
        int movieId=1;
        Movie movie=new Movie();
        movie.setName("하이");
        movie.setActors(List.of(new Actor()));
        movie.setDirector(new Director());
        //when
        when(movieRepository.findById(anyLong())).thenReturn(null);
        //then
        assertThrows(NullPointerException.class, () -> movieService.getMovie(movieId));
    }

    @Test
    @DisplayName("영화 리스트 조회 테스트")
    void getMovieListTest() throws Exception {

        //given
        Movie movie1 = new Movie();
        movie1.setName("Movie 1");
        movie1.setActors(List.of(new Actor()));
        movie1.setDirector(new Director());

        Movie movie2 = new Movie();
        movie2.setName("Movie 2");
        movie2.setActors(List.of(new Actor()));
        movie2.setDirector(new Director());

        List<Movie> movies = Stream.of(movie1, movie2).collect(Collectors.toList());

        //when
        when(movieRepository.findByProductionYear(2020)).thenReturn(movies);

        //then
        List<MovieResponse> movieResponses = movieService.getMovies();
        assertEquals(2, movieResponses.size());
        assertEquals("Movie 1", movieResponses.get(0).getName());
        assertEquals("Movie 2", movieResponses.get(1).getName());

    }


}
