package api.database.account.repositories;

import api.database.account.models.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthoritiesRepository extends JpaRepository<Authorities, Long> {
}
