package com.mmj.core.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.alibaba.druid.util.StringUtils;
import com.mmj.core.mapper.auto.UserMapper;
import com.mmj.core.model.auto.User;
import com.mmj.core.model.auto.UserExample;

@Component
public class UserDao {

    @Resource
    private UserMapper userMapper;

    /**
     * 通过email查询password 逻辑查询唯一值
     */
    public String selectPasswordByEmail(String email) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andEmailEqualTo(email);
        List<User> userList = userMapper.selectByExample(example);
        if (userList.size() == 0) {
            return "-1";
        } else {
            return userList.stream().findFirst().get().getPassword();
        }
    }

    /**
     * 根据coinGoodsNumber修改coinGoodsExtension
     *
     * @param email
     * @param user
     */
    public Boolean updateByEmail(String email, User user) {
        if (StringUtils.isEmpty(email)) {
            return false;
        }
        UserExample example = new UserExample();
        example.createCriteria().andEmailEqualTo(email);
        //更新数据
        userMapper.updateByExampleSelective(user, example);
        return true;
    }



}
