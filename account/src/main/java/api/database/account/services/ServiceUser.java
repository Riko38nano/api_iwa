package api.database.account.services;

import api.database.account.models.User;
import api.database.account.models.VerificationToken;
import api.database.account.repositories.UserRepository;
import api.database.account.repositories.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Calendar;
import java.util.Date;

@Service
public class ServiceUser {


    @Autowired
    private VerificationTokenRepository verificationTokenRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/userConfirm")
    public String confirmUser(@RequestParam("token") String token) {
        VerificationToken verifToken = verificationTokenRepository.getById(Long.parseLong(token));

        System.out.println("USER CONFIRMED SERVICE");

        if(verifToken != null) {
            Date date = Calendar.getInstance().getTime();
            if(date.before(verifToken.getExpiryDate())) {
                verificationTokenRepository.delete(verifToken);
                User user = userRepository.findByUsername(verifToken.getUsername());

                user.setEnabled(true);
                userRepository.saveAndFlush(user);
                return "login.jsp?confirm=true";
            }
            else {
                verificationTokenRepository.delete(verifToken);
                return "register.jsp?expired=true";
            }
        }
        else {
            return "register.jsp?confirm=false";
        }
    }
}
