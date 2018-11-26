package co.javaweb.overtime_resgistion.respository;

import co.javaweb.overtime_resgistion.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.lang.Nullable;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long>, JpaSpecificationExecutor<Employee> {
    List<Employee> findByNameAndPassword(String name, String password);

    @Override
    Page<Employee> findAll(@Nullable Specification<Employee> specification, Pageable pageable);



}
