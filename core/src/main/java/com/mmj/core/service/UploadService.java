package com.mmj.core.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * 上传图片相关Service
 */
public interface UploadService {

    /**
     * 验证登陆
     * @param file
     * @return
     */
    String uploadImg(MultipartFile file);
}
