package co.javaweb.overtime_resgistion.support;

import co.javaweb.overtime_resgistion.entity.Employee2;

public class SessionHolder {
    public static final ThreadLocal<Employee2> EMPLOYEE = new ThreadLocal<>();
}
