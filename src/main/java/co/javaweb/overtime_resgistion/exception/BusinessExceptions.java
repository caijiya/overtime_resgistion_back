package co.javaweb.overtime_resgistion.exception;


import co.javaweb.overtime_resgistion.common.Messages;

public interface BusinessExceptions {

    BusinessException DISABLE_ACCOUNT = new BusinessException(Messages.DISABLE_ACCOUNT);

    BusinessException REQUEST_FREQUENT = new BusinessException(Messages.REQUEST_FREQUENT);

    BusinessException BAD_URL = new BusinessException(Messages.BAD_URL);

    BusinessException MISSING_CAPTCHA_PARAM = new BusinessException(Messages.MISSING_CAPTCHA_PARAM);

    BusinessException BAD_REQUEST = new BusinessException(Messages.BAD_REQUEST);

    BusinessException MAILBOX_IS_NOT_VERIFIED = new BusinessException(Messages.MAILBOX_IS_NOT_VERIFIED);
}
