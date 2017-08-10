package ms_student_score.controller;

import ms_student_score.core.*;
import ms_student_score.repositories.ScoresRepository;
import ms_student_score.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
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
    private StudentRepository studentRepository;
    @Autowired
    private ScoresRepository scoresRepository;


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
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }


    @RequestMapping(value = "db/students/scores", method = RequestMethod.PUT)
    public ResponseEntity<Scores> addStudentScores(@RequestBody Scores scores) {
        Student student = studentRepository.findById(scores.getId());
        if (student != null) {
            scores.setName(student.getName());
            scores.getTotalScore();
            scores.getAverage();
            scoresRepository.save(scores);
            Scores s1 = scoresRepository.findById(scores.getId());
            return new ResponseEntity<Scores>(scoresRepository.save(scores), HttpStatus.OK);
        } else
            return new ResponseEntity<Scores>((Scores) null, HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "db/report", method = RequestMethod.GET)
    public Report buildReport() {
        Klass klass = new Klass();
        ScoresCenter scoresCenter = new ScoresCenter();
        ReportBuilder reportBuilder = new ReportBuilder();
        List<Student> studentsList = studentRepository.findAll();
        List<Scores> scoresList = scoresRepository.findAll();

        for (int i = 0; i < studentsList.size(); i++) {
            klass.addStudent(studentsList.get(i));
            scoresCenter.addScoreSheet(new Scores(studentsList.get(i).getId(), 0, 0, 0, 0));
        }

        for (int i = 0; i < scoresList.size(); i++) {
            int index = scoresCenter.findScoreSheetById(scoresList.get(i).getId());
            scoresCenter.getScores().get(index).setGrade(scoresList.get(i));
        }

        List<String> studentIDs = new ArrayList<>();

        for (int i = 0; i < studentsList.size(); i++) {
            studentIDs.add(studentsList.get(i).getId());
        }

        return reportBuilder.buildReport(studentIDs, scoresCenter, klass);
    }
}
