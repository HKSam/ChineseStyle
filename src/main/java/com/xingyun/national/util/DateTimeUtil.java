package com.xingyun.national.util;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;

import java.util.Date;

public class DateTimeUtil {
    public static String dateToStamp(Date date) {
        if (date == null) {
            return StringUtils.EMPTY;
        }
        Long dateTime = date.getTime();
        return String.valueOf(dateTime);
    }
}
