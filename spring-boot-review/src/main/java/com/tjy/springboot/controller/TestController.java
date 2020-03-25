package com.tjy.springboot.controller;

import com.tjy.springboot.bean.Emp;
import com.tjy.springboot.bean.Message;
import com.tjy.springboot.entities.Provider;
import com.tjy.springboot.mapper.ProviderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tjy
 * @ClassName TestController
 * @Description TODO
 * @Date 2020/3/24 11:24
 * @Version 1.0
 **/
@Controller
public class TestController {
    @RequestMapping("/ttt")
    public String testUrl(){
        return "test";
    }

    @ResponseBody
    @RequestMapping("/map")
    public Map testMap(){
        Map<Object, Object> map = new HashMap<>();
        map.put(new Emp(), new Message("sdfasdfas",100));
        map.put(new Emp(), new Message("xxxxxx",120));
        map.put("sdfsfd", 123);

        for(Map.Entry<Object, Object> m:map.entrySet()){
            System.out.println(m.getKey()+"+++++"+m.getValue());
        }
        return map;
    }

    @PostMapping("/login")
    public String LoginTest(String username,String password){
        System.out.println(username+":"+password);
        return "test";
    }

    @Autowired
    ProviderMapper mapper;
    @ResponseBody
    @RequestMapping("/get/{pid}")
    public Provider getProviderById(@PathVariable("pid") Integer pid){
        return mapper.getProviderById(pid);
    }

}
