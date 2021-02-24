package com.easy.mes.order.service;

import com.easy.mes.order.entity.CuOrder;
import com.baomidou.mybatisplus.extension.service.IService;
import com.easy.mes.order.vo.OrderInfoVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author LiZiHan
 * @since 2021-02-21
 */
public interface CuOrderService extends IService<CuOrder> {

    String createCuOrder(Long pId, String idByJwtToken);

}
