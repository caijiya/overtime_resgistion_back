package co.javaweb.overtime_resgistion;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Repository;

@SpringBootApplication
@EnableJpaAuditing
@ServletComponentScan(basePackages = "co.javaweb")
@MapperScan(basePackages = "co.javaweb.overtime_resgistion.dao", annotationClass = Repository.class)
public class OvertimeResgistionApplication {

    public static void main(String[] args) {
        SpringApplication.run(OvertimeResgistionApplication.class, args);
    }
}
