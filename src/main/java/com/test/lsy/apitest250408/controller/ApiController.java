package com.test.lsy.apitest250408.controller;

import com.test.lsy.apitest250408.dto.response1.Response;
import com.test.lsy.apitest250408.dto.response2.ResponseItem1;
import com.test.lsy.apitest250408.dto.response3.Response3;
import com.test.lsy.apitest250408.dto.response4.ResponseItem2;
import com.test.lsy.apitest250408.dto.response5.ResponseItem5;
import com.test.lsy.apitest250408.service.ApiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@Tag(name = "User API", description = "사용자 관련 API")
public class ApiController {

    private final ApiService service;

    @Operation(summary = "API 호출 1", description = "외부 API 1을 호출하여 사용자 정보 반환")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "정상적으로 사용자 정보를 반환함"),
            @ApiResponse(responseCode = "500", description = "서버 오류 발생")
    })
    @GetMapping("/call-1")
    public Response call1() {
        return service.callApi1();
    }

    @Operation(summary = "API 호출 2", description = "외부 API 2를 호출하여 사용자 리스트 반환")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "정상적으로 사용자 리스트 반환"),
            @ApiResponse(responseCode = "500", description = "서버 오류 발생")
    })
    @GetMapping("/call-2")
    public List<ResponseItem1> call2() {
        return service.callApi2();
    }

    @Operation(summary = "API 호출 3", description = "외부 API 3 호출 결과 객체 반환")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "정상적으로 API 3 결과 반환"),
            @ApiResponse(responseCode = "500", description = "서버 오류 발생")
    })
    @GetMapping("/call-3")
    public Response3 call3() {
        return service.callApi3();
    }

    @Operation(summary = "API 호출 4", description = "외부 API 4 호출 후 리스트 형태 결과 반환")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "정상적으로 API 4 리스트 반환"),
            @ApiResponse(responseCode = "500", description = "서버 오류 발생")
    })
    @GetMapping("/call-4")
    public List<ResponseItem2> call4() {
        return service.callApi4();
    }

    @Operation(summary = "API 호출 5", description = "외부 API 5 호출 후 리스트 형태 결과 반환")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "정상적으로 국가 데이터 반환"),
            @ApiResponse(responseCode = "404", description = "해당 국가 없음"),
            @ApiResponse(responseCode = "502", description = "외부 API 호출 실패")
    })
    @GetMapping("/call-5")
    public List<ResponseItem5> call5(
            @Parameter(description = "도시명 (예: korea, usa)", example = "korea")
            @RequestParam(name = "name",required = true) String name) {
        return service.callApi5(name);
    }

    @Operation(summary = "API 호출 6", description = "외부 API 6 호출 후 DB 저장 처리 수행")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "정상 처리 완료"),
            @ApiResponse(responseCode = "500", description = "서버 오류 발생")
    })
    @PostMapping("/call-6")
    public void call6() {
        service.callApi6();
    }
}
