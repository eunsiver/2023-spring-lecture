package com.example.springbootlecture.shinhan.service;

import com.example.springbootlecture.shinhan.domain.entity.Enterprise;
import com.example.springbootlecture.shinhan.domain.reponse.EnterpriseResponse;
import com.example.springbootlecture.shinhan.domain.request.EnterpriseRequest;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequestMapping
public class ShinhanService {

    private final static List<Enterprise> enterprises= new ArrayList<>();

    @PostConstruct
    public void init(){
        enterprises.addAll(List.of(new Enterprise("두산테스나; 실적 부진 속 다각화 기대","두산스테나","매수","3분기 비용 증가로 영업이익 132억원. 컨센서스 하회 2023년 영업이익률은 17.2%로 전년 대비 7%p 감소 하이엔드 및 차량용","남궁현", LocalDateTime.now())
                ,new Enterprise("현대","현대위아","매수","본업은 자동차...","정용진",LocalDateTime.now())));
    }

    public List<EnterpriseResponse> getEnterprises() {
        return enterprises.stream().map(EnterpriseResponse::of).toList();
    }

    public EnterpriseResponse getEnterprise(long enterpriseId) {
    }

    public void createEnterprise(EnterpriseRequest enterpriseRequest) {
    }

    public void updateEnterprise(long enterpriseId, EnterpriseRequest enterpriseRequest) {
    }

    public void patchEnterprise(long enterpriseId, EnterpriseRequest enterpriseRequest) {
    }

    public void deleteEnterprise(long enterpriseId) {
    }
}
