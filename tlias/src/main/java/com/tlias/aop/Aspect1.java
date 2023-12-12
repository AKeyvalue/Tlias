package com.tlias.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;



@Component
@Slf4j
//@Aspect
public class Aspect1 {
    @Pointcut("execution(* com.tlias.service.impl.*.*(..))")
    public void as(){};
    @After("as()")
    public void after(){
        log.info("after");
    }
}
