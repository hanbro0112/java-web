package com.web.controller;


import com.web.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Slf4j
@RestController
public class UploadController {

    String projectUploadPath = System.getProperty("user.dir") + "/SpringBootWeb/src/main/resources/upload/images";

    @PostMapping("/upload")
    public Result upload(String username, Integer age, MultipartFile image) throws Exception {
        // 本地存儲
        String originalFilename = image.getOriginalFilename();

        log.info("項目上傳路徑: {}", projectUploadPath + "/" + originalFilename);

        image.transferTo(new File(projectUploadPath + "/" + originalFilename));
        return Result.success();
    }
}
