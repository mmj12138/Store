package com.mmj.core.dao;

import com.mmj.core.mapper.auto.SmallKindMapper;
import com.mmj.core.model.auto.SmallKind;
import com.mmj.core.model.auto.SmallKindExample;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2019/5/29.
 */
@Component
public class SmallDao {

    @Resource
    private SmallKindMapper smallKindMapper;

    /**
     * 通过id查询admin逻辑查询唯一值
     */
    public SmallKind selectByID(Integer id) {
        SmallKindExample example = new SmallKindExample();
        SmallKindExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        List<SmallKind> userList = smallKindMapper.selectByExample(example);
        if (userList.size() == 0) {
            return null;
        } else {
            return userList.stream().findFirst().get();
        }
    }

    /**
     * 通过bigId查询smallKind逻辑查询唯一值
     */
    public List<SmallKind> selectByBigID(Integer id) {
        SmallKindExample example = new SmallKindExample();
        SmallKindExample.Criteria criteria = example.createCriteria();
        criteria.andBigIdEqualTo(id);
        List<SmallKind> userList = smallKindMapper.selectByExample(example);
        if (userList.size() == 0) {
            return null;
        } else {
            return userList;
        }
    }

    /**
     * 通过id删除
     */
    public Boolean deleteById(Integer id) {
        SmallKindExample example = new SmallKindExample();
        SmallKindExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        smallKindMapper.deleteByExample(example);
        return true;
    }

    /**
     * 通过id及实体更新
     */
    public Boolean updateById(Integer id, SmallKind bigKind) {
        SmallKindExample example = new SmallKindExample();
        SmallKindExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        smallKindMapper.updateByExampleSelective(bigKind,example);
        return true;
    }
}
