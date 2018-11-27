package co.javaweb.overtime_resgistion.support;

import java.io.Serializable;

public class Session implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -5616487809926474823L;

    //用户id
    private Integer userId;

    //session id
    private String sessonId;

    //登录时间
    private long login;

    //最后活跃
    @Deprecated
    private long active;

    //过期时间
    private long expiry;

    //登录io
    private String ip;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSessonId() {
        return sessonId;
    }

    public void setSessonId(String sessonId) {
        this.sessonId = sessonId;
    }

    public long getLogin() {
        return login;
    }

    public void setLogin(long login) {
        this.login = login;
    }

    @Deprecated
    public long getActive() {
        return active;
    }

    @Deprecated
    public void setActive(long active) {
        this.active = active;
    }

    public long getExpiry() {
        return expiry;
    }

    public void setExpiry(long expiry) {
        this.expiry = expiry;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Session() {
    }
}
