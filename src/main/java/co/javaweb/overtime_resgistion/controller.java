package co.javaweb.overtime_resgistion;

import co.javaweb.overtime_resgistion.common.Messages;
import co.javaweb.overtime_resgistion.entity.Employee;
import co.javaweb.overtime_resgistion.respository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class controller {
    @Autowired
    EmployeeRepository employeeRepository;

    @PostMapping("/login")
    public Object login( HttpServletResponse response,
                        @RequestBody Employee employee) {
        String employee_name = employee.getName();
        String employee_password = employee.getPassword();
        if (StringUtils.isEmpty(employee_name) || StringUtils.isEmpty(employee_password)) {
            return Messages.LOGIN_FAILED;
        }
        List<Employee> employeeList = employeeRepository.findByNameAndPassword(employee_name, employee_password);
        Cookie cookie = new Cookie("employee_name", "employee_name");
        cookie.setMaxAge(3600);
        response.addCookie(cookie);
        return Messages.SUCCESS;
    }
}
