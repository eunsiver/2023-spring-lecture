package com.example.springbootlecture.domain.reponse;

import com.example.springbootlecture.domain.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
public class MovieResponse {
    private long id;
    private String name;
    private Integer productionYear;

    /*
    * 정적 팩토리 패턴
    * */
    public static MovieResponse of(Movie movie){
        return new MovieResponse(movie.getId(), movie.getName(), movie.getProductionYear());
    }
}
