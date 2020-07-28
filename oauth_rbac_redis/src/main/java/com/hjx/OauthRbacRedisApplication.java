package com.hjx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OauthRbacRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(OauthRbacRedisApplication.class, args);
    }

}
