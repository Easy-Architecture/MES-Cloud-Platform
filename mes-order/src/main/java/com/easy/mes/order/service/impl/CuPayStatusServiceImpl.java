package com.easy.mes.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.easy.commonutils.exceptionhandler.MyException;
import com.easy.mes.order.entity.CuOrder;
import com.easy.mes.order.entity.CuPayStatus;
import com.easy.mes.order.mapper.CuPayStatusMapper;
import com.easy.mes.order.service.CuOrderService;
import com.easy.mes.order.service.CuPayStatusService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author LiZiHan
 * @since 2021-02-21
 */
@Service
public class CuPayStatusServiceImpl extends ServiceImpl<CuPayStatusMapper, CuPayStatus> implements CuPayStatusService {

    @Autowired
    private CuOrderService cuOrderService;
    @Override
    public Map createPay(Long orderId) {
        try {
            //根据订单号查询订单信息
            QueryWrapper<CuOrder> wrapper = new QueryWrapper<>();
            wrapper.eq("order_id",orderId);
            CuOrder cuOrder = cuOrderService.getOne(wrapper);

            //伪支付，返回结果集
            Map map = new HashMap<>();
            map.put("order_id",orderId);
            map.put("p_id",cuOrder.getPId());
            map.put("pay_type",1);
            map.put("total_amount",cuOrder.getTotalAmount());

            return map;
        }catch (Exception e){
            throw new MyException(44444,"支付页异常");
        }
    }

    //返回支付成功状态
    @Override
    public Map<String, String> getPayStatus(Long orderId) {
        Map m = new HashMap<>();
        m.put("order_id",String.valueOf(orderId));
        m.put("pay_status","SUCCESS");
        return m;
    }

    //更新支付数据
    @Override
    public void updateCuOrdersStatus(Map<String, String> map) {

        //拿到订单号
        String orderId = map.get("order_id");

        //根据订单号查询订单信息
        QueryWrapper<CuOrder> wrapper = new QueryWrapper<>();
        wrapper.eq("order_id",orderId);
        CuOrder cuOrder = cuOrderService.getOne(wrapper);

        //添加支付状态表记录
        CuPayStatus c= new CuPayStatus();
        c.setOrderId(cuOrder.getOrderId());
        c.setTransactionId("testTransactionId");
        c.setPayTime(new Date());
        c.setPayType(1);
        c.setTotalAmount(cuOrder.getTotalAmount());
        c.setTradeStatus(map.get("pay_status"));
        baseMapper.insert(c);

        //更新订单表状态信息
        if (cuOrder.getStatus().intValue() == 1){
            return;
        }
        cuOrder.setStatus(1);
        cuOrderService.updateById(cuOrder);

    }
}
