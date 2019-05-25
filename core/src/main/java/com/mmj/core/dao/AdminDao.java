package com.mmj.core.dao;

import com.mmj.core.mapper.auto.AdminMsgMapper;
import com.mmj.core.model.auto.AdminMsg;
import com.mmj.core.model.auto.AdminMsgExample;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2019/5/24.
 */
@Component
public class AdminDao {

    @Resource
    private AdminMsgMapper adminMsgMapper;

    /**
     * 通过id查询admin逻辑查询唯一值
     */
    public AdminMsg selectByID(Integer id) {
        AdminMsgExample example = new AdminMsgExample();
        AdminMsgExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        List<AdminMsg> userList = adminMsgMapper.selectByExample(example);
        if (userList.size() == 0) {
            return null;
        } else {
            return userList.stream().findFirst().get();
        }
    }

    /**
     * 通过id查询admin逻辑查询唯一值
     */
    public Boolean deleteById(Integer id) {
        AdminMsgExample example = new AdminMsgExample();
        AdminMsgExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        adminMsgMapper.deleteByExample(example);
        return true;
    }

    /**
     * 通过id查询admin逻辑查询唯一值
     */
    public Boolean updateById(Integer id, AdminMsg adminMsg) {
        AdminMsgExample example = new AdminMsgExample();
        AdminMsgExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        adminMsgMapper.updateByExampleSelective(adminMsg,example);
        return true;
    }

}
