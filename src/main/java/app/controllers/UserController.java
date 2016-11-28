package app.controllers;

import app.domain.User;
import app.repositories.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Bipin on 11/17/2016.
 */
@Controller
public class UserController {

    private Logger log = Logger.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

//    @Value("${middle.tier.resource.url}")
    private String ResourceURL = "http://middle.hrapp.com:9000/api/user/";

    @RequestMapping("/user")
    public String indexPage(Model model) {
        model.addAttribute("user", new User());

        return "index";
    }

    @RequestMapping(value="/user", method = RequestMethod.POST)
    public String userPost(User user, Model model){
        log.info(user.toString());
        //User foundUser = userRepository.findByName(user.getName());
        RestTemplate restTemplate = new RestTemplate();
        User foundUser = restTemplate.getForObject(ResourceURL + user.getName(), User.class);
        if(foundUser == null) {
            log.info("User not found!");
            model.addAttribute("balance", "User not found!!");
        } else {
            log.info(foundUser.toString());
            model.addAttribute("balance", foundUser.getBalance());
        }

        return "index";
    }
}
