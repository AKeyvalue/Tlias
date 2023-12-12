package com.tlias.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tlias.mapper.EmpMapper;
import com.tlias.pojo.emp;
import com.tlias.pojo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Service

public class EmpServicelmpl implements EmpService{
    @Autowired
    private EmpMapper empMapper;

//    @Override
//    public PageBean page(Integer page, Integer pageSize) {
//        long count = empMapper.count();
//        Integer start = (page - 1) * pageSize;
//        List<emp> empList = empMapper.page(start, pageSize);
//        return new PageBean(count, empList);
//    }

    public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end){
        PageHelper.startPage(page, pageSize);
        List<emp> empList = empMapper.list(name, gender, begin, end);
        Page<emp> p = (Page<emp>) empList;
        return new PageBean(p.getTotal(), p.getResult());
    }

    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }

    @Override
    public void add(emp emp1) {
        emp1.setCreateTime(LocalDateTime.now());
        emp1.setUpdateTime(LocalDateTime.now());
        empMapper.add(emp1);
    }

    @Override
    public emp getById(Integer id) {
         return empMapper.getById(id);
    }

    @Override
    public void update(emp emp1) {
        emp1.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp1);
    }

    @Override
    public emp login(emp emp1) {
        return empMapper.getByUsernameandPassword(emp1);
    }


}
