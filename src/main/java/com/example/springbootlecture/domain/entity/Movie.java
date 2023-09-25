package com.example.springbootlecture.domain.entity;

import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {

    private long id;
    private String name;
    private Integer productionYear;
    private LocalDateTime createdAt;
}