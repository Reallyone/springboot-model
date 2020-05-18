package com.hjx.system.dao;

import java.util.List;

import com.hjx.system.model.Resources;
import com.hjx.system.model.RoleResources;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleResourcesMapper {
    int deleteByPrimaryKey(String id);

    int insert(RoleResources record);

    RoleResources selectByPrimaryKey(String id);

    List<RoleResources> selectAll();

    int updateByPrimaryKey(RoleResources record);

    void deleteByT(RoleResources[] roleResources);

    List<RoleResources> findTByT(RoleResources roleResources);

    List<Resources> findResourcesByT(Resources resources);
}