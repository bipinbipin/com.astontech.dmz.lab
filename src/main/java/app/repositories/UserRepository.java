package app.repositories;

import app.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Bipin on 11/17/2016.
 */
public interface UserRepository extends CrudRepository<User, Integer> {

    User findByName(String name);
}
