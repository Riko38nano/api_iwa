package api.auth.auth.repositories;

import api.auth.auth.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsUserByUsername(String username);
    User findByUsername(String username);
}
