package com.easy.mes.coregister10001.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.easy.commonutils.commonResult;
import com.easy.mes.coregister10001.entity.BusinessRegistration;
import com.easy.mes.coregister10001.service.BusinessRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author LiZiHan
 * @since 2021-02-10
 */
@RestController
@CrossOrigin
@RequestMapping("/coregister10001/business-registration")
public class BusinessRegistrationController {
    @Autowired
    private BusinessRegistrationService businessRegistrationService;

    //查询全部
    @GetMapping("findAllBusiness")
    public commonResult findAllBusiness() {
        List<BusinessRegistration> list = businessRegistrationService.list(null);
        return commonResult.OK().data("List", list);
    }

    //添加企业
    @PostMapping("addBusiness")
    public commonResult addBusiness(@RequestBody BusinessRegistration businessRegistration) {
        boolean save = businessRegistrationService.save(businessRegistration);
        if (save) {
            return commonResult.OK();
        } else {
            return commonResult.error();
        }
    }

    //修改
    @GetMapping("getBusiness/{id}")
    public commonResult getBusiness(@PathVariable Long id) {
        BusinessRegistration byId = businessRegistrationService.getById(id);
        return commonResult.OK().data("Business", byId);
    }

    @PostMapping("updateBusiness")
    public commonResult updateBusiness(@RequestBody BusinessRegistration businessRegistration) {
        boolean b = businessRegistrationService.updateById(businessRegistration);
        if (b) {
            return commonResult.OK();
        } else {
            return commonResult.error();
        }
    }

    //分页模糊查询
    @PostMapping("pageFindBusiness/{current}/{limit}")
    public commonResult pageFindBusiness(@PathVariable long current,
                                         @PathVariable long limit,
                                         @RequestBody(required = false) BusinessRegistration businessRegistration) {
        Page<BusinessRegistration> pageBusiness = new Page<>(current, limit);
        QueryWrapper<BusinessRegistration> wrapper = new QueryWrapper<>();

        String coName = businessRegistration.getCoName();
        if (!StringUtils.isEmpty(coName)) {
            wrapper.like("co_name", coName);
        }

        businessRegistrationService.page(pageBusiness, wrapper);
        return commonResult.OK().data("total", pageBusiness.getTotal()).data("result", pageBusiness.getRecords());
    }

}

