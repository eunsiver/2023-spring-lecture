package com.example.springbootlecture.shinhan.domain.reponse;

import com.example.springbootlecture.shinhan.domain.entity.Enterprise;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class EnterpriseResponse {
    private String title;
    private String sector;
    private String investment_opinion;
    private String content;

    public static EnterpriseResponse of(Enterprise enterprise){
        return new EnterpriseResponse(enterprise.getTitle(), enterprise.getSector(), enterprise.getInvestment_opinion(), enterprise.getContent());
    }
}



