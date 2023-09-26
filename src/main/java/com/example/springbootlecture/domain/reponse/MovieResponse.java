package com.example.springbootlecture.domain.reponse;

import com.example.springbootlecture.domain.entity.Actor;
import com.example.springbootlecture.domain.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
public class MovieResponse {
    private long id;
    private String name;
    private Integer productionYear;
    private String directorName;
    private List<String> actorNames;

    /*
     * 정적 팩토리 패턴
     * */
    public static MovieResponse of(Movie movie) {
        return new MovieResponse(
                movie.getId(),
                movie.getName(),
                movie.getProductionYear(),
                movie.getDirector().getName(),
                movie.getActors().stream().map(Actor::getName).toList());
    }
}
