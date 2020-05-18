package com.hjx.system.vo;

import java.util.List;

import com.hjx.system.model.User;
import com.hjx.system.model.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVO extends User {
    private List<UserRole> UserRoleList;
}
