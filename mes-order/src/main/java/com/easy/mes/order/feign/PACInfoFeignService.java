package com.easy.mes.order.feign;

import com.easy.mes.order.vo.PACInfoVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

//@Component
@FeignClient("mes-coregister")
public interface PACInfoFeignService {
    @GetMapping("/coregister10001/product/getPACInfo/{id}")
    List<PACInfoVo> getPACInfo(@PathVariable("id") Long id);
}
