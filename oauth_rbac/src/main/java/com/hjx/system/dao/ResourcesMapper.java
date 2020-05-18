package com.hjx.system.dao;

import java.util.List;

import com.hjx.system.model.Resources;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ResourcesMapper {
    int deleteByPrimaryKey(String id);

    int insert(Resources record);

    Resources selectByPrimaryKey(String id);

    List<Resources> selectAll();

    int updateByPrimaryKey(Resources record);

    void deleteBy(String[] id);

}