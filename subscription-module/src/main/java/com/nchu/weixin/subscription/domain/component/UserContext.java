package com.nchu.weixin.subscription.domain.component;

/**
 * 用户容器
 * Created by fujianjian on 2016/12/13.
 */
public class UserContext {

    private static ThreadLocal<String> local=new ThreadLocal<String>();

    public static void setUserName(String userName){
        local.set(userName);
    }

    public static String getUserName(){
        return local.get();
    }

    public static void remove(){
        local.remove();
    }
}
