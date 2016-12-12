package com.nchu.weixin.subscription.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 订阅号项目 全局拦截器
 * Created by fujianjian on 2016/12/12.
 */
@Component
@Slf4j
public class SubscriptionInterceptor implements HandlerInterceptor {

    private static final ThreadLocal<Long> arriveTime = new ThreadLocal<Long>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o)
            throws Exception {
        log.info("Begin an invoke`" + request.getRequestURI() + "`");
        arriveTime.set(System.currentTimeMillis());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o,
                           ModelAndView modelAndView)
            throws Exception {

        Long arrive = arriveTime.get();
        long costTime = System.currentTimeMillis() - arrive;
        if (costTime > 2000) {
            log.warn(String.format("End an invoke`%s`. Cost time`%.1f`s. With slowness.\n", request.getRequestURI(), costTime/1000.0));
        } else {
            log.info(String.format("End an invoke`%s`. Cost time`%.1f`s.\n", request.getRequestURI(), costTime/1000.0));
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object o, Exception e)
            throws Exception {

    }
}
