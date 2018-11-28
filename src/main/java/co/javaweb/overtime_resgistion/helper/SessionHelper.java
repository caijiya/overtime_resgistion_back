package co.javaweb.overtime_resgistion.helper;

import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SessionHelper {
    public void setCookie(HttpServletResponse response, String key, String value) {
        Cookie cookie = new Cookie(key, value);
        cookie.setMaxAge(60 * 60);
        cookie.setDomain("172.18.31.12");
//        cookie.setHttpOnly(true);true表示js不能操作cookie
        cookie.setPath("/");
        response.addCookie(cookie);
        try {
            response.flushBuffer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}









