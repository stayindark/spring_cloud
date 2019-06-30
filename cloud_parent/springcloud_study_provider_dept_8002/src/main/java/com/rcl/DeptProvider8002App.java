package com.rcl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author GongXings
 * @createTime 30 15:14
 * @description
 */
@SpringBootApplication
@EnableEurekaClient
public class DeptProvider8002App {

    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8002App.class,args);
    }
}