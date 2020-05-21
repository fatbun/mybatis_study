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

    List<Department> findAll();
}
