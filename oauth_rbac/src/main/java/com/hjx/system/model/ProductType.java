package com.hjx.system.model;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "productType", description = "产品类别")
public class ProductType {

    private Integer id;

    private String productType;
}
