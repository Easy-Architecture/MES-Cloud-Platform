package com.easy.mes.coregister10001.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.easy.commonutils.commonResult;
import com.easy.mes.coregister10001.entity.PlineRegistration;
import com.easy.mes.coregister10001.service.PlineRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author LiZiHan
 * @since 2021-02-10
 */
@RestController
@CrossOrigin
@RequestMapping("/coregister10001/pline-registration")
public class PlineRegistrationController {
    @Autowired
    private PlineRegistrationService plineRegistrationService;
    //查询全部
    @GetMapping("findAllPline")
    public commonResult findAllPline(){
        List<PlineRegistration> list = plineRegistrationService.list(null);
        return commonResult.OK().data("List",list);
    }
    //添加流水线
    @PostMapping("addPline")
    public commonResult addPline(@RequestBody PlineRegistration plineRegistration){
        boolean save = plineRegistrationService.save(plineRegistration);
        if (save){
            return commonResult.OK();
        }else {
            return commonResult.error();
        }
    }
    //修改
    @GetMapping("getPline/{id}")
    public commonResult getPline(@PathVariable Long id){
        PlineRegistration byId = plineRegistrationService.getById(id);
        return commonResult.OK().data("Pline",byId);
    }

    @PostMapping("updatePline")
    public commonResult updatePline(@RequestBody PlineRegistration plineRegistration){
        boolean b = plineRegistrationService.updateById(plineRegistration);
        if (b) {
            return commonResult.OK();
        } else {
            return commonResult.error();
        }
    }

    //分页模糊查询
    @PostMapping("pageFindPline/{current}/{limit}")
    public commonResult pageFindPline(@PathVariable long current,
                                      @PathVariable long limit,
                                      @RequestBody(required = false) PlineRegistration plineRegistration){

        Page<PlineRegistration> pagePline=new Page<>(current,limit);
        QueryWrapper<PlineRegistration> wrapper=new QueryWrapper<>();

        Long pltId = plineRegistration.getPltId();
        Long coId = plineRegistration.getCoId();
        String plName = plineRegistration.getPlName();
        if (!StringUtils.isEmpty(pltId)){
            wrapper.like("plt_id",pltId);
        }
        if (!StringUtils.isEmpty(coId)){
            wrapper.like("co_id",coId);
        }
        if (!StringUtils.isEmpty(plName)){
            wrapper.like("pl_name",plName);
        }

        plineRegistrationService.page(pagePline,wrapper);
        return commonResult.OK().data("total",pagePline.getTotal()).data("result",pagePline.getRecords());
    }

}

