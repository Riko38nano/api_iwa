package api.database.covid_alert.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    @GetMapping("/vaccine")
    public String vaccine() {
        return "vaccine";
    }
}
