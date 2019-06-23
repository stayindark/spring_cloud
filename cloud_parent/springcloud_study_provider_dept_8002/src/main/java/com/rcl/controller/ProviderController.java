package com.rcl.controller;

import com.rcl.dao.DeptDao;
import com.rcl.entities.DeptEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProviderController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private DeptDao deptDao;

    @GetMapping("/dept/discovery")
    public Object discovery(){
        List<String> list = discoveryClient.getServices();
        List<ServiceInstance> instances = discoveryClient.getInstances("STUDY-SPRINGCLOUD-DEPT");

        for (ServiceInstance element :instances){
            System.out.println(element.getServiceId());
            System.out.println(element.getHost());
            System.out.println(element.getPort());
            System.out.println(element.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("/dept/getList")
    public List<DeptEntity> getList(){
        return deptDao.findAll();
    }

}
