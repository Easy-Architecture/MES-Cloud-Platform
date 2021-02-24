package com.easy.mes.order.vo;

import lombok.Data;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author LiZiHan
 * @since 2021-02-21
 */
@Data
public class OrderInfoVo {
    //用户信息
    List<CustomerVo> member;
    //商品信息
    List<PACInfoVo> prod;
    //订单总额
    //    BigDecimal total;

}
