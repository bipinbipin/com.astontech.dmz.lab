package app.bootstrap;

import app.domain.User;
import app.repositories.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by Bipin on 11/17/2016.
 */
@Component
public class SeedData implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UserRepository userRepository;

    private Logger log = Logger.getLogger(SeedData.class);

//    @Value("${seed.database}")
    private boolean seedDb = true;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(seedDb) {
            genUsers();
        }
    }

    public void genUsers() {
        User user1 = new User("bipin", "123", "$1207.73");
        User user2 = new User("cody", "123", "$999.73");
        User user3 = new User("erick", "123", "$421.73");
        User user4 = new User("chris", "123", "$231.73");

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);
    }
}