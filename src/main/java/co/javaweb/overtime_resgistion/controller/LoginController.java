package co.javaweb.overtime_resgistion.controller;

import co.javaweb.overtime_resgistion.annotation.IgnoreLogin;
import co.javaweb.overtime_resgistion.common.Message;
import co.javaweb.overtime_resgistion.common.Messages;
import co.javaweb.overtime_resgistion.dao.EmployeeDao;
import co.javaweb.overtime_resgistion.entity.mybatis.Employee;
import co.javaweb.overtime_resgistion.helper.SessionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

@RestController
public class LoginController {
    //    @Autowired
//    EmployeeRepository employeeRepository;
    @Autowired
    SessionHelper sessionHelper;

    @Autowired
    EmployeeDao employeeDao;

    @PostMapping("/login")
    @IgnoreLogin
    public Message login(HttpServletRequest request, HttpServletResponse response,
                         @RequestBody Employee employee) throws IOException {
        String employee_name = employee.getName();
        String employee_password = employee.getPassword();
        HttpSession session = request.getSession(Boolean.TRUE);
        session.setMaxInactiveInterval(900);
        session.setAttribute("username", Base64.getEncoder().encodeToString(employee_name.getBytes("utf-8")));
        if (StringUtils.isEmpty(employee_name) || StringUtils.isEmpty(employee_password)) {
            return Messages.LOGIN_FAILED;
        }
        List<Employee> employeeList = employeeDao.findByExample(employee);
//        List<Employee2> employee2List = employeeRepository.findByNameAndPassword(employee_name, employee_password);
        if (employeeList.size() <= 0) {
            return Messages.LOGIN_FAILED;
        }
        sessionHelper.setCookie(response, "userid", String.valueOf(employeeList.get(0).getEmployee_id()));
        sessionHelper.setCookie(response, "username", Base64.getEncoder().encodeToString(employee_name.getBytes("utf-8")));
        return Messages.SUCCESS;
    }

    @GetMapping("/logout")
    public Message logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return Messages.NOT_LOGED;
    }
}