package com.benjamin.dao;

import com.benjamin.bean.Department;
import com.benjamin.bean.Employee;

import java.util.List;

/**
 * Created by Ben Li.
 * Date: 2020/5/21
 */
public interface EmployeeDao {

    Integer save(Employee department);

    Employee findById(Integer id);

    List<Employee> findAll();
}
