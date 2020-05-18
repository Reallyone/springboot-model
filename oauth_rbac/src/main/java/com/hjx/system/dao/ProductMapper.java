/**
 * 版权声明： 版权所有 违者必究 2020
*/
package com.hjx.system.dao;

import com.hjx.system.model.Product;
import com.hjx.system.model.ProductPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * 表说明：
 *
 * @since 2020-05-14 02:26:05
 */
@Mapper
@Component("ProductMapper")
public interface ProductMapper  {

    int saveProduct(@Param("p") Product product);

    int updateProduct(@Param("p") Product product);

    List<ProductPage> findTByPage(ProductPage productPage);

    int deleteProduct(Set<Integer> ids);
}