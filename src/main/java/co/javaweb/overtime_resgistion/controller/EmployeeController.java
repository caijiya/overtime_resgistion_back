package co.javaweb.overtime_resgistion.controller;

import co.javaweb.overtime_resgistion.annotation.IgnoreLogin;
import co.javaweb.overtime_resgistion.common.Message;
import co.javaweb.overtime_resgistion.dao.EmployeeDao;
import co.javaweb.overtime_resgistion.entity.mybatis.Employee;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
    //    @Autowired
//    EmployeeRepository employeeRepository;
    @Autowired
    EmployeeDao employeeDao;

    @IgnoreLogin
    @GetMapping
    public Message getOverTimeList(Employee employee, HttpServletRequest request, HttpServletResponse response) throws IOException {
        int pageNum = employee.getPage();
        int pageSize = employee.getLimit();
//        PageHelper.startPage(pageNum, pageSize);
        List<Employee> list = employeeDao.findByExample(employee);
        PageInfo<Employee> pageInfo = new PageInfo<>(list);
        Message message = Message.successForLayui(pageInfo.getList(), pageInfo.getTotal());

        //@Todo jpa动态查询，劝后人不要用这个，花里胡哨浪费时间，mybatis天下第一
//        Pageable pageable = new PageRequest(pageNum - 1, pageSize);
//        Page<Employee2> employees = employeeRepository.findAll((Root<Employee2> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
//            List<Predicate> list = new ArrayList<>();
//            if (StringUtils.isNoneEmpty(employee2.getName())) {
//                Predicate namePredicate = criteriaBuilder.equal(root.get("name"), employee2.getName());
//                list.add(namePredicate);
//            }
//            if (StringUtils.isNoneEmpty(employee2.getSex())) {
//                Predicate sexPredicate = criteriaBuilder.equal(root.get("sex"), employee2.getSex());
//                list.add(sexPredicate);
//            }
//            if (list.size() == 0) {
//                return null;
//            }
//            Predicate[] p = new Predicate[list.size()];
//            return criteriaBuilder.and(list.toArray(p));
//        }, pageable);
//        Message message = Message.successForLayui(employees.getContent(), employees.getTotalElements());

        return message;
    }
}
