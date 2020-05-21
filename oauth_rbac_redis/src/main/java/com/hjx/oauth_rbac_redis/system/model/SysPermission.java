package com.hjx.oauth_rbac_redis.system.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hjx.oauth_rbac_redis.commom.model.SuperEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_permission")
public class SysPermission  extends SuperEntity {

    private static final long serialVersionUID = 749360940290141180L;

    private Long parentId;

    private String name;

    private String css;

    private String url;

    private String path;

    private Integer sort;

    private Integer type;

    private Boolean hidden;

}
