package com.nchu.weixin.subscription.ordinary;

import org.junit.Test;

/**
 * 普通的功能验证测试类
 * Created by fujianjian on 2017/2/21.
 */
public class OrdinaryTest {

    @Test
    public void testRegexString(){
        String source = "wer123edf5ed456eee";
        System.out.println(source.replaceAll("\\d+", ","));
    }
}
