package com.easy.mes.order.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.easy.commonutils.JwtConfig;
import com.easy.commonutils.commonResult;
import com.easy.mes.order.entity.CuOrder;
import com.easy.mes.order.service.CuOrderService;
import com.easy.mes.order.vo.OrderInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

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
@RequestMapping("/order/cu-order")
public class CuOrderController {
    @Autowired
    private CuOrderService cuOrderService;

    //生成订单,返回订单号
    @PostMapping("createCuOrder/{pId}")
    public commonResult createCuOrder(@PathVariable Long pId ,
                                      HttpServletRequest request){
        //根据token确认用户信息

        String orderId=cuOrderService.createCuOrder(pId,JwtConfig.getIdByJwtToken(request));
        return commonResult.OK().data("orderId",orderId);
    }

    //根据订单号查询订单
    @GetMapping("getCuOrder/{orderId}")
    public commonResult getCuOrder(@PathVariable("orderId") Long orderId){
        QueryWrapper<CuOrder> wrapper=new QueryWrapper<>();
        wrapper.eq("order_id",orderId);
        CuOrder order = cuOrderService.getOne(wrapper);
        return commonResult.OK().data("result",order);
    }

}

