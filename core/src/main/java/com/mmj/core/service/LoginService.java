package com.mmj.core.service;


import com.mmj.core.dto.LoginRequest;
import com.mmj.core.dto.RegisterRequest;

/**
 * 登陆相关Service
 */
public interface LoginService {

    /**
     * 验证登陆
     * @param usr
     * @return
     */
    Boolean isLogin(LoginRequest usr);

    /**
     * 获取验证码
     * @param email
     * @return
     */
    String getRegisterCode(String email);

    /**
     * 验证注册
     * @param usr
     * @return
     */
    Boolean register(RegisterRequest usr);

    /**
     * 获取验证码
     * @param email
     * @return
     */
    String getUpdateCode(String email);

    /**
     * 获取验证码
     * @param request
     * @return
     */
    Boolean updatePassword(LoginRequest request);
}
