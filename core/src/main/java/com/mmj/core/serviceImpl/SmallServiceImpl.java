package com.mmj.core.serviceImpl;

import com.mmj.core.dao.SmallDao;
import com.mmj.core.dto.*;
import com.mmj.core.mapper.auto.SmallKindMapper;
import com.mmj.core.model.auto.SmallKind;
import com.mmj.core.service.SmallService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2019/5/27.
 */
@Service
public class SmallServiceImpl implements SmallService {

    @Resource
    private SmallKindMapper smallKindMapper;

    @Resource
    private SmallDao smallDao;

    @Override
    public List<SmallKind> getList() {
        return smallKindMapper.selectByExample(null);
    }

    @Override
    public SmallKind getById(Integer id) {
        return smallDao.selectByID(id);
    }

    @Override
    public List<SmallKind> getByBigId(Integer id) {
        return smallDao.selectByBigID(id);
    }

    @Override
    public Boolean update(UpdateSmallRequest request) {
        SmallKind smallKind = new SmallKind();
        smallKind.setBigId(request.getBigId());
        smallKind.setBigKindName(request.getBigKindName());
        smallKind.setSmallKindName(request.getSmallKindName());
        smallKind.setSmallKindMsg(request.getSmallKindMsg());
        smallKind.setSmallKindImg(request.getSmallKindImg());
        smallDao.updateById(request.getId(),smallKind);
        return true;
    }

    @Override
    public Boolean delete(DeleteKindRequest request) {
        return smallDao.deleteById(request.getId());
    }

    @Override
    public Boolean save(SaveSmallRequest request) {
        SmallKind smallKind = new SmallKind();
        smallKind.setBigId(request.getBigId());
        smallKind.setBigKindName(request.getBigKindName());
        smallKind.setSmallKindName(request.getSmallKindName());
        smallKind.setSmallKindMsg(request.getSmallKindMsg());
        smallKind.setSmallKindImg(request.getSmallKindImg());
        smallKindMapper.insertSelective(smallKind);
        return true;
    }
}
