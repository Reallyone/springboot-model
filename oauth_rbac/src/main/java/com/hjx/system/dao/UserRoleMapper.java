package com.hjx.system.dao;

import java.util.List;

import com.hjx.system.model.User;
import com.hjx.system.model.UserRole;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserRole record);

    UserRole selectByPrimaryKey(String id);

    List<UserRole> selectAll();

    int updateByPrimaryKey(User record);

    void deleteByT(UserRole[] u);

    List<UserRole> findTByT(UserRole userRole);
}