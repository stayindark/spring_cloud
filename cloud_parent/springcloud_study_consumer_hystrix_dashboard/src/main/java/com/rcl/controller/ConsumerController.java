package com.rcl.controller;

import com.rcl.entities.DeptEntity;
import com.rcl.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    private static final String REST_URL_PREFIX="http://STUDY-SPRINGCLOUD-DEPT-PROVIDER";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DeptClientService deptClientService;

    @GetMapping(value = "/consumer/dept/test")
    @LoadBalanced
    public String test(){
        return  restTemplate.getForObject(REST_URL_PREFIX+"/provider/dept/test",String.class);
    }

    /*@GetMapping("/consumer/dept/{deptNo}")
    @HystrixCommand(fallbackMethod = "error")
    public DeptEntity findById(@PathVariable Long deptNo){
        DeptEntity forObject = restTemplate.getForObject(REST_URL_PREFIX + "/provider/dept/" + deptNo, DeptEntity.class);
        System.out.println(forObject.toString());
        return forObject;
    }
*/
    /*public DeptEntity error(Long deptNo){
        DeptEntity deptEntity = new DeptEntity();
        deptEntity.setDeptNo(deptNo);
        deptEntity.setDeptName("未查询到数据");
        return deptEntity;
    }*/

    @GetMapping("/consumer/dept/{deptNo}")
    public DeptEntity findById(@PathVariable Long deptNo){

        return deptClientService.findById(deptNo);
    }

}
