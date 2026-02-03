package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DishMapper {

    /**
     * 根據分類 ID 查詢該分類下的菜品數量
     * @param categoryId
     * @return
     */
    Integer countByCategoryId(@Param("categoryId") Long categoryId);

}
