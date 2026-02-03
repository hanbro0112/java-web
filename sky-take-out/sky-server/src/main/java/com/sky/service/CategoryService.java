package com.sky.service;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.result.PageResult;

public interface CategoryService {

    /**
     * 新增分類
     * @param categoryDTO
     */
    void save(CategoryDTO categoryDTO);

    /**
     * 分類分頁查詢
     * @param categoryPageQueryDTO
     * @return
     */
    PageResult pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);

    /**
     * 刪除分類
     * @param id
     */
    void deleteById(Long id);

    /**
     * 修改分類
     * @param categoryDTO
     */
    void update(CategoryDTO categoryDTO);

    /**
     * 啟用禁用分類
     * @param status
     * @param id
     */
    void startOrStop(Integer status, Long id);
}
