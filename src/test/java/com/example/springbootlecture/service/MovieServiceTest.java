package com.example.springbootlecture.service;

import com.example.springbootlecture.domain.reponse.MovieResponse;
import com.example.springbootlecture.repository.MovieRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MovieServiceTest {

    @Autowired
    private MovieService movieService;

    @Test
    @DisplayName("더하기 테스트")
    void calTest() throws Exception {
        //given
        int a=1;
        int b=3;
        //when
        int sum=a+b;
        //then
        assertEquals(4, sum);
        System.out.println("테스트 완료");
    }

    @BeforeAll
    public static void beforeAll(){
        System.out.println("beforeAll");
    }
    @BeforeEach
    public void beforeEach(){
        System.out.println("beforeEach");
    }
    @AfterAll
    public static void afterAll(){
        System.out.println("afterAll");
    }
    @AfterEach
    public void afterEach(){
        System.out.println("afterEach");
    }
}