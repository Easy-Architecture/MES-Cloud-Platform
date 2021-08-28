package com.easy.mes.statistics.Schedule;

import com.easy.mes.statistics.service.DataStatisticsService;
import com.easy.mes.statistics.utils.MyDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.Date;

/**
 * <P>
 *     定时任务，每天早上5点定时收集前天数据
 * </P>
 * @author LiZiHan
 * @since 2021.2.26
 */
@Component

public class ScheduleTest {
    @Autowired
    private DataStatisticsService dataStatisticsService;

    @Scheduled(cron = "0 0 5 * * ? ")
    public void test(){
       dataStatisticsService.numUserRegisterCount(MyDate.formatDate(MyDate.findDate(new Date(),-1)));
    }
}
