package com.hjx.system.service;

import com.hjx.common.model.GetEasyUIData;
import com.hjx.system.model.Product;
import com.hjx.system.model.ProductPage;

import java.util.Set;

public interface ProductService {
    void savaOrupdate(Product product);

    GetEasyUIData findTByPage(ProductPage productPage);

    void deleteProduct(Set<Integer> ids);
}
