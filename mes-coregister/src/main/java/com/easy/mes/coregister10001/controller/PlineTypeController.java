package com.easy.mes.coregister10001.controller;

import com.easy.commonutils.commonResult;
import com.easy.mes.coregister10001.entity.PlineRegistration;
import com.easy.mes.coregister10001.entity.PlineType;
import com.easy.mes.coregister10001.service.PlineTypeService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/coregister10001/pline-type")
public class PlineTypeController {
    @Autowired
    private PlineTypeService plineTypeService;
    //查询全部
    @GetMapping("findAllPlineType")
    public commonResult findAllPlineType(){
        List<PlineType> list = plineTypeService.list(null);
        return commonResult.OK().data("List",list);
    }
    //添加流水线
    @PostMapping("addPlineType")
    public commonResult addPlineType(@RequestBody PlineType plineType){
        boolean save = plineTypeService.save(plineType);
        if (save){
            return commonResult.OK();
        }else {
            return commonResult.error();
        }
    }
    //修改
    @GetMapping("getPlineType/{id}")
    public commonResult getPlineType(@PathVariable Long id){
        PlineType byId = plineTypeService.getById(id);
        return commonResult.OK().data("PlineType",byId);
    }

    @PostMapping("updatePlineType")
    public commonResult updatePlineType(@RequestBody PlineType plineType){
        boolean b = plineTypeService.updateById(plineType);
        if (b) {
            return commonResult.OK();
        } else {
            return commonResult.error();
        }
    }

}

