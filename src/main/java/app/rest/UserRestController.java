package app.rest;

import app.domain.User;
import app.repositories.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Bipin on 11/18/2016.
 */
@RestController
@RequestMapping("/api/user")
public class UserRestController {

    private Logger log = Logger.getLogger(UserRestController.class);

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value ="/", method = RequestMethod.GET)
    public Iterable<User> userGetAll() {
        return userRepository.findAll();
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public User userGetById(@PathVariable String name) {
        log.info("############################");
        log.info("USER BALANCE REQUEST:   "  + name);
        log.info("############################");
        return userRepository.findByName(name);
    }
}
