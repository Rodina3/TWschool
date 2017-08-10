package ms_student_score.controller;

import ms_student_score.core.User;
import ms_student_score.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.*;

/**
 * Created by rzhou on 10/08/2017.
 */
@CrossOrigin(origins = "*")
@RestController
@EntityScan("ms_student_score.core")
@EnableJpaRepositories("ms_student_score.repositories")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value="/users", method = RequestMethod.POST)
    public User saveUser(@RequestBody User user){
        userRepository.save(user);
        return user;
    }

    @RequestMapping(value="/users",method = RequestMethod.GET)
    public Iterable<User> findAll(){
        return userRepository.findAll();
    }

    @RequestMapping(value="users/{name}",method = RequestMethod.GET)
    public User findUserById(@PathVariable ("name") String name){
        return userRepository.findByName(name);
    }
}
