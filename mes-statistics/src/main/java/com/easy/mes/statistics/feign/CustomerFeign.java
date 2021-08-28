package com.easy.mes.statistics.feign;

import com.easy.commonutils.commonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("mes-login")
public interface CustomerFeign {
    @GetMapping("/login/customer-login/numUserRegister/{day}")
    commonResult numUserRegister(@PathVariable("day") String day);
}
