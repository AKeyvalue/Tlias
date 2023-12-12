package com.tlias.controller;


import com.tlias.anno.Log;
import com.tlias.pojo.Result;
import com.tlias.pojo.PageBean;
import com.tlias.pojo.emp;
import com.tlias.service.impl.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {


    @Autowired
    private EmpService empService;

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
        log.info("分页查询: 参数{}, {}, {}, {}", name, gender, begin, end);
        PageBean pagebean = empService.page(page, pageSize, name, gender, begin, end);
        return Result.success(pagebean);
    }


    @Log
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("删除员工的id为：{}",ids);
        empService.delete(ids);
        return Result.success();

    }


    @Log
    @PostMapping
    public Result add(@RequestBody emp emp1){
        log.info("新增的员工是: {}", emp1);
        empService.add(emp1);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("查寻的员工的id是：{}",id);
        emp emp1 =empService.getById(id);
        return Result.success(emp1);
    }


    @Log
    @PutMapping
    public Result update(@RequestBody emp emp1){
        log.info("修改的员工是: {}", emp1);
        empService.update(emp1);
        return Result.success();
    }

}
