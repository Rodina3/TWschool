package ms_student_score.controller;

import ms_student_score.core.Klass;
import ms_student_score.core.Report;
import ms_student_score.core.Student;
import ms_student_score.service.MsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Created by rzhou on 07/08/2017.
 */

@RestController
public class MsController {

    @Autowired
    private MsService serv;

    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public ResponseEntity<Student> addStudentScore(@RequestBody Student student) {
        return serv.addStudentScore(student);
    }

    @RequestMapping(value="/students",method=RequestMethod.GET)
    public ResponseEntity<Klass> getAllStudents(){
        return serv.getAllStudents();
    }

    @RequestMapping(value="/report",method=RequestMethod.GET)
   public ResponseEntity<Report> buildReport(){
        return serv.buildReport();
    }
//
//    @RequestMapping(value="/students{id}",method=RequestMethod.PUT)
//    public ResponseEntity<Student> getStudent(@PathVariable("id")int id){
//
//    }
//
//    @RequestMapping(value="/students{id}",method=RequestMethod.DELETE)
//    public ResponseEntity<Student> getStudent(@PathVariable("id")int id){
//
//    }
//
//    @RequestMapping(value = "/report", method = RequestMethod.GET)
//    public ResponseEntity<String> buildReport(){
//        return ;
//    }
}


