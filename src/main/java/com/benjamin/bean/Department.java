package com.benjamin.bean;

import java.util.List;

/**
 * Created by Ben Li.
 * Date: 2020/5/21
 */
public class Department {
    private Integer id;
    private String dname;

    private List<Employee> employees;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", dname='" + dname + '\'' +
                ", employees=" + employees +
                '}';
    }
}
