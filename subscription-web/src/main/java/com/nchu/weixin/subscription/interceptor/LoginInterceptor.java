package com.nchu.weixin.subscription.interceptor;

import com.nchu.weixin.subscription.domain.component.UserContext;
import com.nchu.weixin.subscription.tools.StringHelper;
import com.nchu.weixin.subscription.utils.UserUtil;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登入拦截器
 * Created by fujianjian on 2016/12/13.
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o)
            throws Exception {
        String username = UserUtil.getUserDetails().getUsername();
        if (StringHelper.isNotEmpty(username)){
            //先不删除，万一spring security自带的限制一处登录功能不好用，或者将来实现集群则可以启用它。
            HttpSession session = request.getSession(false);
            if (!request.getRequestURI().startsWith("/facade") && !request.getRequestURI().startsWith("/login")) {
                //session 过期重新登入
                if (session == null) {
                    response.sendRedirect("/login?logout");
                    return false;
                } else {
                    return true;
                }
            }
        }
        response.sendRedirect("/login?logout");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o,
                           ModelAndView modelAndView)
            throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                Object o, Exception e)
            throws Exception {

    }
}
