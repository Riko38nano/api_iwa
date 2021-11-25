package api.database.account.controllers;

import api.database.account.models.Authorities;
import api.database.account.models.User;
import api.database.account.repositories.AuthoritiesRepository;
import api.database.account.repositories.UserRepository;
import api.database.account.util.OnCreateUserEvent;
import org.keycloak.KeycloakSecurityContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
//@EnableWebSecurity
@RequestMapping("/api/users")
public class UsersController {

    // Keycloak
    @Autowired
    private HttpServletRequest request;

    private void configCommonAttributes(Model model) {
        model.addAttribute("name", getKeycloakSecurityContext().getIdToken().getGivenName());
    }

    private KeycloakSecurityContext getKeycloakSecurityContext() {
        return (KeycloakSecurityContext) request.getAttribute(KeycloakSecurityContext.class.getName());
    }

    @GetMapping(value = "/list")
    public String getBooks(Model model) {
        configCommonAttributes(model);
        model.addAttribute("users", userRepository.findAll());
        return "list";
    }


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthoritiesController authoritiesController;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @GetMapping
    @Secured("ROLE_ADMIN")
    public List<User> list() {
        return userRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public User get(@PathVariable Long id) {
        if (!userRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Users with id:" + id + "not found");
        }
        return userRepository.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody final User user) {
        // Encrypt password
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User newUser = userRepository.saveAndFlush(user);

        eventPublisher.publishEvent(new OnCreateUserEvent("/", user));

        // create an authority object
        Authorities auth = new Authorities(user.getUsername(), "ROLE_USER");
        authoritiesController.create(auth);

        return newUser;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        userRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public User update(@PathVariable Long id, @RequestBody User user) {
        //if(!user.isSet()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User is laking in attributes");
        User existingUser = userRepository.getById(id);
        BeanUtils.copyProperties(user, existingUser, "user_id");
        return userRepository.saveAndFlush(existingUser);
    }
}
