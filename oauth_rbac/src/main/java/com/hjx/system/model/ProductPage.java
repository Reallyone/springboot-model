/**
 * 版权声明： 版权所有 违者必究 2020
*/
package com.hjx.system.model;

import com.hjx.common.model.Page;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>Table: system_product - </p>
 *
 * @author gaog
 * @since 2020-05-14 02:26:05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "ProductPage", description = "产品分页")
public class ProductPage extends Page implements Serializable {


    /** product_name -  */
    private String productName;

    /** product_type -  相当于是的 */
    private String productType;

    /** product_model -  */
    private String productModel;

    /** product_fuction -  */
    private Integer productFuction;

    /** product_id -  */
    private Integer productId;



}