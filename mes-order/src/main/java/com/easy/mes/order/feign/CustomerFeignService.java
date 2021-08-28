package com.easy.mes.order.feign;

import com.easy.mes.order.vo.CustomerVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@Component
@FeignClient("mes-login")
public interface CustomerFeignService {
    @GetMapping("/login/customer-login/getCuInfoById/{id}")
    List<CustomerVo> getCuInfoById(@PathVariable("id") Long id);
}
