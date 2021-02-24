package com.easy.mes.order.controller;


import com.easy.commonutils.commonResult;
import com.easy.mes.order.service.CuPayStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author LiZiHan
 * @since 2021-02-21
 */
@RestController
@CrossOrigin
@RequestMapping("/order/cu-pay-status")
public class CuPayStatusController {
    @Autowired
    private CuPayStatusService cuPayStatusService;
    //返回支付页信息
    @GetMapping("createPay/{orderId}")
    public commonResult createPay(@PathVariable Long orderId){
        Map map=cuPayStatusService.createPay(orderId);
        return commonResult.OK().data("result",map);
    }
    //支付状态查询
    @GetMapping("getPayStatus/{orderId}")
    public commonResult getPayStatus(@PathVariable Long orderId){
        Map<String,String> map=cuPayStatusService.getPayStatus(orderId);

        if (map == null){
            return commonResult.error().message("支付失败");
        }
        if (map.get("pay_status").equals("SUCCESS")){
            //更新订单表状态
            cuPayStatusService.updateCuOrdersStatus(map);
            return commonResult.OK().message("支付成功");
        }
        return commonResult.OK().message("未支付");
    }
}

