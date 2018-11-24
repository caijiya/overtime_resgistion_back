package co.javaweb.overtime_resgistion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class OvertimeResgistionApplication {

    public static void main(String[] args) {
        SpringApplication.run(OvertimeResgistionApplication.class, args);
    }
}
