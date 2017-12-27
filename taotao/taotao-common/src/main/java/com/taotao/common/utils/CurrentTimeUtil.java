package com.taotao.common.utils;

import java.util.Calendar;

public class CurrentTimeUtil {
    public  static String getCurrwntTime(){
        return "【"+ Calendar.getInstance().getTimeInMillis()+"】";
    }
}
