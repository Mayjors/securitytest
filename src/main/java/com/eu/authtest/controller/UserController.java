package com.eu.authtest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuanjie
 * @date 2019/1/30 16:35
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public String getUsers() {
        return "Hello Spring Security";
    }
}
