package com.rcl.service;

import com.rcl.entities.DeptEntity;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author GongXings
 * @createTime 31 14:52
 * @description 统一处理DeptClientService这个类中的熔断
 */
//@Component 不要忘记添加
@Component
public class DeptClientServiceFallBackFactory implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable throwable) {

        return new DeptClientService() {
            @Override
            public String test() {
                return "服务异常";
            }

            @Override
            public DeptEntity findById(Long deptNo) {
                DeptEntity deptEntity = new DeptEntity();
                deptEntity.setDeptNo(deptNo);
                deptEntity.setDeptName("未查询到数据");
                return deptEntity;
            }

            @Override
            public List<DeptEntity> findAll() {
                DeptEntity deptEntity = new DeptEntity();
                deptEntity.setDeptName("未查询到数据");
                List<DeptEntity> list = new ArrayList<>();
                list.add(deptEntity);
                return list;
            }

            @Override
            public String insert(DeptEntity deptEntity) {
                return "添加失败";
            }
        };
    }
}