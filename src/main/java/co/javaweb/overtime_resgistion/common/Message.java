package co.javaweb.overtime_resgistion.common;

import java.io.Serializable;


public class Message<T> implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -6762701438056075460L;

    private boolean success;

    private int code;

    private String message;

    private T data;

    public Message() {
    }

    public Message(boolean success, int code, String message, T data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> Message<T> success(T data) {
        return new Message<>(true, Code.SUCCESS, "ok", data);
    }

    public static Message<Void> fail(int code, String message) {
        return new Message<>(false, code, message, null);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Message [success=" + success + ", code=" + code + ", message=" + message + ", data=" + data + "]";
    }

    public static interface Code {

        //成功
        int SUCCESS = 0;

        //未登录
        int NOT_LOGED = 1001;

        //会话超时
        int SESSION_TIME_OUT = 1002;

        //参数缺失
        int MISSING_PARAM = 1003;

        //账户被禁用
        int DISABLE_ACCOUNT = 1004;

        //登录失败
        int LOGIN_FAILED = 1005;

        //参数校验失败
        int BAD_PARAM = 1006;

        //非法请求
        int BAD_REQUEST = 1007;

        //请求路径不存在
        int BAD_URL = 1008;

        //数据已经存在
        int EXISTS = 1009;

        //数据未找到
        int NOT_FOUND = 1010;

        //权限不足
        int INSUFFICIENT_PERMISSIONS = 1011;

        //请求频繁
        int REQUEST_FREQUENT = 1012;

        //缺少验证码参数
        int MISSING_CAPTCHA_PARAM = 1013;

        //邮箱未验证
        int MAILBOX_IS_NOT_VERIFIED = 1014;

        //系统异常
        int SYSTEM_ERROR = 9999;
    }
}







