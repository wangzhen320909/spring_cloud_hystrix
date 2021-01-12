package com.spring.cloud.hystrix_cinsume.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/find/{id}")
    public String findById(@PathVariable Long id) {
        return restTemplate.getForObject("http://127.0.0.1:3003/simple/" + id, String.class);
    }

    @GetMapping("/getOne/{id}")
    @HystrixCommand(fallbackMethod = "getOneFallBack",
            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")})
    public String getOne(@PathVariable Long id) {
        return restTemplate.getForObject("http://127.0.0.1:3003/simple/" + id, String.class);
    }

    /**
     * 参数跟返回类型必须跟上面的一样，不然会报找不到该方法的错
     */
    public String getOneFallBack(Long id) {
        return "home error";
    }
}
