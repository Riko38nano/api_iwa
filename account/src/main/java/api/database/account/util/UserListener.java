package api.database.account.util;

import api.database.account.models.User;
import api.database.account.models.VerificationToken;
import api.database.account.repositories.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.UUID;

public class UserListener implements ApplicationListener<OnCreateUserEvent> {
    @Override
    public void onApplicationEvent(OnCreateUserEvent event) {
        this.confirmCreateUser(event);
    }

    private String serverUrl = "http://localhost:8080";

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private VerificationTokenRepository verificationTokenRepository;

    private void confirmCreateUser(OnCreateUserEvent event) {
        User user = event.getUser();

        String token = UUID.randomUUID().toString();

        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(token);
        verificationToken.setExpiryDate(verificationToken.calculateExpiryDate(VerificationToken.EXPIRATION));
        verificationTokenRepository.saveAndFlush(verificationToken);

        // get email
        String recipientAddress = user.getEmail();
        String subject = "User 8-AWI Account Confirmation";
        String confirmationUrl = event.getAppUrl() + "userConfirm?token="+token;
        String msg = "Confirm : ";

        // Send email
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(msg + "\r\n" + serverUrl + confirmationUrl);
        mailSender.send(email);
    }
}
