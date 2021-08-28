package com.easy.mes.coregister10001.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.easy.commonutils.commonResult;
import com.easy.mes.coregister10001.entity.SpecificScheme;
import com.easy.mes.coregister10001.service.SpecificSchemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
@RequestMapping("/coregister10001/specific-scheme")
public class SpecificSchemeController {
    @Autowired
    private SpecificSchemeService specificSchemeService;

    //查询全部
    @GetMapping("findAllSpecificScheme")
    public commonResult findAllSpecificScheme(){
        List<SpecificScheme> list = specificSchemeService.list();
        return commonResult.OK().data("list",list);
    }
    //添加具体方案
    @PostMapping("addSpecificScheme")
    public commonResult addSpecificScheme(@RequestBody SpecificScheme specificScheme,
                                          HttpServletRequest request){
        boolean mySave = specificSchemeService.mySave(specificScheme,request);
        if (mySave) {
            return commonResult.OK();
        } else {
            return commonResult.error();
        }
    }
    //修改
    @GetMapping("getSpecificScheme/(id)")
    public commonResult getSpecificScheme(@PathVariable Long id){
        SpecificScheme byId = specificSchemeService.getById(id);
        return commonResult.OK().data("SpecificScheme",byId);
    }
    @PostMapping("updateSpecificScheme")
    public commonResult updateSpecificScheme(@RequestBody SpecificScheme specificScheme){
        boolean b = specificSchemeService.updateById(specificScheme);
        if (b){
            return commonResult.OK();
        }else {
            return commonResult.error();
        }
    }
    //分页查询
    @PostMapping("pageFindSpecificScheme/{current}/{limit}")
    public commonResult pageFindSpecificScheme(@PathVariable Long current,
                                               @PathVariable Long limit,
                                               @RequestBody SpecificScheme specificScheme){
        Page<SpecificScheme> pageSpecificScheme = new Page<>(current,limit);
//        QueryWrapper<SpecificScheme> wrapper = new QueryWrapper<>();
        specificSchemeService.page(pageSpecificScheme,null);
        return commonResult.OK().data("total",pageSpecificScheme.getTotal()).data("result",pageSpecificScheme.getRecords());
    }

    //根据方案id删除方案
    @DeleteMapping("{id}")
    public commonResult deleteThis(@PathVariable("id") Long id){
        boolean b = specificSchemeService.removeById(id);
        if (b){
            return commonResult.OK();
        }else {
            return commonResult.error();
        }
    }

}

