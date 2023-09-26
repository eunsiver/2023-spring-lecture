package com.example.springbootlecture.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "log")
@Getter
@NoArgsConstructor
public class Log {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
}
