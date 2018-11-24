package co.javaweb.overtime_resgistion.common;

public interface Messages {
    Message<Void> SUCCESS = Message.success(null);

    Message<Void> NOT_LOGED = Message.fail(Message.Code.NOT_LOGED, "未登录");

    Message<Void> SESSION_TIME_OUT = Message.fail(Message.Code.SESSION_TIME_OUT, "会话超时");

    Message<Void> DISABLE_ACCOUNT = Message.fail(Message.Code.DISABLE_ACCOUNT, "账户被禁用");

    Message<Void> LOGIN_FAILED = Message.fail(Message.Code.DISABLE_ACCOUNT, "账户名或者密码错误");

    Message<Void> BAD_REQUEST = Message.fail(Message.Code.BAD_REQUEST, "非法请求");

    Message<Void> BAD_URL = Message.fail(Message.Code.BAD_URL, "请求路径不存在");

    Message<Void> REQUEST_FREQUENT = Message.fail(Message.Code.REQUEST_FREQUENT, "请求频繁");

    Message<Void> MISSING_CAPTCHA_PARAM = Message.fail(Message.Code.MISSING_CAPTCHA_PARAM, "缺少验证码参数");

    Message<Void> BAD_PARAM = Message.fail(Message.Code.BAD_PARAM, "参数校验失败");

    Message<Void> SYSTEM_ERROR = Message.fail(Message.Code.SYSTEM_ERROR, "系统异常");

    Message<Void> INSUFFICIENT_PERMISSIONS = Message.fail(Message.Code.INSUFFICIENT_PERMISSIONS, "无权操作");

    Message<Void> MAILBOX_IS_NOT_VERIFIED = Message.fail(Message.Code.MAILBOX_IS_NOT_VERIFIED, "邮箱未验证");
}
