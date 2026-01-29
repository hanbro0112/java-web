package com.sky.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Data
@Schema(description = "員工分頁查詢傳輸數據模型")
public class EmployeePageQueryDTO implements Serializable {

    // 模糊查詢姓名
    private String name;

    // 頁碼
    private int page;

    // 每頁顯示記錄數
    private int pageSize;
}
