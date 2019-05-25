package com.mmj.app.controller;

import com.alibaba.druid.util.StringUtils;
import com.mmj.core.dto.DeleteAdminRequest;
import com.mmj.core.dto.SaveAdminRequest;
import com.mmj.core.dto.UpdateAdminRequest;
import com.mmj.core.model.auto.AdminMsg;
import com.mmj.core.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2019/5/24.
 */
/**
 * 管理员管理相关界面Controller
 */
@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private AdminService adminService;

    /**
     * 获取列表
     * @return
     */
    @PostMapping("/list")
    public List<AdminMsg> list() {
        return adminService.getList();
    }

    /**
     * 获取列表
     * @return
     */
    @RequestMapping("/detail")
    public AdminMsg detail(String id) {
        return adminService.getById(StringUtils.stringToInteger(id));
    }

    /**
     * 更新管理者
     * @return
     */
    @RequestMapping("/update")
    public Boolean update(@RequestBody UpdateAdminRequest request) {
        return adminService.update(request);
    }

    /**
     * 删除管理者
     * @return
     */
    @RequestMapping("/delete")
    public Boolean delete(@RequestBody DeleteAdminRequest request) {
        return adminService.delete(request);
    }

    /**
     * 更新管理者
     * @return
     */
    @RequestMapping("/save")
    public Boolean save(@RequestBody SaveAdminRequest request) {
        return adminService.save(request);
    }
}
