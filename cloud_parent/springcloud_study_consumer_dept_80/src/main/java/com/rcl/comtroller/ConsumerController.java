package com.rcl.comtroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    private static final String REST_URL_PREFIX="http://STUDY-SPRINGCLOUD-DEPT-PROVIDER";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/dept/test")
    @LoadBalanced
    public String test(){
        return  restTemplate.getForObject(REST_URL_PREFIX+"/provider/dept/test",String.class);
    }

}
