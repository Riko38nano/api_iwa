package api.database.account.controllers;

import api.database.account.models.Authorities;
import api.database.account.repositories.AuthoritiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthoritiesController {
    @Autowired
    private AuthoritiesRepository authoritiesRepository;

    @ResponseStatus(HttpStatus.CREATED)
    public Authorities create(@RequestBody final Authorities auth) {
        return authoritiesRepository.saveAndFlush(auth);
    }
}
