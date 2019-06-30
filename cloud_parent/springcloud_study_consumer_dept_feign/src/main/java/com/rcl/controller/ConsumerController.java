package com.rcl.controller;

import com.rcl.entities.DeptEntity;
import com.rcl.feign.EurekaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConsumerController {

    @Autowired
    private EurekaServices eurekaServices;

    @GetMapping(value = "/consumer/dept/test")
    public String test(){
        return eurekaServices.test();
    }

    @GetMapping(value = "/consumer/dept/{deptNo}")
    public DeptEntity findById(@PathVariable Long deptNo){
        return eurekaServices.findById(deptNo);
    }

    @GetMapping(value = "/consumer/dept/all")
    public List<DeptEntity> findAll(){
        return eurekaServices.findAll();
    }

    @PostMapping(value = "/consumer/dept/insert")
    public String insert(@RequestBody DeptEntity deptEntity){
        return eurekaServices.insert(deptEntity);
    }
}
