package com.tlias.controller;

import com.tlias.pojo.Result;
import com.tlias.pojo.emp;
import com.tlias.service.impl.EmpService;
import com.tlias.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class logInController {
    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody emp emp1){
        log.info("登陆的用户为：{}", emp1);
        emp e = empService.login(emp1);
        if(e != null){
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", e.getId());
            claims.put("username", e.getUsername());
            claims.put("name", e.getName());
            String jwt = JwtUtils.generateJwt(claims);
            return Result.success(jwt);
        }
        else return Result.error("用户名或密码错误");
    }

}
