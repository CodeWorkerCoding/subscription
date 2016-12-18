package com.nchu.weixin.subscription.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具类
 * Created by fujianjian on 2016/12/18.
 */
public class DateHepler {

    public static final String DF_YYYY_MM_DD = "yyyy-MM-dd";

    public static final String DF_YYYY_MM_DD_HH = "yyyy-MM-dd hh:mm:ss";

    public static final String DF_YYYYMMDD = "yyyyMMdd";

    public static final String DF_YYYYMMDDHH = "yyyyMMddHHmmss";

    public static final String DF_YYYYMM = "yyyyMM";

    private static SimpleDateFormat DF_SDF = null;

    public static String convertDateToDisplayStr(Date date, String format) {
        String dateStr = null;
        if (format == null)
            format = DF_YYYY_MM_DD;
        if (DF_SDF == null) {
            DF_SDF = new SimpleDateFormat();
        }
        DF_SDF.applyPattern(format);
        if (date != null) {
            dateStr = DF_SDF.format(date);
        }
        return dateStr;
    }

}
