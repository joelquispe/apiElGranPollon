package com.example.apielgranpollon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;


@SpringBootApplication(scanBasePackages = "com.example")

public class ApiElGranPollonApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiElGranPollonApplication.class, args);
    }

}
