package api.database.covid_alert.controllers;


import api.database.covid_alert.models.AlertCovid;
import api.database.covid_alert.repositories.CovidAlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AlertCovidController {

    @Autowired
    private CovidAlertRepository covidAlertRepository;

    @GetMapping("/alert/{username}")
    public AlertCovid get(@PathVariable String username) {
        return covidAlertRepository.findByUsername(username);
    }
}
