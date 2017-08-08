package ms_student_score.service;

import ms_student_score.core.Klass;
import ms_student_score.core.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by rzhou on 07/08/2017.
 */
@Service
public class MsService {

    Manager manager = new Manager();

    public ResponseEntity<Student> addStudentScore(Student student) {
        manager.addStudent(student);
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }


    public ResponseEntity<String> buildReport() {
        Klass klass = manager.getKlass();
        List<String> studentIDs = new ArrayList<>();
        for (int i = 0; i < klass.getStudentList().size(); i++) {
            studentIDs.add(klass.getStudentList().get(i).getID());
        }
        return new ResponseEntity<String>(manager.buildReport(studentIDs), HttpStatus.OK);
    }

    public ResponseEntity<Klass> getAllStudents() {
        return new ResponseEntity<Klass>(manager.getKlass(), HttpStatus.OK);
    }
}
