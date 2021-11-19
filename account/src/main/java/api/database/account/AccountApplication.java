package api.database.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication
public class AccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
    }

    @RestController
    static class BootController {
        @GetMapping("/pie/{name}")
        public ResponseEntity<String> askQuestion(@PathVariable(value = "name") String name) {
            return ResponseEntity.ok("Hey " + name + ", do you like banana pie?");
        }
    }}
