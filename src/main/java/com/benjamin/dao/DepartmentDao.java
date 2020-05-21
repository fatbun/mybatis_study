package com.benjamin.dao;

import com.benjamin.bean.Department;

import java.util.List;

/**
 * Created by Ben Li.
 * Date: 2020/5/21
 */
public interface DepartmentDao {

    Integer save(Department department);

    Department findById(Integer id);

    /**
     * 单纯查询departmetn数据
     * 给Employee使用collection的select标签查询
     *
     * @param id
     * @return
     */
    Department findByIdSelect(Integer id);

    List<Department> findAll();
}
