package ms_student_score.controller;

import ms_student_score.core.Student;
import ms_student_score.repositories.StudentRepository;
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
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping(value = "db/students", method = RequestMethod.POST)
    public Student addStudent(@RequestBody Student student) {
        studentRepository.save(student);
        return student;
    }

    @RequestMapping(value = "db/students/{id}", method = RequestMethod.GET)
    public Student findStudent(@PathVariable("id") String id) {
        return studentRepository.findById(id);
    }

    @RequestMapping(value = "db/students", method = RequestMethod.GET)
    public Iterable<Student> findAllStudents() {
        return studentRepository.findAll();
    }
}
