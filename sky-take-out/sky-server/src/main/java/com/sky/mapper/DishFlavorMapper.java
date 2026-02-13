package com.sky.mapper;

import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DishFlavorMapper {

    /**
     * 批量插入菜品口味數據
     * @param flavors
     */
    void insertBatch(List<DishFlavor> flavors);

    /**
     * 刪除指定菜品 ID 的口味數據
     * @param dishId
     * @return
     */
    void deleteByDishId(Long dishId);

    /**
     * 根據菜品 ID 查詢口味數據
     * @param dishId
     * @return
     */
    List<DishFlavor> getByDishId(Long dishId);
}
