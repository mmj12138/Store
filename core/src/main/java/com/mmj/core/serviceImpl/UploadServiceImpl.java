package com.mmj.core.serviceImpl;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mmj.core.service.UploadService;

import net.coobird.thumbnailator.Thumbnails;

@Service
public class UploadServiceImpl implements UploadService {

    private static String imageContextPath = "/web/master/dist/img/mm/";

    @Override
    public String uploadImg(MultipartFile file) {
        String fileName = null;
        // 其中contextPath为项目访问根路径，ImageContextPath为自定义图片访问路径
        try {
            fileName = saveFile(imageContextPath, file, file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }

    // 保存图片至本地，relativePath图片相对路径；targetFilePathName服务器图片名称；fielBytes图片字节流
    public String saveFile(String relativePath, MultipartFile file, byte[] fileBytes) throws IOException {
        String SysPath = System.getProperty("user.dir");
        String filePath = SysPath + relativePath + file.getOriginalFilename();
        try {
            file.transferTo(new File(filePath));
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
            return "";
        }
        InputStream ins = new ByteArrayInputStream(fileBytes);
        Thumbnails.of(ins).size(160, 100).toFile(filePath);
        return file.getOriginalFilename();
    }
}
