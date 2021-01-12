package com.spring.cloud.server_one;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ServerOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerOneApplication.class, args);
    }

}
