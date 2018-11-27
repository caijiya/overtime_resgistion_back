package co.javaweb.overtime_resgistion.respository;

import co.javaweb.overtime_resgistion.entity.SessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<SessionEntity, String> {
}
