package api.database.covid_alert.controllers;


import api.database.covid_alert.models.AlertCovid;
import api.database.covid_alert.models.Vaccine;
import api.database.covid_alert.repositories.CovidAlertRepository;
import api.database.covid_alert.repositories.VaccineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AlertCovidController {

    @Autowired
    private CovidAlertRepository covidAlertRepository;

    @Autowired
    private VaccineRepository vaccineRepository;

    @GetMapping("/alert/{username}")
    public AlertCovid get(@PathVariable String username) {
        return covidAlertRepository.findByUsername(username);
    }

    @PostMapping("/doVaccine")
    public Vaccine getVaccinated(@RequestParam String username) {
        Vaccine newVaccine = new Vaccine();
        newVaccine.setUsername(username);
        return vaccineRepository.saveAndFlush(newVaccine);
    }

}
