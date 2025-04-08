package com.test.lsy.apitest250408.controller;

import com.test.lsy.apitest250408.dto.response1.Response;
import com.test.lsy.apitest250408.service.ApiService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ApiController.class)
@Slf4j
class ApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ApiService apiService;

    @Test
    @DisplayName("GET /call-1 호출 시 200 return 되어야 함")
    void call1() throws Exception {
        // given
        when(apiService.callApi1()).thenReturn(new Response());

        // when
        MvcResult result = mockMvc.perform(get("/call-1"))
                .andExpect(status().isOk())
                .andReturn();

        // then
        String content = result.getResponse().getContentAsString();
        log.info("response : {}", content);
    }
}