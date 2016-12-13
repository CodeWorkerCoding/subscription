package com.nchu.weixin.subscription.tools;

/**
 * 字符串工具
 * Created by fujianjian on 2016/12/13.
 */
public class StringHelper {

    public static  boolean isEmpty(String str){
        if (str == null || str.length() ==0) return true;
        return  false;
    }

    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }

}
