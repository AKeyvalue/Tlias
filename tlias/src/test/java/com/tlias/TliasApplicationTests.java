package com.tlias;

import com.alibaba.fastjson.JSONObject;
import com.tlias.controller.DeptController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;



@SpringBootTest
@Test
 class TliasApplicationTests  extends AbstractTestNGSpringContextTests {

    @Autowired
    private ApplicationContext applicationContext;


    @Test
    public void testGetBean(){
        System.out.println(111);
        System.out.println(111);
        System.out.println(111);
        DeptController bean1 = (DeptController)applicationContext.getBean("deptController");
        System.out.println(bean1);
        DeptController bean2 = applicationContext.getBean(DeptController.class);
        System.out.println(bean2);

    }
}
