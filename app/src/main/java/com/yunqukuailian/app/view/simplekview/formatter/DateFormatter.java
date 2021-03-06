package com.yunqukuailian.app.view.simplekview.formatter;


import com.yunqukuailian.app.view.simplekview.DateUtil;
import com.yunqukuailian.app.view.simplekview.base.IDateTimeFormatter;

import java.util.Date;

/**
 * 时间格式化器
 * Created by tifezh on 2016/6/21.
 */

public class DateFormatter implements IDateTimeFormatter {
    @Override
    public String format(Date date) {
        if (date != null) {
            return DateUtil.DateFormat.format(date);
        } else {
            return "";
        }
    }
}
