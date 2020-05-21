package com.hjx.oauth_rbac_redis.system.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hjx.oauth_rbac_redis.commom.model.SuperEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigInteger;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_role")
public class SysRole extends SuperEntity {
    private static final long serialVersionUID = 4497149010220586111L;
    private String code;
    private String name;
}
