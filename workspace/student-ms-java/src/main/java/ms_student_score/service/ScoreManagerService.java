package ms_student_score.service;

import ms_student_score.core.Klass;
import ms_student_score.core.Report;
import ms_student_score.core.Scores;
import ms_student_score.core.Student;
import org.springframework.stereotype.Service;

/**
 * Created by rzhou on 07/08/2017.
 */
@Service
public class ScoreManagerService {

    private Manager manager = new Manager();

    public Student addStudent(Student student) {
        manager.addStudent(student);
        return student;
    }


    public Report buildReport() {
        return manager.buildAllReport();
    }

    public Klass getAllStudents() {
        return manager.getAllStudents();
    }

    public Student getStudentById(String id) {
        return manager.getStudentById(id);
    }

    public Scores putStudentScoresById(Scores scores) {
        return manager.modifyStudentScoresById(scores);
    }
}
