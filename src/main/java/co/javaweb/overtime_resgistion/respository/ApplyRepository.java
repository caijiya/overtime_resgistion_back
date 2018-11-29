package co.javaweb.overtime_resgistion.respository;

import co.javaweb.overtime_resgistion.entity.Apply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.lang.Nullable;

public interface ApplyRepository extends JpaRepository<Apply, Long>, JpaSpecificationExecutor<Apply> {
    @Override
    Page<Apply> findAll(@Nullable Specification<Apply> specification, Pageable pageable);
}
