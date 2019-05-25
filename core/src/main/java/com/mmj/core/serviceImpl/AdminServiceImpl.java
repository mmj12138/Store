package com.mmj.core.serviceImpl;

import com.mmj.core.dao.AdminDao;
import com.mmj.core.dto.DeleteAdminRequest;
import com.mmj.core.dto.SaveAdminRequest;
import com.mmj.core.dto.UpdateAdminRequest;
import com.mmj.core.mapper.auto.AdminMsgMapper;
import com.mmj.core.model.auto.AdminMsg;
import com.mmj.core.model.auto.AdminMsgExample;
import com.mmj.core.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2019/5/24.
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminMsgMapper adminMsgMapper;

    @Resource
    private AdminDao adminDao;

    @Override
    public List<AdminMsg> getList() {
        return adminMsgMapper.selectByExample(null);
    }

    @Override
    public AdminMsg getById(Integer id) {
        AdminMsg result = adminDao.selectByID(id);
        return result;
    }

    @Override
    public Boolean update(UpdateAdminRequest request) {
        AdminMsg adminMsg = new AdminMsg();
        adminMsg.setAdminName(request.getName());
        adminMsg.setSex(request.getSex());
        adminMsg.setUsername(request.getUsername());
        adminMsg.setPassword(request.getPassword());
        adminMsg.setTelephone(request.getTelephone());
        adminMsg.setEmail(request.getEmail());
        adminMsg.setLevel(request.getLevel());
        adminDao.updateById(request.getId(),adminMsg);
        return true;
    }

    @Override
    public Boolean delete(DeleteAdminRequest request) {
        return adminDao.deleteById(request.getId());
    }

    @Override
    public Boolean save(SaveAdminRequest request) {
        AdminMsg adminMsg = new AdminMsg();
        adminMsg.setAdminName(request.getName());
        adminMsg.setSex(request.getSex());
        adminMsg.setUsername(request.getUsername());
        adminMsg.setPassword(request.getPassword());
        adminMsg.setTelephone(request.getTelephone());
        adminMsg.setEmail(request.getEmail());
        adminMsg.setLevel(request.getLevel());
        adminMsgMapper.insertSelective(adminMsg);
        return true;
    }
}
