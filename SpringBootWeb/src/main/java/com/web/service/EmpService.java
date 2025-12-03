package com.web.service;

import com.web.pojo.PageBean;

public interface EmpService {

    /**
     * 分頁查詢員工數據
     * @param page
     * @param pageSize
     * @return
     */
    PageBean page(Integer page, Integer pageSize);
}
