package com.easy.mes.statistics.service.impl;

import com.easy.commonutils.commonResult;
import com.easy.mes.statistics.entity.DataStatistics;
import com.easy.mes.statistics.feign.CustomerFeign;
import com.easy.mes.statistics.mapper.DataStatisticsMapper;
import com.easy.mes.statistics.service.DataStatisticsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author LiZiHan
 * @since 2021-02-26
 */
@Service
public class DataStatisticsServiceImpl extends ServiceImpl<DataStatisticsMapper, DataStatistics> implements DataStatisticsService {

    @Autowired
    private CustomerFeign customerFeign;

    @Override
    public void numUserRegisterCount(String day) {
        //远程调用查询当天注册人数
        commonResult numUserRegister = customerFeign.numUserRegister(day);
        Integer result = (Integer) numUserRegister.getData().get("result");

        //将结果加入数据库
        DataStatistics s = new DataStatistics();
        s.setNumUserRegister(result);
        s.setStatisticsDate(day);
        baseMapper.insert(s);
    }
}
