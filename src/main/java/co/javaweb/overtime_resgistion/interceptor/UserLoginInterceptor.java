package co.javaweb.overtime_resgistion.interceptor;

import co.javaweb.overtime_resgistion.annotation.IgnoreLogin;
import co.javaweb.overtime_resgistion.helper.SessionHelper;
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

//	@Autowired
//	private UserService userService;
//
//	@Autowired
//	private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = ((HandlerMethod) handler);

        if (handlerMethod.hasMethodAnnotation(IgnoreLogin.class)) {
            return true;
        }
        Cookie cookie1 = WebUtils.getCookie(request, "username");
        Cookie cookie2 = WebUtils.getCookie(request, "JSESSIONID");
        System.out.println(cookie1 == null);
        System.out.println(cookie2 == null);
        HttpSession session = request.getSession();
       String name =  session.getAttribute("username").toString();
        System.out.println(name);
//        if (cookie == null) {
//            return false;
//        }
//        HttpSession session = request.getSession();
//        if (session == null) {
//            response.getWriter().append(JSON.toJSONString(Messages.SESSION_TIME_OUT));
//            return false;
//        }
//        Object username = session.getAttribute("username");
//        if (cookie.getValue() != username) {
//            return false;
//        }
        return true;

    }

}











