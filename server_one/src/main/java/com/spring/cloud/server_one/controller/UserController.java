package com.spring.cloud.server_one.controller;

import com.spring.cloud.server_one.demo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/simple/{id}")
    public String findById(@PathVariable Long id) {
        User user = new User();
        user.setAge((short) 12);
        user.setBalance(3000.00);
        user.setId(id);
        user.setName("wzg");
        return user.toString();
    }
}
