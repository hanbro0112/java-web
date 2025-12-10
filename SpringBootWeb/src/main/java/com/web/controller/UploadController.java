package com.web.controller;


import com.web.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {

    String projectUploadPath = System.getProperty("user.dir") + "/SpringBootWeb/upload";

    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws Exception {
        // 本地存儲
        String originalFilename = image.getOriginalFilename();
        String uid = UUID.randomUUID().toString();

        String url = projectUploadPath + "/" + uid + "_" + originalFilename;
        log.info("項目上傳路徑: {}", url);

        image.transferTo(new File(url));
        return Result.success(url);
    }
}
