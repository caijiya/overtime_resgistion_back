package co.javaweb.overtime_resgistion.interceptor;

import co.javaweb.overtime_resgistion.annotation.IgnoreLogin;
import co.javaweb.overtime_resgistion.common.Messages;
import co.javaweb.overtime_resgistion.helper.SessionHelper;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserLoginInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private SessionHelper sessionService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = ((HandlerMethod) handler);

        if (handlerMethod.hasMethodAnnotation(IgnoreLogin.class)) {
            return true;
        }
        Cookie username = WebUtils.getCookie(request, "username");
        System.out.println(username);
//        Cookie cookie = WebUtils.getCookie(request, "JSESSIONID");
        HttpSession session = request.getSession();
        Object USERNAME = session.getAttribute("username");
        if (USERNAME == null) {
            response.getWriter().append(JSON.toJSONString(Messages.SESSION_TIME_OUT));
            return false;
        }
        if (!StringUtils.equals(USERNAME.toString(), username.getValue())) {
            response.getWriter().append(JSON.toJSONString(Messages.BAD_REQUEST));
            return false;
        }
        return true;

    }

}











