package api.database.account.repositories;

import api.database.account.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsUserByUsername(String username);
    User findByUsername(String username);
}
