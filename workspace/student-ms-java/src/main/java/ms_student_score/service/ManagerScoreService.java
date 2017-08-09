package ms_student_score.service;

import ms_student_score.core.Klass;
import ms_student_score.core.Report;
import ms_student_score.core.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rzhou on 07/08/2017.
 */
@Service
public class ManagerScoreService {

    private Manager manager = new Manager();

    public Student addStudent(Student student) {
        manager.addStudent(student);
        return student;
    }


    public Report buildReport() {
        return manager.buildAllReport();
    }

    public Klass getAllStudents() {
        return manager.getKlass();
    }

    public Student getStudentById(int id) {
        return manager.findStudentById(id);
    }
}
