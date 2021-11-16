package api.database.account.controllers;

import api.database.account.models.User;
import api.database.account.models.VerificationToken;
import api.database.account.repositories.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VerifTokenController {

    @Autowired
    private VerificationTokenRepository verificationTokenRepository;


    @PostMapping("/confirmUser")
    public VerificationToken associateWith(@RequestParam User user, @RequestParam VerificationToken token) {
        token.setUsername(user.getUsername());
        return verificationTokenRepository.saveAndFlush(token);
    }

}
