package com.mmj.core.serviceImpl;

import com.mmj.core.dao.BigDao;
import com.mmj.core.dto.DeleteKindRequest;
import com.mmj.core.dto.SaveBigRequest;
import com.mmj.core.dto.UpdateBigRequest;
import com.mmj.core.mapper.auto.BigKindMapper;
import com.mmj.core.model.auto.BigKind;
import com.mmj.core.service.BigService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2019/5/27.
 */
@Service
public class BigServiceImpl implements BigService {

    @Resource
    private BigKindMapper bigKindMapper;

    @Resource
    private BigDao bigDao;

    @Override
    public List<BigKind> getList() {
        return bigKindMapper.selectByExample(null);
    }

    @Override
    public BigKind getById(Integer id) {
        return bigDao.selectByID(id);
    }

    @Override
    public Boolean update(UpdateBigRequest request) {
        BigKind bigKind = new BigKind();
        bigKind.setBigKindName(request.getBigKindName());
        bigKind.setBigKindMsg(request.getBigKindMsg());
        bigKind.setBigKindImg(request.getBigKindImg());
        bigDao.updateById(request.getId(),bigKind);
        return true;
    }

    @Override
    public Boolean delete(DeleteKindRequest request) {
        return bigDao.deleteById(request.getId());
    }

    @Override
    public Boolean save(SaveBigRequest request) {
        BigKind bigKind = new BigKind();
        bigKind.setBigKindName(request.getBigKindName());
        bigKind.setBigKindMsg(request.getBigKindMsg());
        bigKind.setBigKindImg(request.getBigKindImg());
        bigKindMapper.insertSelective(bigKind);
        return true;
    }
}
