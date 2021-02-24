package com.easy.mes.coregister10001.mapper;

import com.easy.mes.coregister10001.entity.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.mes.coregister10001.entity.vo.ProductAndCoInfoVo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author LiZiHan
 * @since 2021-02-18
 */
public interface ProductMapper extends BaseMapper<Product> {
    @Select("SELECT product.*,business_registration.* FROM product,business_registration WHERE product.co_id=business_registration.co_id")
    List<ProductAndCoInfoVo> getProductAndCoInfo();
}
