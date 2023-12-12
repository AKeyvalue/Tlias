package com.tlias.service.impl;

import com.tlias.mapper.DeptMapper;
import com.tlias.mapper.EmpMapper;
import com.tlias.pojo.dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServicelmpl implements DeptService{
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;

    public List<dept> list(){
          return deptMapper.list();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Integer id) {
        deptMapper.delete(id);
        empMapper.deleteByDeptId(id);
    }

    @Override
    public void add(dept dept1) {
        dept1.setCreateTime(LocalDateTime.now());
        dept1.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept1);
    }

    @Override
    public dept select(Integer id) {
        return deptMapper.selectDept(id);
    }

    @Override
    public void update(dept dept2) {
        deptMapper.updateDept(dept2);
    }






}
