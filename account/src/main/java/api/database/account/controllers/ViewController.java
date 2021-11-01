package api.database.account.controllers;

import api.database.account.models.User;
import api.database.account.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.function.Function;

@Controller
public class ViewController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UsersController usersController;

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

    @GetMapping("/changeUser")
    public String changeUser() {return "changeUser";}

    @GetMapping("listUsers")
    public String listUsers() {return "listUsers";}
}
