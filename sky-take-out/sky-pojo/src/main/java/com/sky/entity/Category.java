package com.sky.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    // 類型 1 菜品分類 2 套餐分類
    private Integer type;

    // 分類名稱
    private String name;

    // 排序
    private Integer sort;

    // 分類狀態 0 停用 1 啟用
    private Integer status;

    // 創建時間
    private LocalDateTime createTime;

    // 更新時間
    private LocalDateTime updateTime;

    // 創建人
    private Long createUser;

    // 修改人
    private Long updateUser;
}
