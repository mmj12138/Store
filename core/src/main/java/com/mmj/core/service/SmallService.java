package com.mmj.core.service;

import com.mmj.core.dto.*;
import com.mmj.core.model.auto.SmallKind;

import java.util.List;

/**
 * 大种类管理相关Service
 */
public interface SmallService {
    /**
     * 获取列表
     * @return
     */
    List<SmallKind> getList();

    /**
     * 获取详情
     * @param id
     * @return
     */
    SmallKind getById(Integer id);

    /**
     * 获取详情
     * @param id
     * @return
     */
    List<SmallKind> getByBigId(Integer id);

    /**
     * 更新
     * @param request
     * @return
     */
    Boolean update(UpdateSmallRequest request);

    /**
     * 删除
     * @param request
     * @return
     */
    Boolean delete(DeleteKindRequest request);

    /**
     * 新建
     * @param request
     * @return
     */
    Boolean save(SaveSmallRequest request);
}
