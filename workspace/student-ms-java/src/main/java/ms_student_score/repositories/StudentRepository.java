package ms_student_score.repositories;

import ms_student_score.core.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by rzhou on 10/08/2017.
 */
public interface StudentRepository extends CrudRepository<Student, Long> {
    Student save(Student student);

    Student findById(String id);

    List<Student> findAll();

    List<Student> findByName(String name);
}
