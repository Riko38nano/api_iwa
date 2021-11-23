package api.database.covid_alert.repositories;

import api.database.covid_alert.models.AlertCovid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CovidAlertRepository extends JpaRepository<AlertCovid, Long> {
    AlertCovid findByUsername(String username);
}
