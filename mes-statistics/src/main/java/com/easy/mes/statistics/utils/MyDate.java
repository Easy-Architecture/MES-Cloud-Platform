package com.easy.mes.statistics.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyDate {
    //获取时间类

    public static String formatDate(Date date) {
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        return s.format(date);
    }

    public static Date findDate(Date date, int day) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DATE, c.get(Calendar.DATE) + day);
        return c.getTime();
    }

}
