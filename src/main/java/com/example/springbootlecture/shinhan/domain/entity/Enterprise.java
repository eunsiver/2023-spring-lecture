package com.example.springbootlecture.shinhan.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Enterprise {
    private String title;
    private String sector;
    private String investment_opinion;
    private String content;
    private String writer;
    private LocalDateTime localDateTime;
}
