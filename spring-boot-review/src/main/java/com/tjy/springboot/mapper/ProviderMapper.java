package com.tjy.springboot.mapper;

import com.tjy.springboot.entities.Provider;
import org.apache.ibatis.annotations.Select;

/**
 * @author tjy
 * @ClassName ProviderMapper
 * @Description TODO
 * @Date 2020/3/24 15:13
 * @Version 1.0
 **/
public interface ProviderMapper {

    @Select("select * from provider where pid=#{pid}")
    Provider getProviderById(Integer pid);
}
