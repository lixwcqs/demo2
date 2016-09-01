package com.cqs.common.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by li on 2015/8/30.
 */
public class CqsStringUtil {
    /**
     * 在查询的数据库的时候，特殊字符%和_会查询全部的数据
     * 所以需要转义
     * @param str 待转义的字符串
     * @return
     */
    public static String escapeString(String str){

        if(StringUtils.isEmpty(str)) return str;
        /**
         *   字符 / 被定义为特殊字符，所以也需要处理
         */
        str = StringUtils.replace(str, "/", "//");
        // _ % 为需要转义的特殊字符
        str = StringUtils.replace(str, "_", "/_");
        str = StringUtils.replace(str, "%", "/%");
        return str;
    }


    /**
     * 字符串首字母大写
     * @param str
     * @return
     */
    public static String firstLetterUp(String str){
        if(StringUtils.isNotEmpty(str)){
            return str.substring(0,1).toUpperCase() + str.substring(1);
        }
        return "";
    }


    private static final String seed = "赵钱孙李王abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String getRandomString(int len){
        StringBuilder result = new StringBuilder();
        int seedLen = seed.length();
        for (int i = 0; i < len; i++) {
            result.append(seed.charAt((int) (Math.random() * seedLen)));
        }
        return result.toString();
    }
}
