package com.sky.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CategoryPageQueryDTO implements Serializable {

    // 頁碼
    private int page;

    // 每頁顯示條數
    private int pageSize;

    // 分類名稱
    private String name;

    // 分類類型 1 菜品分類 2 套餐分類
    private Integer type;
}
