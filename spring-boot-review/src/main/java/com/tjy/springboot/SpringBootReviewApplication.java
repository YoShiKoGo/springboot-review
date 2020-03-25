package com.tjy.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.tjy.springboot.mapper")
@SpringBootApplication
public class SpringBootReviewApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootReviewApplication.class, args);
    }

}
