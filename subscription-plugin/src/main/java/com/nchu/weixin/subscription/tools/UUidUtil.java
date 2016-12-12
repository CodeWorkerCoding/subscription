package com.nchu.weixin.subscription.tools;

import java.util.UUID;

/**
 * uuid 工具类
 * Created by fujianjian on 2016/12/12.
 */
public class UUidUtil {

    public static String getUUid(){
        String wholeUUid = UUID.randomUUID().toString();
        return wholeUUid.replace("-", "");
    }
}
