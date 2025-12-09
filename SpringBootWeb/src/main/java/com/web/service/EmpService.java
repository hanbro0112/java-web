package com.web.service;

import com.web.pojo.Emp;
import com.web.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {

    /**
     * 分頁查詢員工數據
     * @param page
     * @param pageSize
     * @param name
     * @param gender
     * @param begin
     * @param end
     * @return
     */
    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    /**
     * 批量刪除員工
     * @param ids
     */
    void delete(List<Integer> ids);

    /**
     * 添加員工
     * @param emp
     */
    void save(Emp emp);
}
