package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CategoryMapper {

    /**
     * 新增分類
     * @param category
     */
    void insert(Category category);

    /**
     * 分類分頁查詢
     * @param categoryPageQueryDTO
     * @return
     */
    Page<Category> pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);

    /**
     * 刪除分類
     * @param id
     */
    void deleteById(Long id);

    /**
     * 修改分類
     * @param category
     */
    void update(Category category);

    /**
     * 根據類型查詢分類
     * @return
     */
    List<Category> list(Integer type);
}
