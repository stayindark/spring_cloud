package com.rcl.feign;

import com.rcl.entities.DeptEntity;
import com.rcl.service.DeptClientServiceFallBackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(value = "study-springcloud-dept-provider",fallbackFactory = DeptClientServiceFallBackFactory.class)
public interface EurekaServices {

    @GetMapping("/provider/dept/test")
    String test();

    @GetMapping("/provider/dept/{deptNo}")
    DeptEntity findById(@PathVariable Long deptNo);

    @GetMapping("/provider/dept/all")
    List<DeptEntity> findAll();

    @PostMapping("/provider/dept/insert")
    String insert(DeptEntity deptEntity);
}
