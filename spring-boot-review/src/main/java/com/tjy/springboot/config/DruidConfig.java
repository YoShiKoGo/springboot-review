package com.tjy.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tjy
 * @ClassName DruidConfig
 * @Description 绑定Druid相关信息
 * @Date 2020/1/7 23:00
 * @Version 1.0
 **/
@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid() {
        return new DruidDataSource();
    }

    /**
     * 配置Druid监控
     * 1、配置一个Druid后台 管理servlet
     * 2、配置一个Druid的filter
     */

    //1、配置一个Druid后台 管理servlet
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");

        Map<String, String> initParameter = new HashMap<>();

        initParameter.put(StatViewServlet.PARAM_NAME_USERNAME, "root");
        initParameter.put(StatViewServlet.PARAM_NAME_PASSWORD, "root");
        //不写则所有ip可以访问
        initParameter.put(StatViewServlet.PARAM_NAME_ALLOW, "");
        initParameter.put(StatViewServlet.PARAM_NAME_DENY, "192.168.10.1");

        bean.setInitParameters(initParameter);
        return bean;
    }

    //2、配置一个Druid的filter
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new WebStatFilter());
        Map<String, String> initPrams = new HashMap<>();
        initPrams.put(WebStatFilter.PARAM_NAME_EXCLUSIONS, "*.js,*.css,/druid/*");
        bean.setInitParameters(initPrams);

        //设置拦截请求
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }

}
