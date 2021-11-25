package api.database.account.controllers;

import api.database.account.models.User;
import api.database.account.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.function.Function;

@Controller
public class ViewController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UsersController usersController;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private HttpServletRequest request;

    /**
     * index page
     * @return page reference
     */
    @GetMapping({"/", "/index"})
    public String home() {return "index";}

    @GetMapping("/login")
    public String login() {return "login";}

    @GetMapping("/register")
    public String register() {return "register";}

    @PostMapping("/doRegister")
    public String register(@Valid @ModelAttribute("users") User user, BindingResult result) {
        if(userRepository.existsUserByUsername(user.getUsername())){
            return "register.jsp?user=true";
        }
        else {
            usersController.create(user);
            return "login";
        }
    }

    @GetMapping("/userConfirm")
    public String confirm() {return "userConfirm";}

    @GetMapping("/forgetPassword")
    public String forgetPage() {return "forgetPassword";}

    @GetMapping("/didForgetPass")
    public String forget(@RequestParam String username, @RequestParam String email) {
        User userDB = userRepository.findByUsername(username);
        if((userDB.getUsername().equals(username)) && (userDB.getEmail().equals(email))) {
            // Send email with link below
            return "forgetPassword.jsp?confirm=true&username=" + username;
        } else {
            return "forgetPassword.jsp?error=true";
        }
    }

    @PostMapping("/confirmNewPass")
    public String confirmPass(@RequestParam String username, @RequestParam String password) {
        User existingUser = userRepository.findByUsername(username);
        existingUser.setPassword(passwordEncoder.encode(password));
        userRepository.saveAndFlush(existingUser);

        return "index";
    }

    @GetMapping("/changeUser")
    public String changeUser() {return "changeUser";}

    @GetMapping("listUsers")
    public String listUsers() {return "listUsers";}
}
