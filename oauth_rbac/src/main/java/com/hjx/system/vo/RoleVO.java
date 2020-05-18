package com.hjx.system.vo;

import java.util.List;

import com.hjx.system.model.Role;
import com.hjx.system.model.RoleResources;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleVO extends Role {
    private List<RoleResources> roleResourcesList;
}
