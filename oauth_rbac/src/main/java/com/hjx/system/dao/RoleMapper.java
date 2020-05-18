package com.hjx.system.dao;

import java.util.List;

import com.hjx.system.model.Role;
import com.hjx.system.model.RoleAddModel;
import com.hjx.system.model.RolePage;
import com.hjx.system.vo.RoleVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMapper {

    int deleteByPrimaryKey(String id);

    int insert(Role record);

    Role selectByPrimaryKey(String id);

    List<Role> selectAll();

    int updateByPrimaryKey(Role record);

    List<Role> findTByPage(RolePage role);

    int findTCountByT(RolePage role);

    void deleteBy(String[] id);

    RoleVO selectRoleVOByPrimaryKey(String id);

}