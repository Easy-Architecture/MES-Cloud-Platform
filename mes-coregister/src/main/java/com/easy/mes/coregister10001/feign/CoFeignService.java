package com.easy.mes.coregister10001.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("mes-login")
@Component
public interface CoFeignService {
    @GetMapping("/login/co-login/getCoNameById/{id}")
    String getCoNameById(@PathVariable("id") Long id);
}
