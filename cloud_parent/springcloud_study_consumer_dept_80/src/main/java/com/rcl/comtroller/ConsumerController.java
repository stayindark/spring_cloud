package com.rcl.comtroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    private static final String REST_URL_PREFIX="http://STUDY-SPRINGCLOUD-DEPT";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/dept/discovery")
    public Object discovery(){
        return  restTemplate.getForObject(REST_URL_PREFIX+"/dept/discovery",Object.class);
    }
}
