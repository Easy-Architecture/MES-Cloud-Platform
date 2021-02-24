package com.easy.mes.order.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.mes.order.entity.CuOrder;
import com.easy.mes.order.feign.CustomerFeignService;
import com.easy.mes.order.feign.PACInfoFeignService;
import com.easy.mes.order.mapper.CuOrderMapper;
import com.easy.mes.order.service.CuOrderService;
import com.easy.mes.order.vo.CustomerVo;
import com.easy.mes.order.vo.OrderInfoVo;
import com.easy.mes.order.vo.PACInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author LiZiHan
 * @since 2021-02-21
 */
@Service
public class CuOrderServiceImpl extends ServiceImpl<CuOrderMapper, CuOrder> implements CuOrderService {


    @Autowired
    private CustomerFeignService customerFeignService;
//    @Qualifier("PACInfoFeignService")
    @Autowired
    private PACInfoFeignService pacInfoFeignService;

    //随机订单号
    public static Long getOrderNum(){
        Date date =new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HHmmssSSS");
        String format = sdf.format(date);
        return Long.valueOf(format);
    }
    //订单生成
    @Override
    public String createCuOrder(Long pId, String idByJwtToken) {

        OrderInfoVo orderInfo = new OrderInfoVo();
        //远程调用，根据用户id获取用户信息
        List<CustomerVo> cuInfoById = customerFeignService.getCuInfoById(Long.valueOf(idByJwtToken));
        orderInfo.setMember(cuInfoById);

        //远程调用，通过商品id获取商品信息
        List<PACInfoVo> pacInfo = pacInfoFeignService.getPACInfo(pId);
        orderInfo.setProd(pacInfo);

        CuOrder cuOrder=new CuOrder();//创建订单

        cuOrder.setOrderId(CuOrderServiceImpl.getOrderNum());//订单号
        cuOrder.setPId(pId);//商品id
        cuOrder.setPName(orderInfo.getProd().get(0).getPName());//商品名
        cuOrder.setCoId(orderInfo.getProd().get(0).getCoId());//公司id
        cuOrder.setCoName(orderInfo.getProd().get(0).getCoName());//公司名字
        cuOrder.setCoAddr(orderInfo.getProd().get(0).getCoAddr());//公司地址
        cuOrder.setCsdTel(orderInfo.getProd().get(0).getCsdTel());//客服电话
        cuOrder.setMemberId(Long.valueOf(idByJwtToken));//顾客id
        cuOrder.setNickname(orderInfo.getMember().get(0).getNickname());//顾客昵称
        cuOrder.setMobile(orderInfo.getMember().get(0).getMobile());//顾客电话
        cuOrder.setTotalAmount(BigDecimal.valueOf(0.01));//总金额
        cuOrder.setStatus(0);//支付状态
        cuOrder.setPayType(1);//支付类型

        baseMapper.insert(cuOrder);

        return String.valueOf(cuOrder.getOrderId());
    }


}
