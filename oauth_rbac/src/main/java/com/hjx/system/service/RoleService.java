package com.hjx.system.service;

import java.util.List;

import com.hjx.common.model.GetEasyUIData;
import com.hjx.common.model.Result;
import com.hjx.system.model.Resources;
import com.hjx.system.model.Role;
import com.hjx.system.model.RoleAddModel;
import com.hjx.system.model.RolePage;
import com.hjx.system.model.RoleResources;
import com.hjx.system.vo.RoleVO;

public interface RoleService {

    void insertRole(RoleAddModel role);

    void updateRole(RoleAddModel role);

    void deleteRole(String[] id);

    GetEasyUIData findTByPage(RolePage role);

    RoleVO selectByPrimaryKey(String id);

    List<Role> selectAll();

    void deleteByT(RoleResources[] r);

    List<Resources> findResourcesByT(Resources resources);

}
