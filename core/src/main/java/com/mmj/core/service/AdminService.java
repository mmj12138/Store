package com.mmj.core.service;

import com.mmj.core.dto.DeleteAdminRequest;
import com.mmj.core.dto.SaveAdminRequest;
import com.mmj.core.dto.UpdateAdminRequest;
import com.mmj.core.model.auto.AdminMsg;

import java.util.List;

/**
 * 管理员管理相关Service
 */
public interface AdminService {

    /**
     * 获取列表
     * @return
     */
    List<AdminMsg> getList();

    /**
     * 获取详情
     * @param id
     * @return
     */
    AdminMsg getById(Integer id);

    /**
     * 更新
     * @param request
     * @return
     */
    Boolean update(UpdateAdminRequest request);

    /**
     * 删除
     * @param request
     * @return
     */
    Boolean delete(DeleteAdminRequest request);

    /**
     * 新建
     * @param request
     * @return
     */
    Boolean save(SaveAdminRequest request);
}
