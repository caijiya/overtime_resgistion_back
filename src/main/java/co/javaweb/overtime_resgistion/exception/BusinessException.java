package co.javaweb.overtime_resgistion.exception;


import co.javaweb.overtime_resgistion.common.Message;

public class BusinessException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 3152753787643556039L;

    private Message<Void> message;

    public BusinessException(int code, String message) {
        super(message);
        this.message = new Message<>(false, code, message, null);
    }

    public BusinessException(Message<Void> message) {
        super(message.getMessage());
        this.message = message;
    }

    public Message<Void> message() {
        return this.message;
    }
}
