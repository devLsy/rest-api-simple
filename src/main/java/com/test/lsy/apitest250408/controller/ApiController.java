package com.test.lsy.apitest250408.controller;

import com.test.lsy.apitest250408.dto.response1.Response;
import com.test.lsy.apitest250408.dto.response2.ResponseItem1;
import com.test.lsy.apitest250408.dto.response3.Response3;
import com.test.lsy.apitest250408.dto.response4.ResponseItem2;
import com.test.lsy.apitest250408.service.ApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ApiController {

    private final ApiService service;

    @GetMapping("/call-1")
    public Response call1() {
        return service.callApi1();
    }

    @GetMapping("/call-2")
    public List<ResponseItem1> call2() {
        return service.callApi2();
    }

    @GetMapping("/call-3")
    public Response3 call3() {
        return service.callApi3();
    }

    @GetMapping("/call-4")
    public List<ResponseItem2> call4() {
        return service.callApi4();
    }

    @PostMapping("/call-5")
    public void call5() {
        service.callApi5();
    }
}
