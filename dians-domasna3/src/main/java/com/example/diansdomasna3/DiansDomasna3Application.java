package com.example.diansdomasna3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
public class DiansDomasna3Application {

    public static void main(String[] args) {
        SpringApplication.run(DiansDomasna3Application.class, args);
    }

}
