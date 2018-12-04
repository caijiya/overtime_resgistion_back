package co.javaweb.overtime_resgistion.dao;

import co.javaweb.overtime_resgistion.entity.mybatis.Apply;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplyDao {

    int save(Apply apply);


    List<Apply> findByExample(Apply apply);
}
