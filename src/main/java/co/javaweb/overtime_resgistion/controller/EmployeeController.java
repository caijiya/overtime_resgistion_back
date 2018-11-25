package co.javaweb.overtime_resgistion.controller;

import co.javaweb.overtime_resgistion.common.Message;
import co.javaweb.overtime_resgistion.entity.Employee;
import co.javaweb.overtime_resgistion.respository.EmployeeRepository;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/getOverTimeList")
    public Message login(HttpServletRequest request, HttpServletResponse response
    ) {
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        if (StringUtils.isEmpty(page) || StringUtils.isEmpty(limit)) {
            List<Employee> employeeList = employeeRepository.findAll();
            return Message.success(employeeList);
        }
        int pageNum = Integer.parseInt(request.getParameter("page"));
        int pageSize = Integer.parseInt(request.getParameter("limit"));
        Pageable pageable = new PageRequest(pageNum - 1, pageSize);
        Page<Employee> employees = employeeRepository.findAll(pageable);
        Message ss = Message.successHasCount(employees.getContent(), employees.getTotalElements());
        System.out.println(JSON.toJSONString(ss));
        return ss;
    }
}
