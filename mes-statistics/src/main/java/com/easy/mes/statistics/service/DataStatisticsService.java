package com.easy.mes.statistics.service;

import com.easy.mes.statistics.entity.DataStatistics;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author LiZiHan
 * @since 2021-02-26
 */
public interface DataStatisticsService extends IService<DataStatistics> {

    void numUserRegisterCount(String day);
}
