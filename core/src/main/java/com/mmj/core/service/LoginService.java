package com.mmj.core.service;


import com.mmj.core.dto.LoginRequest;

/**
 * 登陆相关Service
 */
public interface LoginService {

    /**
     *
     */
    Boolean isLogin(LoginRequest usr);
}
