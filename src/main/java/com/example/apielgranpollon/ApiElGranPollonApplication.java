package com.example.apielgranpollon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;

@Configuration
@EnableJpaRepositories
@SpringBootApplication(scanBasePackages = "com.example")

public class ApiElGranPollonApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiElGranPollonApplication.class, args);
    }

}
