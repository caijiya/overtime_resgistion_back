package co.javaweb.overtime_resgistion.support;

import co.javaweb.overtime_resgistion.entity.Employee;

public class SessionHolder {
    public static final ThreadLocal<Employee> EMPLOYEE = new ThreadLocal<>();
}
