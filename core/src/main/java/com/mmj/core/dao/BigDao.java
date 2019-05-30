package com.mmj.core.dao;

import com.mmj.core.mapper.auto.BigKindMapper;
import com.mmj.core.model.auto.BigKind;
import com.mmj.core.model.auto.BigKindExample;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2019/5/29.
 */
@Component
public class BigDao {

    @Resource
    private BigKindMapper bigKindMapper;

    /**
     * 通过id查询admin逻辑查询唯一值
     */
    public BigKind selectByID(Integer id) {
        BigKindExample example = new BigKindExample();
        BigKindExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        List<BigKind> userList = bigKindMapper.selectByExample(example);
        if (userList.size() == 0) {
            return null;
        } else {
            return userList.stream().findFirst().get();
        }
    }

    /**
     * 通过id删除
     */
    public Boolean deleteById(Integer id) {
        BigKindExample example = new BigKindExample();
        BigKindExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        bigKindMapper.deleteByExample(example);
        return true;
    }

    /**
     * 通过id及实体更新
     */
    public Boolean updateById(Integer id, BigKind bigKind) {
        BigKindExample example = new BigKindExample();
        BigKindExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        bigKindMapper.updateByExampleSelective(bigKind,example);
        return true;
    }
}
