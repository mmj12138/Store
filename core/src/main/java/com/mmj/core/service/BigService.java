package com.mmj.core.service;

import com.mmj.core.dto.DeleteKindRequest;
import com.mmj.core.dto.SaveBigRequest;
import com.mmj.core.dto.UpdateBigRequest;
import com.mmj.core.model.auto.BigKind;

import java.util.List;

/**
 * 大种类管理相关Service
 */
public interface BigService {
    /**
     * 获取列表
     * @return
     */
    List<BigKind> getList();

    /**
     * 获取详情
     * @param id
     * @return
     */
    BigKind getById(Integer id);

    /**
     * 更新
     * @param request
     * @return
     */
    Boolean update(UpdateBigRequest request);

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
    Boolean save(SaveBigRequest request);
}
