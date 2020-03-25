package com.tjy.springboot.config;

import com.tjy.springboot.service.EmpService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tjy
 * @ClassName EmpConfig
 * @Description TODO
 * @Date 2020/3/23 20:48
 * @Version 1.0
 **/
@Configuration
public class EmpConfig {
    @Bean
    public EmpService empService2(){
        System.out.println("EmpService注入");
        return new EmpService();
    }

}
