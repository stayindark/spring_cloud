package com.rcl.controller;

import com.rcl.dao.ProviderDao;
import com.rcl.entities.DeptEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SuppressWarnings("all")
public class ProviderController {

    @Autowired
    private ProviderDao providerDao;

    @GetMapping("/provider/dept/test")
    public String test() {
        return "8001---->success";
    }

    @GetMapping("/provider/dept/{deptNo}")
    public DeptEntity findById(@PathVariable Long deptNo) {
        DeptEntity dept = providerDao.findById(deptNo);
        if (dept == null) {
            throw new RuntimeException("该deptNo没有对应的信息" + deptNo);
        }
        return dept;
    }

    @GetMapping("/provider/dept/all")
    public List<DeptEntity> findAll() {
        List<DeptEntity> deptEntityList = providerDao.findAll();
        if (deptEntityList == null || deptEntityList.size() < 1) {
            throw new RuntimeException("未查询到任何数据");
        }
        return deptEntityList;
    }

    @PostMapping("/provider/dept/insert")
    public String insert(@RequestBody DeptEntity deptEntity) {
        boolean b = providerDao.addDept(deptEntity);
        if (b == false) {
            throw new RuntimeException("添加失败");
        }
        return "添加成功";
    }
}
