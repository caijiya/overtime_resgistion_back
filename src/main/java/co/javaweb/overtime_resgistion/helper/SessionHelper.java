package co.javaweb.overtime_resgistion.helper;

import org.springframework.stereotype.Component;

@Component
public class SessionHelper {
//
//    public static final int MIN_SESSION_TIME_OUT = -1;
//
//    public static final int MAX_SESSION_TIME_OUT = 60 * 60 * 24 * 7;    //1周
//
//
//    private String userSessionkeyHex = "59C5167E80EF11E8B03100163E11BA6D";
//
//    private byte[] userSessionkey;
//
//    private String hostName = "localhost";
//
//    private byte[] managerSessionKey;
//
//    private String managerSessionKeyHex = "2B2CCD62A77311E8A30C525400AA14EF";
//
//    @Autowired
//    private EmployeeRepository employeeRepository;
//
//
//    @Autowired
//    private SessionRepository sessionRepository;
//
//    @PostConstruct
//    public void init() {
//        this.userSessionkey = HexByteUtils.hexStringToBytes(this.userSessionkeyHex);
//        this.managerSessionKey = HexByteUtils.hexStringToBytes(this.managerSessionKeyHex);
//    }
//
//    public Session setUserSession(HttpServletRequest request,
//                                  HttpServletResponse response,
//                                  Integer userId,
//                                  boolean remember) throws Exception {
////       HttpSession httpSession =  request.getSession();
////
////
////        long timestamp = CommonUtils.timestamp();
////
////        Session session = new Session();
////        session.setIp(CommonUtils.getRemoteAddr(request));
////        session.setLogin(timestamp);
////        //session.setActive(timestamp);
////        session.setSessonId(CommonUtils.uuid());
////        session.setUserId(userId);
////
////        if (remember) {
////            session.setExpiry(timestamp + (MAX_SESSION_TIME_OUT * 1000));
////        } else {
////            session.setExpiry(MIN_SESSION_TIME_OUT);
////        }
////
////
////        String json = JSON.toJSONString(session);
////        String cipher = CommonUtils.encodeBase64(AESUtils.encrypt(json.getBytes(StandardCharsets.UTF_8), this.userSessionkey));
////
////        this.setCookie(response, CookieKeys.USER_SESION, cipher, remember ? MAX_SESSION_TIME_OUT : MIN_SESSION_TIME_OUT);
////
////        if (remember) {
////            sessionRepository.save()
////            new RedisTemplate().opsForValue().set(RedisKeys.USER_SESION + session.getUserId() + ":" + session.getSessonId(), json, MAX_SESSION_TIME_OUT, TimeUnit.SECONDS);
////        } else {
////            this.stringRedisTemplate.opsForValue().set(RedisKeys.USER_SESION + session.getUserId() + ":" + session.getSessonId(), json, 30, TimeUnit.MINUTES);
////        }
////
////        Session existsSession = this.getUserSession(request);
////        if (existsSession != null) {
////            this.stringRedisTemplate.delete(RedisKeys.USER_SESION + existsSession.getUserId() + ":" + existsSession.getSessonId());
////        }
////
////        return session;
//    }
//
//    public void removeUserSession(HttpServletRequest request, HttpServletResponse response) {
//        Cookie cookie = WebUtils.getCookie(request, CookieKeys.USER_SESION);
//        if (cookie != null) {
//            cookie.setDomain(this.hostName);
//            cookie.setMaxAge(0);
//            cookie.setPath("/");
//            response.addCookie(cookie);
//        }
//    }
//
//    public Session getUserSession(HttpServletRequest request) {
//        Cookie cookie = WebUtils.getCookie(request, CookieKeys.USER_SESION);
//        if (cookie != null) {
//            try {
//                return JSON.parseObject(new String(AESUtils.decrypt(CommonUtils.decodeBase64(cookie.getValue()), this.userSessionkey), StandardCharsets.UTF_8), Session.class);
//            } catch (Exception e) {
//                e.printStackTrace();
//                return null;
//            }
//        }
//        return null;
//    }
//
//    public UserEntity getSessionUser(HttpServletRequest request) {
//        Session session = this.getUserSession(request);
//        if (session != null) {
//            return this.userService.queryById(session.getUserId());
//        }
//        return null;
//    }
//
//
//    //manager
//
//
//    public Session setManagerSession(HttpServletRequest request, HttpServletResponse response, Integer userId, boolean remember) throws Exception {
//
//        long timestamp = CommonUtils.timestamp();
//
//        Session session = new Session();
//        session.setIp(CommonUtils.getRemoteAddr(request));
//        session.setLogin(timestamp);
//        //session.setActive(timestamp);
//        session.setSessonId(CommonUtils.uuid());
//        session.setUserId(userId);
//
//        if (remember) {
//            session.setExpiry(timestamp + (MAX_SESSION_TIME_OUT * 1000));
//        } else {
//            session.setExpiry(MIN_SESSION_TIME_OUT);
//        }
//
//
//        String json = JSON.toJSONString(session);
//        String cipher = CommonUtils.encodeBase64(AESUtils.encrypt(json.getBytes(StandardCharsets.UTF_8), this.managerSessionKey));
//
//        this.setCookie(response, CookieKeys.MANAGER_SESSION, cipher, remember ? MAX_SESSION_TIME_OUT : MIN_SESSION_TIME_OUT);
//
//        if (remember) {
//            this.stringRedisTemplate.opsForValue().set(RedisKeys.MANAGER_SESSION + session.getUserId() + ":" + session.getSessonId(), json, MAX_SESSION_TIME_OUT, TimeUnit.SECONDS);
//        } else {
//            this.stringRedisTemplate.opsForValue().set(RedisKeys.MANAGER_SESSION + session.getUserId() + ":" + session.getSessonId(), json, 30, TimeUnit.MINUTES);
//        }
//
//        Session existsSession = this.getManagerSession(request);
//        if (existsSession != null) {
//            this.stringRedisTemplate.delete(RedisKeys.MANAGER_SESSION + existsSession.getUserId() + ":" + existsSession.getSessonId());
//        }
//
//        return session;
//    }
//
//    public Session getManagerSession(HttpServletRequest request) {
//        Cookie cookie = WebUtils.getCookie(request, CookieKeys.MANAGER_SESSION);
//        if (cookie != null) {
//            try {
//                return JSON.parseObject(new String(AESUtils.decrypt(CommonUtils.decodeBase64(cookie.getValue()), this.managerSessionKey), StandardCharsets.UTF_8), Session.class);
//            } catch (Exception e) {
//                e.printStackTrace();
//                return null;
//            }
//        }
//        return null;
//    }
//
//
//    //common
//
//
//    public void setCookie(HttpServletResponse response, String key, String value, int maxAge) {
//        Cookie cookie = new Cookie(key, value);
//        cookie.setMaxAge(maxAge);
//        cookie.setDomain(this.hostName);
//        cookie.setHttpOnly(true);
//        cookie.setSecure(this.sslEnable);
//        cookie.setPath("/");
//        response.addCookie(cookie);
//    }
//
//    //移除所有session
//    public void removeAllSession(Integer userId) {
//        Set<String> keys = this.stringRedisTemplate.keys(RedisKeys.USER_SESION + userId + ":" + "*");
//        this.stringRedisTemplate.delete(keys);
//
//        keys = this.stringRedisTemplate.keys(RedisKeys.MANAGER_SESSION + userId + ":" + "*");
//        this.stringRedisTemplate.delete(keys);
//    }
//
//    //移除其他session
//    public void removeOtherSession(HttpServletRequest request) {
//
//        //尝试获取登录用户
//        Session userSession = this.getUserSession(request);
//        if (userSession != null) {
//            Set<String> keys = this.stringRedisTemplate.keys(RedisKeys.USER_SESION + userSession.getUserId() + ":" + "*");
//            for (String key : keys) {
//                if (!key.equals(RedisKeys.USER_SESION + userSession.getUserId() + ":" + userSession.getSessonId())) {
//                    this.stringRedisTemplate.delete(key);
//                }
//            }
//        }
//
//        //尝试获取管理员用户
//        Session managerSession = this.getManagerSession(request);
//        if (managerSession != null) {
//            Set<String> keys = this.stringRedisTemplate.keys(RedisKeys.MANAGER_SESSION + managerSession.getUserId() + ":" + "*");
//            for (String key : keys) {
//                if (!key.equals(RedisKeys.MANAGER_SESSION + managerSession.getUserId() + ":" + managerSession.getSessonId())) {
//                    this.stringRedisTemplate.delete(key);
//                }
//            }
//        }
//
//        //TODO，尝试踢出在线聊天室的其他同号登录用户
//    }
}









