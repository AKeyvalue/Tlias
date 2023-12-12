package com.tlias.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Slf4j
//@Aspect
public class Aspect2 {
    @Before("com.tlias.aop.Aspect1.as()")
    public void before(){
        log.info("before");
    }
}
