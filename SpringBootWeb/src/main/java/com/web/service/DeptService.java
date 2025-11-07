package com.web.service;

import com.web.pojo.Dept;

import java.util.List;

public interface DeptService {
    /**
     * 查詢全部部門數據
     * @return
     */
    List<Dept> list();

    /**
     * 刪除部門數據
     * @param id
     */
    void delete(Integer id);

    /**
     * 添加部門數據
     * @param dept
     *
     */
    void add(Dept dept);
    /**
     * 更新部門數據
     * @param dept
     */
    void update(Dept dept);
}
