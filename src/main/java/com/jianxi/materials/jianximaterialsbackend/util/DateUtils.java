package com.jianxi.materials.jianximaterialsbackend.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author chenzeshenga
 * @since 2020-07-23
 */
public class DateUtils {

    public static String getDateStr(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(date);
    }
}
