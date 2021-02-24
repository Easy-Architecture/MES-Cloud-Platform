package com.easy.mes.coregister10001.service.impl;

import com.easy.mes.coregister10001.entity.Product;
import com.easy.mes.coregister10001.entity.vo.ProductAndCoInfoVo;
import com.easy.mes.coregister10001.mapper.ProductMapper;
import com.easy.mes.coregister10001.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author LiZiHan
 * @since 2021-02-18
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
    //返回商品信息
    @Override
    public List<ProductAndCoInfoVo> getProductAndCoInfo() {
        return this.baseMapper.getProductAndCoInfo();
    }
}

