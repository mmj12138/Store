package com.mmj.core.dao;

import java.util.List;

import javax.annotation.Resource;

import com.mmj.core.mapper.auto.UserLoginMapper;
import com.mmj.core.model.auto.UserLogin;
import com.mmj.core.model.auto.UserLoginExample;
import org.springframework.stereotype.Component;

import com.alibaba.druid.util.StringUtils;

@Component
public class UserDao {

    @Resource
    private UserLoginMapper userMapper;

    /**
     * 通过email查询password 逻辑查询唯一值
     */
    public UserLogin selectPasswordByEmail(String email) {
        UserLoginExample example = new UserLoginExample();
        UserLoginExample.Criteria criteria = example.createCriteria();
        criteria.andEmailEqualTo(email);
        List<UserLogin> userList = userMapper.selectByExample(example);
        if (userList.size() == 0) {
            return null;
        } else {
            return userList.stream().findFirst().get();
        }
    }

    /**
     * 根据coinGoodsNumber修改coinGoodsExtension
     *
     * @param email
     * @param user
     */
    public Boolean updateByEmail(String email, UserLogin user) {
        if (StringUtils.isEmpty(email)) {
            return false;
        }
        UserLoginExample example = new UserLoginExample();
        example.createCriteria().andEmailEqualTo(email);
        //更新数据
        userMapper.updateByExampleSelective(user, example);
        return true;
    }



}
