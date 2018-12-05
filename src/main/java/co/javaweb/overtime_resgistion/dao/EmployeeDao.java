package co.javaweb.overtime_resgistion.dao;

import co.javaweb.overtime_resgistion.entity.mybatis.Employee;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeDao {
    int create(Employee employee);

    //    @Delete("DELETE FROM `employee` WHERE `employee_id` = #{employee_id};")
    int deleteById(@Param("employee_id") Integer employee_id);

    List<Employee> findByExample(Employee employee);
}
