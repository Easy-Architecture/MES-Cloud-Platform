package com.easy.mes.coregister10001.controller;


import com.easy.commonutils.commonResult;
import com.easy.mes.coregister10001.entity.PType;
import com.easy.mes.coregister10001.service.PTypeService;
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
@RequestMapping("/coregister10001/p-type")
public class PTypeController {
    @Autowired
    private PTypeService pTypeService;
    //查询全部
    @GetMapping("findAllPType")
    public commonResult findAllPType(){
        List<PType> list = pTypeService.list(null);
        return commonResult.OK().data("List",list);
    }
    //添加商品类型
    @PostMapping("addPType")
    public commonResult addPType(@RequestBody PType pType){
        boolean save = pTypeService.save(pType);
        if (save){
            return commonResult.OK();
        }else {
            return commonResult.error();
        }
    }
    //修改
    @GetMapping("getPType/{id}")
    public commonResult getPType(@PathVariable Long id){
        PType byId = pTypeService.getById(id);
        return commonResult.OK().data("PType",byId);
    }

    @PostMapping("updatePType")
    public commonResult updatePType(@RequestBody PType pType){
        boolean b = pTypeService.updateById(pType);
        if (b) {
            return commonResult.OK();
        } else {
            return commonResult.error();
        }
    }

}

