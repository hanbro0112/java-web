package com.web.mapper;

import com.web.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 員工管理
 */
@Mapper
public interface EmpMapper {
    /**
     * 統計員工總數
     * @return
     */
    @Select("select count(*) from emp")
    public Long count();

    /**
     * 分頁查詢員工列表數據
     * @param start 起始位置
     * @param pageSize 每頁顯示條數
     * @return
     */
    @Select("select * from emp limit #{start}, #{pageSize}")
    public List<Emp> page(Integer start, Integer pageSize);
}
