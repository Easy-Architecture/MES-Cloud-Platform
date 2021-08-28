package com.easy.mes.banner.controller;

import com.easy.commonutils.commonResult;
import com.easy.mes.banner.entity.Banner;
import com.easy.mes.banner.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author LiZiHan
 * @since 2021-03-03
 */

@RestController
@CrossOrigin
@RequestMapping("/mesBanner/bannerBefore")
public class BannerBeforeController {
    @Autowired
    private BannerService bannerService;

    //查询所有banner
    @GetMapping("getAllBanner")
    public commonResult getAllBanner(){
        List<Banner> a = bannerService.list(null);
        return commonResult.OK().data("list",a);
    }

}
