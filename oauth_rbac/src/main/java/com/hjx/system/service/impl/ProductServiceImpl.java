package com.hjx.system.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hjx.common.model.GetEasyUIData;
import com.hjx.system.dao.ProductMapper;
import com.hjx.system.model.Product;
import com.hjx.system.model.ProductPage;
import com.hjx.system.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    @Transactional
    public void savaOrupdate(Product product) {

        if (product.getProductId()==null){
            //add
            productMapper.saveProduct(product);
        }else {
            productMapper.updateProduct(product);
        }

    }

    @Override
    public GetEasyUIData findTByPage(ProductPage productPage) {
        Page<Object> objects = PageHelper.startPage(productPage.getPage(), productPage.getRows());
        return new GetEasyUIData(productMapper.findTByPage(productPage)
                , objects.getTotal());
    }

    @Override
    public void deleteProduct(Set<Integer> ids) {
            productMapper.deleteProduct(ids);
    }
}
