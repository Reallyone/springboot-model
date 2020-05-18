package com.hjx.system.controller;

import com.hjx.common.model.CodeEnum;
import com.hjx.common.model.Result;
import com.hjx.common.util.StringUtils;
import com.hjx.system.model.Product;
import com.hjx.system.model.ProductPage;
import com.hjx.system.model.Resources;
import com.hjx.system.model.UserPage;
import com.hjx.system.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@Api(value = "产品管理")
@Controller
@ControllerAdvice
@RequestMapping("/system/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @ApiOperation(value = "产品列表", httpMethod = "POST")
    @PreAuthorize("hasAuthority('/system/product/list')")
    @RequestMapping(value = "/list")
    @ResponseBody
    public Result list(@ModelAttribute ProductPage productPage) {
        return  new Result(CodeEnum.SUCCESS.getCode(),productService.findTByPage(productPage));
    }



    @ApiOperation(value = "增加产品", httpMethod = "POST")
    @PreAuthorize("hasAuthority('/system/product/savaOrupdate')")
    @RequestMapping(value = "/savaOrupdate")
    @ResponseBody
    public Result savaOrupdate(@ModelAttribute Product product) {

        if (StringUtils.isEmpty(product.getProductName())){
            return new Result(CodeEnum.NO_NULL.getCode(),null);
        }

        if (product.getProductTypeId() ==null){
            return new Result(CodeEnum.NO_NULL.getCode(),null);
        }

        productService.savaOrupdate(product);
        return new Result(CodeEnum.SUCCESS.getCode(), null);
    }


    @ApiOperation(value = "删除产品", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", paramType = "form"),
    })
    @PreAuthorize("hasAuthority('/system/product/delete')")
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Result delete(Set<Integer> ids) {
        if (ids.size() ==0){
            return new Result(CodeEnum.NO_NULL.getCode(), null);
        }
        productService.deleteProduct(ids);
        return new Result(CodeEnum.SUCCESS.getCode(), null);
    }

}
