package com.tjy.springboot.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;

/**
 * @author tjy
 * @ClassName Emp
 * @Description TODO
 * @Date 2020/3/23 19:27
 * @Version 1.0
 **/
@Component
@PropertySource(value = {"classpath:emp.properties"})
@ConfigurationProperties(prefix = "emp")
@Validated
public class Emp {
//    @Value("${emp.name}")
//    @Email
    private String name;
//    @Value("${emp.age}")
    private Integer age;

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
