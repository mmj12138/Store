package com.mmj.app.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mmj.core.dto.LoginRequest;
import com.mmj.core.dto.RegisterRequest;
import com.mmj.core.service.LoginService;

/**
 * 登陆注册相关界面Controller
 */
@RestController
@CrossOrigin
@RequestMapping("/init")
public class LoginController {

    @Resource
    private LoginService loginService;

    /**
     * 登陆验证
     * @param loginRequest
     * @return
     */
    @PostMapping("/login")
    public String login(@RequestBody final LoginRequest loginRequest) {
        return loginService.isLogin(loginRequest);
    }

    /**
     * 注册时获取验证码
     * @param email
     * @return
     */
    @RequestMapping("/getRegisterCode")
    public String getRegisterCode(String email) {
        return loginService.getRegisterCode(email);
    }

    /**
     * 注册
     * @param request
     * @return
     */
    @PostMapping("/register")
    public Boolean register(@RequestBody RegisterRequest request) {
        return loginService.register(request);
    }

    /**
     * 忘记密码时获取验证码
     * @param email
     * @return
     */
    @RequestMapping("/getUpdateCode")
    public String getUpdateCode(String email) {
        return loginService.getUpdateCode(email);
    }

    /**
     * 忘记密码
     * @param loginRequest
     * @return
     */
    @PostMapping("/update")
    public Boolean update(@RequestBody final LoginRequest loginRequest) {
        return loginService.updatePassword(loginRequest);
    }
}
