package com.example.springbootlecture.shinhan.controller;

import com.example.springbootlecture.shinhan.common.Response;
import com.example.springbootlecture.shinhan.domain.reponse.EnterpriseResponse;
import com.example.springbootlecture.shinhan.domain.request.EnterpriseRequest;
import com.example.springbootlecture.shinhan.service.ShinhanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/shinhan")
@RequiredArgsConstructor
public class ShinhanCotroller {
    private final ShinhanService shinhanService;

    @GetMapping("/v1/enterprises")
    public Response<List<EnterpriseResponse>> getEnterprises() {
        return Response.of(shinhanService.getEnterprises());
    }

    @GetMapping("/v1/enterprises/{enterpriseId}")
    public Response<EnterpriseResponse> getEnterprise(@PathVariable long enterpriseId) {
        return Response.of(shinhanService.getEnterprise(enterpriseId));
    }

    @PostMapping("/v1/enterprises")
    public void createEnterprise(@RequestBody EnterpriseRequest enterpriseRequest) {
        shinhanService.createEnterprise(enterpriseRequest);
    }

    @PutMapping("/v1/enterprises/{enterpriseId}")
    public void updateEnterprise(@PathVariable long enterpriseId, @RequestBody EnterpriseRequest enterpriseRequest) {
        shinhanService.updateEnterprise(enterpriseId, enterpriseRequest);
    }

    @PatchMapping("/v1/enterprises/{enterpriseId}")
    public void patchEnterprise(@PathVariable long enterpriseId, @RequestBody EnterpriseRequest enterpriseRequest) {
        shinhanService.patchEnterprise(enterpriseId, enterpriseRequest);
    }

    @DeleteMapping("/v1/enterprises/{enterpriseId}")
    public void deleteEnterprise(@PathVariable long enterpriseId) {
        shinhanService.deleteEnterprise(enterpriseId);
    }
}
