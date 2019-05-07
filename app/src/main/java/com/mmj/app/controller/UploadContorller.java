package com.mmj.app.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mmj.core.serviceImpl.UploadServiceImpl;

/**
 * 上传图片、文件等相关Controller
 */
@RestController
@CrossOrigin
public class UploadContorller {

    @Resource
    private UploadServiceImpl uploadService;

    @PostMapping("/uploadFile")
    @ResponseBody
    public String uploadFile(MultipartFile file) {
        String path = uploadService.uploadImg(file);
        return path;
    }
}
