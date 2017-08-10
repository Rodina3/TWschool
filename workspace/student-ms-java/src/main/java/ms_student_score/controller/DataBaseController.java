package ms_student_score.controller;

import ms_student_score.core.*;
import ms_student_score.service.DataBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by rzhou on 10/08/2017.
 */
@CrossOrigin(origins = "*")
@RestController
@EntityScan("ms_student_score.core")
@EnableJpaRepositories("ms_student_score.repositories")
public class DataBaseController {
    @Autowired
    private DataBaseService service;


    @RequestMapping(value = "db/students", method = RequestMethod.POST)
    public Student addStudent(@RequestBody Student student) {
        return service.addStudent(student);
    }

    @RequestMapping(value = "db/students/{id}", method = RequestMethod.GET)
    public Student findStudentById(@PathVariable("id") String id) {
        return service.findStudentById(id);
    }

    @RequestMapping(value = "db/students", method = RequestMethod.GET)
    public List<Student> findAllStudents() {
        return service.findAllStudents();
    }


    @RequestMapping(value = "db/students/scores", method = RequestMethod.PUT)
    public ResponseEntity<Scores> addStudentScores(@RequestBody Scores scores) {
        Scores grade = service.addStudentScores(scores);
        if (grade != null) {
            return new ResponseEntity<Scores>(grade, HttpStatus.OK);
        } else
            return new ResponseEntity<Scores>((Scores) null, HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "db/report", method = RequestMethod.GET)
    public Report buildReport() {
        return service.buildReport();
    }
}
