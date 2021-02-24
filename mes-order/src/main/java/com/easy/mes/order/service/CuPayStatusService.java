package com.easy.mes.order.service;

import com.easy.mes.order.entity.CuPayStatus;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author LiZiHan
 * @since 2021-02-21
 */
public interface CuPayStatusService extends IService<CuPayStatus> {

    Map createPay(Long orderId);

    Map<String, String> getPayStatus(Long orderId);

    void updateCuOrdersStatus(Map<String, String> map);
}
