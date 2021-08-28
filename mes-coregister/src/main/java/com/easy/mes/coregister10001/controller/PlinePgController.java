package com.easy.mes.coregister10001.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.easy.commonutils.commonResult;
import com.easy.mes.coregister10001.entity.PlinePg;
import com.easy.mes.coregister10001.service.PlinePgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author LiZiHan
 * @since 2021-04-26
 */
@RestController
@CrossOrigin
@RequestMapping("/coregister10001/pline-pg")
public class PlinePgController {
    @Autowired
    private PlinePgService plinePgService;

    //查询全部
    @GetMapping("findAllPlinePg")
    public commonResult findAllPlinePg(){
        List<PlinePg> list = plinePgService.list(null);
        return commonResult.OK().data("List",list);
    }
    //添加生产线方案
    @PostMapping("addPlinePg")
    public commonResult addPlinePg(PlinePg plinePg){
        boolean save = plinePgService.save(plinePg);
        if (save){
            return commonResult.OK();
        }else {
            return commonResult.error();
        }
    }

    //修改
    @GetMapping("getPlinePg/{id}")
    public commonResult getPlinePg(@PathVariable Long id){
        PlinePg byId = plinePgService.getById(id);
        return commonResult.OK().data("PlinePg",byId);
    }
    @PostMapping("updatePlinePg")
    public commonResult updatePlinePg(@RequestBody PlinePg plinePg){
        boolean b = plinePgService.updateById(plinePg);
        if (b){
            return commonResult.OK();
        }else {
            return commonResult.error();
        }
    }
    //分页查询
    @PostMapping("pageFindPlinePg/{current}/{limit}")
    public commonResult pageFindPlinePg(@PathVariable Long current,
                                        @PathVariable Long limit,
                                        @RequestBody PlinePg plinePg){
        Page<PlinePg> pagePlinePg = new Page<>(current,limit);
//        QueryWrapper<PlinePg> wrapper = new QueryWrapper<>();
        plinePgService.page(pagePlinePg, null);
        return commonResult.OK().data("total",pagePlinePg.getTotal()).data("result",pagePlinePg.getRecords());
    }

}

