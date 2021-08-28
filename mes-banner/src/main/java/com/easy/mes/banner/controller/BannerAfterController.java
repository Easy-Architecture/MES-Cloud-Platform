//package com.easy.mes.banner.controller;
//
//
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import com.easy.commonutils.commonResult;
//import com.easy.mes.banner.entity.Banner;
//import com.easy.mes.banner.service.BannerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
///**
// * <p>
// *  前端控制器
// * </p>
// *
// * @author LiZiHan
// * @since 2021-03-03
// */
//@RestController
//@CrossOrigin
//@RequestMapping("/mesBanner/bannerAfter")
//public class BannerAfterController {
//    @Autowired
//    private BannerService bannerService;
//    //增
//    @PostMapping("addBanner")
//    public commonResult addBanner(@RequestBody Banner banner){
//        bannerService.save(banner);
//        return commonResult.OK();
//    }
//    //改
//    @GetMapping("getBanner/{id}")
//    public commonResult updateBanner(@PathVariable("id") Long id){
//        Banner byId = bannerService.getById(id);
//        return commonResult.OK().data("item",byId);
//    }
//    @PutMapping("updateBanner")
//    public commonResult updateBanner(@RequestBody Banner banner){
//        bannerService.updateById(banner);
//        return commonResult.OK();
//    }
//    //分页查
//    @GetMapping("pageBanner/{page}/{limit}")
//    public commonResult pageBanner(@PathVariable long page,
//                                   @PathVariable long limit){
//        Page<Banner> bannerPage = new Page<>(page,limit);
//        bannerService.page(bannerPage,null);
//        return commonResult.OK().data("images",bannerPage.getRecords()).data("total",bannerPage.getTotal());
//    }
//
//}

