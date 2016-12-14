package com.nchu.weixin.subscription.utils;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/** 用户模块工具
 * Created by fujianjian on 2016/12/14.
 */
public class UserUtil {

    /**
     * 获取当前用户
     * @return
     */
    public static UserDetails getUserDetails(){
        UserDetails user = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        return user;
    }
}
