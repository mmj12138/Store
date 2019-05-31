package com.mmj.app.controller;

import com.alibaba.druid.util.StringUtils;
import com.mmj.core.dto.*;
import com.mmj.core.model.auto.SmallKind;
import com.mmj.core.service.SmallService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 大种类管理相关界面Controller
 */
@RestController
@CrossOrigin
@RequestMapping("/small")
public class SmallKindController {

    @Resource
    private SmallService smallService;

    /**
     * 获取列表
     * @return
     */
    @PostMapping("/list")
    public List<SmallKind> list() {
        return smallService.getList();
    }

    /**
     * 获取详情
     * @return
     */
    @RequestMapping("/detail")
    public SmallKind detail(String id) {
        return smallService.getById(StringUtils.stringToInteger(id));
    }

    /**
     * 更新
     * @return
     */
    @RequestMapping("/update")
    public Boolean update(@RequestBody UpdateSmallRequest request) {
        return smallService.update(request);
    }

    /**
     * 删除
     * @return
     */
    @RequestMapping("/delete")
    public Boolean delete(@RequestBody DeleteKindRequest request) {
        return smallService.delete(request);
    }

    /**
     * 更新
     * @return
     */
    @RequestMapping("/save")
    public Boolean save(@RequestBody SaveSmallRequest request) {
        return smallService.save(request);
    }

    /**
     * 获取详情
     * @return
     */
    @RequestMapping("/getlist")
    public List<SmallKind> getList(String id) {
        return smallService.getByBigId(StringUtils.stringToInteger(id));
    }
}
