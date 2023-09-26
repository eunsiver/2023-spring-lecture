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
    * 별도의 트랜잭션으로 분리해서 rollback이 되어도 log가 실행되도록
    * */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveLog(){
        logRepository.save(new Log());
    }
}
