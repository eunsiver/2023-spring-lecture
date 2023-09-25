package com.example.springbootlecture;

import com.example.springbootlecture.Ioc.Chef;
import com.example.springbootlecture.Ioc.IngredientFactory;
import com.example.springbootlecture.config.MyConfig;
import com.example.springbootlecture.config.MyConfigProto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootLectureApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringbootLectureApplication.class, args);
	}
}
