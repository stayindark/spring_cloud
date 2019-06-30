package com.rcl.config;

import feign.Request;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class FeignConfig {

    /**
     * 建立socket超时时间 读取响应socket超时时间
     * @return
     */

    @Bean
    public Request.Options options(){
        return new Request.Options(12000,12000);
    }

    /**
     * 自定义重试次数
     * @return
     */

    @Bean
    public Retryer feignRetried(){
        return new Retryer.Default(100,TimeUnit.SECONDS.toMillis(1L),5);
    }
}
