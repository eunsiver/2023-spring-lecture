package com.example.springbootlecture.service;

import com.example.springbootlecture.domain.entity.Log;
import com.example.springbootlecture.repository.LogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LogService {
    private final LogRepository logRepository;

    /*
    * REQUIRE: 같은 범주에 있는 트랜잭션을 묶어
    * */
    @Transactional(propagation = Propagation.REQUIRES_NEW)//새로운 트랜잭션을 만들겠어
    public void saveLog(){
        logRepository.save(new Log());
    }
}
