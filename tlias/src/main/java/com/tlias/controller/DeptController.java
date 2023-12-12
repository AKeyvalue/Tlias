package com.tlias.controller;


import com.tlias.anno.Log;
import com.tlias.pojo.Result;
import com.tlias.pojo.dept;
import com.tlias.service.impl.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {
    @Autowired
    private DeptService deptService;

   @GetMapping
    public Result list(){
        log.info("hhhh");
       List<dept> deptList = deptService.list();
       return Result.success(deptList);
    }

    @Log
    @DeleteMapping("{id}")
    public Result delete(@PathVariable Integer id){
       log.info("根据id删除：{}" ,id);
       deptService.delete(id);
        return Result.success();
    }

    @Log
    @PostMapping
    public Result add(@RequestBody dept dept1){
       log.info("新增的部门是{}", dept1);
       deptService.add(dept1);
       return Result.success();
    }

    @GetMapping  ("/{id}")
    public Result select(@PathVariable Integer id){
        log.info("查询的部门id是: {}", id);
        dept dept1 = deptService.select(id);
       return Result.success(dept1);
    }


    @Log
    @PutMapping
    public Result update(@RequestBody dept dept2){
       log.info("change");
       deptService.update(dept2);
       return Result.success();
    }

}

