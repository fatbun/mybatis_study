package com.benjamin.dao;

import com.benjamin.bean.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Ben Li.
 * Date: 2020/5/21
 */
public interface EmployeeDao {

    Integer save(Employee department);

    Employee findByIdJoin(Integer id);

    Employee findByIdSelect(Integer id);

    List<Employee> findAll();

    List<Employee> findAllByIf(Employee employee);

    List<Employee> findAllByChoose(Employee employee);

    List<Employee> findAllByTrim(Employee employee);

    List<Employee> findAllByIdForeach(@Param("ids") List<Integer> ids);

    List<Employee> findAllByNameForeach(@Param("names") List<String> names);

}
