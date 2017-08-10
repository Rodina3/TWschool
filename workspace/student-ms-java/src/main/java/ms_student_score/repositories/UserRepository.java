package ms_student_score.repositories;

import ms_student_score.core.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by rzhou on 10/08/2017.
 */
public interface UserRepository extends CrudRepository<User, Long> {
    User findByName(String name);
    User findByNameAndAge(String name, Integer age);
}
