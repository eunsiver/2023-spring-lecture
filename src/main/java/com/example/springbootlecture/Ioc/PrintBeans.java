package com.example.springbootlecture.Ioc;

import com.example.springbootlecture.config.MyConfig;
import com.example.springbootlecture.config.MyConfigProto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/*
* 클래스 단위 빈 등록
* */
@Component
@RequiredArgsConstructor
public class PrintBeans {
    private final ApplicationContext applicationContext;
    private final MyConfig myConfig;
    private final MyConfigProto myConfigProto;



    /*
    * 메소드 단위 빈 등록
    * */
    @Bean
      public void printAllBeans() {
        System.out.println(myConfig);
      }
}
