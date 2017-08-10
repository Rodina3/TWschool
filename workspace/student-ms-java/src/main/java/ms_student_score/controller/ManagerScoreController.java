package ms_student_score.controller;
import ms_student_score.core.Klass;
import ms_student_score.core.Report;
import ms_student_score.core.ScoreSheet;
import ms_student_score.core.Student;
import ms_student_score.service.ManagerScoreMemoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Created by rzhou on 07/08/2017.
 */
@CrossOrigin(origins = "*")
@RestController
public class ManagerScoreController {
    private int id = 1;

    @Autowired
    private ManagerScoreMemoryService serv;


    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public ResponseEntity<Student> addStudentInfo(@RequestBody Student student) {
        student.setId(id + "");
        id++;
        return new ResponseEntity<Student>(serv.addStudent(student), HttpStatus.OK);
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public ResponseEntity<Klass> getAllStudents() {
        Klass klass = serv.getAllStudents();
        return new ResponseEntity<Klass>(klass, HttpStatus.OK);
    }

    @RequestMapping(value = "/report", method = RequestMethod.GET)
    public ResponseEntity<Report> buildReport() {
        return new ResponseEntity<Report>(serv.buildReport(), HttpStatus.OK);
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
    public ResponseEntity<Student> getStudentById(@PathVariable("id") String id) {
        Student student = serv.getStudentById(id);
        if (student != null) {
            return new ResponseEntity<Student>(student, HttpStatus.OK);
        } else
            return new ResponseEntity<Student>((Student) null, HttpStatus.NOT_FOUND);

    }

    @RequestMapping(value="/students/{id}",method=RequestMethod.PUT)
    public ResponseEntity<ScoreSheet> putStudentScores(@PathVariable("id")String id, @RequestBody ScoreSheet grade){
        ScoreSheet scoreSheet = serv.putStudentScoresById(grade);
        if (scoreSheet !=null)
        {
            return new ResponseEntity<ScoreSheet>(scoreSheet,HttpStatus.OK);
        }
        else
            return new ResponseEntity<ScoreSheet>((ScoreSheet) null,HttpStatus.NOT_FOUND);

    }
//
//    @RequestMapping(value = "/report", method = RequestMethod.GET)
//    public ResponseEntity<String> buildReport(){
//        return ;
//    }
}


