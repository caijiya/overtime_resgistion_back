package co.javaweb.overtime_resgistion.controller;

import co.javaweb.overtime_resgistion.common.Message;
import co.javaweb.overtime_resgistion.entity.Employee;
import co.javaweb.overtime_resgistion.respository.EmployeeRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;


    @GetMapping
    public Message getOverTimeList(Employee employee, HttpServletRequest request, HttpServletResponse response) throws IOException {
        int pageNum = employee.getPage();
        int pageSize = employee.getLimit();
        //@Todo jpa动态查询，劝后人不要用这个，花里胡哨浪费时间，mybatis天下第一
        Pageable pageable = new PageRequest(pageNum - 1, pageSize);
        Page<Employee> employees = employeeRepository.findAll((Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            List<Predicate> list = new ArrayList<Predicate>();
            if (StringUtils.isNoneEmpty(employee.getName())) {
                Predicate namePredicate = criteriaBuilder.equal(root.get("name"), employee.getName());
                list.add(namePredicate);
            }
            if (StringUtils.isNoneEmpty(employee.getSex())) {
                Predicate sexPredicate = criteriaBuilder.equal(root.get("sex"), employee.getSex());
                list.add(sexPredicate);
            }
            if (list.size() == 0) {
                return null;
            }
            Predicate[] p = new Predicate[list.size()];
            return criteriaBuilder.and(list.toArray(p));
        }, pageable);
        Message message = Message.successForLayui(employees.getContent(), employees.getTotalElements());

        return message;
    }
}
