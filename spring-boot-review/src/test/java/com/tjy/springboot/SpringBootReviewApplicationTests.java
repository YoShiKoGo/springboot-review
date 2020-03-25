package com.tjy.springboot;

import com.tjy.springboot.bean.Emp;
import com.tjy.springboot.service.EmpService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class SpringBootReviewApplicationTests {

    @Autowired
    Emp emp;
    @Autowired
    ApplicationContext context;

    @Test
    public void contextLoads() {
        System.out.println(emp);
    }

    @Test
    public void test1() {
        EmpService empservice = (EmpService) context.getBean("empService2");
        empservice.add();

    }

    @Test
    public void test2() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy,MM,dd HH,mm,ss");
        Date date = new Date();
        System.out.println(date);
        String format = dateFormat.format(date);
        System.out.println(format);

    }
}
