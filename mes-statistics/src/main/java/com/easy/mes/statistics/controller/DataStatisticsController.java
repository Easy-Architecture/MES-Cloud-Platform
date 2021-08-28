package com.easy.mes.statistics.controller;


import com.easy.commonutils.commonResult;
import com.easy.mes.statistics.service.DataStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author LiZiHan
 * @since 2021-02-26
 */
@RestController
@CrossOrigin
@RequestMapping("/statistics/data-statistics")
public class DataStatisticsController {
    @Autowired
    private DataStatisticsService dataStatisticsService;
    //根据日期查询注册人数
    @PostMapping("numUserRegisterCount/{day}")
    public commonResult numUserRegisterCount(@PathVariable("day") String day){
        dataStatisticsService.numUserRegisterCount(day);
        return commonResult.OK();
    }

}

