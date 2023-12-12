package com.tlias.service.impl;

import com.tlias.pojo.PageBean;
import com.tlias.pojo.emp;

import java.time.LocalDate;
import java.util.List;


public interface EmpService {

    PageBean page(Integer page, Integer pageSize, String name,Short gender, LocalDate begin, LocalDate end);

    void delete(List<Integer> ids);

    void add(emp emp1);

    emp getById(Integer id);

    void update(emp emp1);

    emp login(emp emp1);
}
