package com.mmj.app.controller;

import com.alibaba.druid.util.StringUtils;
import com.mmj.core.dto.DeleteKindRequest;
import com.mmj.core.dto.SaveBigRequest;
import com.mmj.core.dto.UpdateBigRequest;
import com.mmj.core.model.auto.BigKind;
import com.mmj.core.service.BigService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 大种类管理相关界面Controller
 */
@RestController
@CrossOrigin
@RequestMapping("/big")
public class BigKindController {

    @Resource
    private BigService bigService;

    /**
     * 获取列表
     * @return
     */
    @PostMapping("/list")
    public List<BigKind> list() {
        return bigService.getList();
    }

    /**
     * 获取详情
     * @return
     */
    @RequestMapping("/detail")
    public BigKind detail(String id) {
        return bigService.getById(StringUtils.stringToInteger(id));
    }

    /**
     * 更新
     * @return
     */
    @RequestMapping("/update")
    public Boolean update(@RequestBody UpdateBigRequest request) {
        return bigService.update(request);
    }

    /**
     * 删除
     * @return
     */
    @RequestMapping("/delete")
    public Boolean delete(@RequestBody DeleteKindRequest request) {
        return bigService.delete(request);
    }

    /**
     * 更新
     * @return
     */
    @RequestMapping("/save")
    public Boolean save(@RequestBody SaveBigRequest request) {
        return bigService.save(request);
    }
}
