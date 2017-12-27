package com.taotao.common.utils;

import java.util.Calendar;
import java.util.Random;

public class PictureUtil {

    /**
     * 图片名生成
     */
    public static String genImageName() {
        //取当前时间的长整形值包含毫秒
        long millis = System.currentTimeMillis();
        //long millis = System.nanoTime();
        //加上三位随机数
        Random random = new Random();
        int end3 = random.nextInt(999);
        //如果不足三位前面补0
        String str = millis + String.format("%03d", end3);

        return str;
    }

    /**
     * 图片路径生成
     */
    public static String genImagePath() {
        //取当前时间的年月日
        Calendar calendar=Calendar.getInstance();
        String imagePath=String.format("%d/%d/%d",calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DATE));
        return imagePath;
    }

}
