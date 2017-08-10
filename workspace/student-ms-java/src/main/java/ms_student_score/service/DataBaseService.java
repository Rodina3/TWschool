package ms_student_score.service;

import ms_student_score.core.*;
import ms_student_score.repositories.ScoresRepository;
import ms_student_score.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rzhou on 10/08/2017.
 */
@Service
public class DataBaseService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ScoresRepository scoresRepository;

    public Student addStudent(Student student) {
        studentRepository.save(student);
        return student;
    }

    public Student findStudentById(String id) {
        return studentRepository.findById(id);
    }

    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    public Scores addStudentScores(Scores scores) {
        Student student = studentRepository.findById(scores.getId());
        if (student != null) {
            scores.setName(student.getName());
            scores.getTotalScore();
            scores.getAverage();
            scoresRepository.save(scores);
            return scoresRepository.findById(scores.getId());
        } else
            return null;
    }

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
