package com.test.lsy.apitest250408;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ApiTest250408Application {

    public static void main(String[] args) {
        SpringApplication.run(ApiTest250408Application.class, args);
    }

}
