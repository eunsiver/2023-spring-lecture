package com.example.springbootlecture.shinhan.domain.request;

import com.example.springbootlecture.shinhan.domain.entity.Enterprise;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class EnterpriseRequest {
    private String title;
    private String sector;
    private String investment_opinion;
    private String content;
    private String writer;
    private LocalDateTime localDateTime;

    public static EnterpriseRequest of(Enterprise enterprise){
        return new EnterpriseRequest(enterprise.getTitle(), enterprise.getSector(), enterprise.getInvestment_opinion(), enterprise.getContent(), enterprise.getWriter(), enterprise.getLocalDateTime());
    }
}
