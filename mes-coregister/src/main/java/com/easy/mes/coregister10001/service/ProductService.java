package com.easy.mes.coregister10001.service;

import com.easy.mes.coregister10001.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;
import com.easy.mes.coregister10001.entity.vo.ProductAndCoInfoVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author LiZiHan
 * @since 2021-02-18
 */
public interface ProductService extends IService<Product> {
    List<ProductAndCoInfoVo> getProductAndCoInfo();
}
