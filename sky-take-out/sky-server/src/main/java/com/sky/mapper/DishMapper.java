package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.enumeration.OperationType;
import com.sky.vo.DishVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DishMapper {

    /**
     * 根據分類 ID 查詢該分類下的菜品數量
     * @param categoryId
     * @return
     */
    Integer countByCategoryId(@Param("categoryId") Long categoryId);

    /**
     * 新增菜品
     * @param dish
     */
    @AutoFill(OperationType.INSERT)
    void insert(Dish dish);

    /**
     * 菜品分頁查詢
     * @param dishPageQueryDTO
     * @return
     */
    Page<DishVO> pageQuery(DishPageQueryDTO dishPageQueryDTO);

    /**
     * 根據 ID 查詢菜品信息
     * @param id
     * @return
     */
    Dish getById(Long id);

    /**
     * 刪除菜品
     * @param id
     */
    void deleteById(Long id);

    /**
     * 更新菜品信息
     * @param dish
     */
    @AutoFill(OperationType.UPDATE)
    void update(Dish dish);

    /**
     * 根據分類 ID 查詢該分類下的菜品列表
     * @param dish
     * @return
     */
    List<Dish> list(Dish dish);

    /**
     * 根據套餐id查詢菜品
     * @param id
     * @return
     */
    List<Dish> getBySetmealId(Long id);
}
