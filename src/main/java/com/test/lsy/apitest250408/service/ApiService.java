package com.test.lsy.apitest250408.service;

import com.test.lsy.apitest250408.dto.response1.Response;
import com.test.lsy.apitest250408.dto.response2.ResponseItem1;
import com.test.lsy.apitest250408.dto.response3.Response3;
import com.test.lsy.apitest250408.dto.response4.ResponseItem2;
import com.test.lsy.apitest250408.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ApiService {

    private final RestTemplate restTemplate;
    private final UserRepository repository;
    private final UserService userService;

    @Value("${api.url1}")
    private String url1;

    @Value("${api.url2}")
    private String url2;

    @Value("${api.url3}")
    private String url3;

    @Value("${api.url4}")
    private String url4;

    // api 1
    public Response callApi1() {
        Response response = restTemplate.getForObject(url1, Response.class);

        userService.saveUsers(restTemplate.getForObject(url1, Response.class));
        return response;
    }

    // api 2
    public List<ResponseItem1> callApi2() {
        List<ResponseItem1> list = restTemplate.exchange(url2,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ResponseItem1>>() {
                }).getBody();

        userService.saveUsers2(list);
        return list;
    }
    // api 3
    public Response3 callApi3() {
        return restTemplate.getForObject(url3, Response3.class);
    }

    // api 4
    public List<ResponseItem2> callApi4() {
        return restTemplate.exchange(url4,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ResponseItem2>>() {}).getBody();
    }
}
