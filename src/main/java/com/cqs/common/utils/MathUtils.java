package com.cqs.common.utils;

/**
 * Created by li on 2015/11/29.
 */
public class MathUtils {
    /**
     * 求百分比，保留到小数点后两位
     * @param num1
     * @param num2
     * @return
     */
    public static String percent(int num1,int num2){
        return num2 == 0 ?  "-" : (Math.round(num1*10000.0/num2)/100.0 + "%");
    }
}
