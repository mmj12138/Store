package com.mmj.core.serviceImpl;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.mmj.core.dao.UserDao;
import com.mmj.core.dto.LoginRequest;
import com.mmj.core.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private UserDao userDao;


    @Override
    public Boolean isLogin(LoginRequest usr) {
        if (!Optional.ofNullable(usr).isPresent()) {
            return false;
        }
        String password = userDao.selectPasswordByEmail(usr.getEmail());
        if (password.equals("-1") || !StringUtils.equals(password, usr.getPassword())) {
            return false;
        }
        return true;
    }
}
