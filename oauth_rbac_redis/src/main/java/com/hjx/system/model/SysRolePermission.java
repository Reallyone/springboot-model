package com.hjx.system.model;


import com.baomidou.mybatisplus.annotation.TableName;
import com.hjx.commom.model.SuperEntity;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("t_role_permission")
public class SysRolePermission  extends SuperEntity {

    private Long roleId;

    private Long permissionId;

}
