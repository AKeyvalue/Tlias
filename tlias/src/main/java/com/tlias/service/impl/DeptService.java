package com.tlias.service.impl;

import com.tlias.pojo.dept;

import java.util.List;

public interface DeptService {
    List<dept> list();

    void delete(Integer id);

    void add(dept dept1);

    dept select(Integer id);







    void update(dept dept2);
}
