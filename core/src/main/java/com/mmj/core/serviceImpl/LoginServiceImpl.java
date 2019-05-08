package com.mmj.core.serviceImpl;

import java.util.Date;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.mmj.core.dao.UserDao;
import com.mmj.core.dto.LoginRequest;
import com.mmj.core.dto.RegisterRequest;
import com.mmj.core.mapper.auto.UserMapper;
import com.mmj.core.model.auto.User;
import com.mmj.core.service.LoginService;
import com.mmj.inf.enums.ContentEnums;
import com.mmj.inf.util.MailOperationUtil;

@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private UserDao userDao;

    @Resource
    private UserMapper userMapper;


    @Override
    public String isLogin(LoginRequest usr) {
        if (!Optional.ofNullable(usr).isPresent()) {
            return "-1";
        }
        User user = userDao.selectPasswordByEmail(usr.getEmail());
        if (!Optional.ofNullable(user).isPresent() || !StringUtils.equals(user.getPassword(), usr.getPassword())) {
            return "-1";
        }
        return user.getNickName();
    }

    @Override
    public String getRegisterCode(String email) {
        if (StringUtils.isEmpty(email)) {
            return "请输入您的邮箱";
        }
        User user = userDao.selectPasswordByEmail(email);
        if(!Optional.ofNullable(user).isPresent()) {
            try {
                return MailOperationUtil.sendMail(email, ContentEnums.REGISTER.getSubject(), ContentEnums.REGISTER.getDisplay());
            } catch (Exception e) {
                e.printStackTrace();
                return "0";
            }
        }
        return "1";

    }

    @Override
    public Boolean register(RegisterRequest usr) {
        User selectUser = userDao.selectPasswordByEmail(usr.getEmail());
        if(!Optional.ofNullable(selectUser).isPresent()) {
            return false;
        }
        User user = new User();
        user.setNickName(usr.getNickName());
        user.setEmail(usr.getEmail());
        user.setPassword(usr.getPassword());
        user.setUserType(false);
        userMapper.insertSelective(user);
        return true;
    }

    @Override
    public String getUpdateCode(String email) {
        if (StringUtils.isEmpty(email)) {
            return "请输入您的邮箱";
        }
        User user = userDao.selectPasswordByEmail(email);
        if(!Optional.ofNullable(user).isPresent()) {
            try {
                return MailOperationUtil.sendMail(email, ContentEnums.UPDATE.getSubject(),
                                                  ContentEnums.UPDATE.getDisplay());
            } catch (Exception e) {
                e.printStackTrace();
                return "0";
            }
        }
        return "1";
    }

    @Override
    public Boolean updatePassword(LoginRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        Boolean flag = userDao.updateByEmail(request.getEmail(), user);
        if (flag) {
            return true;
        }
        return false;
    }
}
