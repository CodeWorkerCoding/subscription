package com.nchu.weixin.subscription.action;

import com.nchu.weixin.subscription.domain.component.UserContext;
import org.hibernate.annotations.common.util.StringHelper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * 登入控制器
 * Created by fujianjian on 2016/12/13.
 */
@Component
@Controller
@RequestMapping("")
public class LoginAction {

    @RequestMapping(value = {"/login", "/login/"}, method = RequestMethod.GET)
    public String loadLoginPage(HttpServletRequest request, Model model){
        String userName = UserContext.getUserName();
        if (StringHelper.isNotEmpty(userName)){
            return "redirect:/";
        }
        model.addAttribute("error", "");

        if (request.getSession(false) != null){
            Exception exception = (Exception) request.getSession().getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
            if (exception != null) {
                model.addAttribute("error", exception.getMessage());
            }
        }
        return "login";
    }

    @RequestMapping(value = { "/" }, method = { RequestMethod.GET })
    public String login(HttpServletRequest request, Model model) throws Exception {
        /*java 代码实现security获取当前用户*/
        UserDetails user = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        UserContext.setUserName(user.getUsername());
        model.addAttribute("cus", user.getUsername());
        return "main";
    }

    /*@RequestMapping(value = { "/logout" }, method = { RequestMethod.GET })
    public String logout(HttpServletRequest request, Model model) throws Exception {
        return "redirect:/login";
    }*/
}
