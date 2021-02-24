package com.easy.mes.coregister10001.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.easy.commonutils.commonResult;
import com.easy.mes.coregister10001.entity.Product;
import com.easy.mes.coregister10001.entity.vo.ProductAndCoInfoVo;
import com.easy.mes.coregister10001.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author LiZiHan
 * @since 2021-02-18
 */
@RestController
@CrossOrigin
@RequestMapping("/coregister10001/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    //查询全部
    @GetMapping("findAllProduct")
    public commonResult findAllProduct(){
        List<Product> list = productService.list(null);
        return commonResult.OK().data("List",list);
    }
    //添加商品
    @PostMapping("addProduct")
    public commonResult addProduct(@RequestBody Product product){
        boolean save = productService.save(product);
        if (save){
            return commonResult.OK();
        }else {
            return commonResult.error();
        }
    }
    //修改
    @GetMapping("getProduct/{id}")
    public commonResult getProduct(@PathVariable Long id){
        Product byId = productService.getById(id);
        return commonResult.OK().data("Product",byId);
    }

    @PostMapping("updateProduct")
    public commonResult updateProduct(@RequestBody Product product){
        boolean b = productService.updateById(product);
        if (b) {
            return commonResult.OK();
        } else {
            return commonResult.error();
        }
    }
    //分页模糊查询
    @PostMapping("pageFindProduct/{current}/{limit}")
    public commonResult pageFindProduct(@PathVariable long current,
                                        @PathVariable long limit,
                                        @RequestBody(required = false) Product product){
        Page<Product> pageProduct=new Page<>(current,limit);
        QueryWrapper<Product> wrapper=new QueryWrapper<>();

        Long coId = product.getCoId();
        Long plId = product.getPlId();
        Long ptypeId = product.getPtypeId();
        String pName = product.getPName();
        if (!StringUtils.isEmpty(coId)){
            wrapper.like("co_id",coId);
        }
        if (!StringUtils.isEmpty(plId)){
            wrapper.like("pl_id",plId);
        }
        if (!StringUtils.isEmpty(ptypeId)){
            wrapper.like("ptype_id",ptypeId);
        }
        if (!StringUtils.isEmpty(pName)){
            wrapper.like("p_name",pName);
        }

        productService.page(pageProduct,wrapper);
        return commonResult.OK().data("total",pageProduct.getTotal()).data("result",pageProduct.getRecords());
    }

    //根据商品id查询商品信息(远程调用方法)
    @GetMapping("getPACInfo/{id}")
    public List<ProductAndCoInfoVo> getPACInfo(@PathVariable("id") Long id){
        return productService.getProductAndCoInfo();
    }
}

