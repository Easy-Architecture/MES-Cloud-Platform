package com.easy.mes.coregister10001.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.easy.commonutils.commonResult;
import com.easy.mes.coregister10001.entity.MachineRegistration;
import com.easy.mes.coregister10001.service.MachineRegistrationService;
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
@RequestMapping("/coregister10001/machine-registration")
public class MachineRegistrationController {
    @Autowired
    private MachineRegistrationService machineRegistrationService;
    //查询全部
    @GetMapping("findAllMachine")
    public commonResult findAllMachine(){
        List<MachineRegistration> list = machineRegistrationService.list(null);
        return commonResult.OK().data("List",list);
    }
    //添加机器
    @PostMapping("addMachine")
    public commonResult addMachine(@RequestBody MachineRegistration machineRegistration){
        boolean save = machineRegistrationService.save(machineRegistration);
        if(save){
            return commonResult.OK();
        }else {
            return commonResult.error();
        }
    }
    //修改
    @GetMapping("getMachine/{id}")
    public commonResult getMachine(@PathVariable long id){
        MachineRegistration byId = machineRegistrationService.getById(id);
        return commonResult.OK().data("Machine",byId);
    }
    @PostMapping("updateMachine")
    public commonResult updateMachine(@RequestBody MachineRegistration machineRegistration){
        boolean b = machineRegistrationService.updateById(machineRegistration);
        if (b){
            return commonResult.OK();
        }else {
            return commonResult.error();
        }
    }
    //分页模糊查询
    @PostMapping("pageFindMachine/{current}/{limit}")
    public commonResult pageFindMachine(@PathVariable long current,
                                        @PathVariable long limit,
                                        @RequestBody(required = false) MachineRegistration machineRegistration){

        Page<MachineRegistration> pageMachine=new Page<>(current,limit);
        QueryWrapper<MachineRegistration> wrapper=new QueryWrapper<>();
        String mrName = machineRegistration.getMrName();
        Long plId = machineRegistration.getPlId();
        Long coId = machineRegistration.getCoId();
        if (!StringUtils.isEmpty(coId)){
            wrapper.like("co_id",coId);
        }
        if (!StringUtils.isEmpty(plId)){
            wrapper.like("pl_id",plId);
        }
        if (!StringUtils.isEmpty(mrName)){
            wrapper.like("mr_name",mrName);
        }

        machineRegistrationService.page(pageMachine,wrapper);
        return commonResult.OK().data("total",pageMachine.getTotal()).data("result",pageMachine.getRecords());
    }
}

