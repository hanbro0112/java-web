package com.sky.controller.admin;

import com.sky.constant.MessageConstant;
import com.sky.result.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

/**
 * 公共接口
 */
@RestController
@RequestMapping("/admin/common")
@Tag(name = "公共接口")
@Slf4j
public class CommonController {

    private static final String projectUploadPath = System.getProperty("user.dir") + "/sky-take-out/upload";

    @PostMapping("/upload")
    @Operation(summary = "文件上傳")
    public Result<String> upload(MultipartFile file) {
        log.info("文件上傳: {}", file);

        // 文件本地儲存
        try {
            // 原始文件名
            String originalFilename = file.getOriginalFilename();
            // 擷取原始文件名的後綴
            String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
            // 生成新的文件名
            String newFilename = UUID.randomUUID() + extension;

            file.transferTo(new File(projectUploadPath + "/" + newFilename));

            // 文件的請求路徑
            String filePath = "localhost:8080/upload/" + newFilename;
            return Result.success(filePath);
        } catch(Exception e) {
            log.error("文件上傳失敗", e);
            return Result.error(MessageConstant.UPLOAD_FAILED);
        }

    }
}
