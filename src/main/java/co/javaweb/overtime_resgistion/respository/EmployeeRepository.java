package co.javaweb.overtime_resgistion.respository;

import co.javaweb.overtime_resgistion.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByNameAndPassword(String name, String password);

//    Page<Employee> findAll(Pageable pageable);


}
