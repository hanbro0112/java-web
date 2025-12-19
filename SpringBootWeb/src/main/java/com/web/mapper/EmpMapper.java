package com.web.mapper;

import com.web.pojo.Emp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

/**
 * 員工管理
 */
@Mapper
public interface EmpMapper {

    /**
     * 查詢全部員工數據
     * @return
     */
    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    /**
     * 批量刪除員工數據
     * @param ids
     */
    public void delete(List<Integer> ids);

    /**
     * 添加員工數據
     * @param emp
     */
    @Insert("insert into emp(username, name, gender, job, entry_date, dept_id, create_time, update_time) " +
            " values(#{username}, #{name}, #{gender}, #{job}, #{entryDate}, #{deptId}, #{createTime}, #{updateTime})")
    public void insert(Emp emp);

    /**
     * 根據ID查詢員工數據
     * @param id
     * @return
     */
    @Select("select * from emp where id = #{id}")
    Emp getById(Integer id);

    /**
     * 修改員工數據
     * @param emp
     */
    void update(Emp emp);

    /**
     * 根據用戶名和密碼查詢員工數據
     * @param emp
     * @return
     */
    @Select("select * from emp where username = #{username} and password = #{password}")
    Emp getByUsernameAndPassword(Emp emp);
}
