package com.mmj.app.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mmj.core.dto.LoginRequest;
import com.mmj.core.service.LoginService;


@RestController
@CrossOrigin
@RequestMapping("/init")
public class LoginController {

    @Resource
    private LoginService loginService;

    @PostMapping("/login")
    public Boolean hello(@RequestBody final LoginRequest loginRequest) {
        return loginService.isLogin(loginRequest);
    }
}
