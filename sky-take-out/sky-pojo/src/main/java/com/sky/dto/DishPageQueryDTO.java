package com.sky.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class DishPageQueryDTO implements Serializable {

    private int page;

    private int pageSize;

    private String name;

    // 分類id
    private Integer categoryId;

    // 狀態 0:禁用 1:啟用
    private Integer status;
}
