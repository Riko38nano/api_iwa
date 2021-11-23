package api.database.covid_alert.repositories;

import api.database.covid_alert.models.AlertCovid;
import api.database.covid_alert.models.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccineRepository extends JpaRepository<Vaccine, Long> {
    Vaccine findByUsername(String username);
}
