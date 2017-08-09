package ms_student_score.service;

import ms_student_score.core.Klass;
import ms_student_score.core.Report;
import ms_student_score.core.ReportBuilder;
import ms_student_score.core.Student;
import ms_student_score.view.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by rzhou on 06/08/2017.
 */
public class Manager {
    private Klass klass = new Klass();
    private ReportBuilder reportBuilder = new ReportBuilder();

    public void addStudent(Student student) {
        klass.addStudent(student);
    }

    public Klass getKlass() {
        return klass;
    }

    public Report buildReport(List<String> studentIds) {
        return reportBuilder.buildReport(studentIds, this.klass);
    }

    public Report buildAllReport() {
        List<String> studentIds = new ArrayList<>();
        for (int i = 0; i < klass.getStudentList().size(); i++) {
            studentIds.add(klass.getStudentList().get(i).getId());
        }
        return reportBuilder.buildReport(studentIds, this.klass);
    }

    public Student findStudentById(int id) {
        Student student = new Student();
        for (int i = 0; i < klass.getStudentList().size(); i++) {
            if (Integer.parseInt(klass.getStudentList().get(i).getId()) == id) {
                return klass.getStudentList().get(i);
            }
        }
        return null;
    }

    public Student modifyStudentScoresById(int id, Map<String, Integer> scores) {
        Student student = findStudentById(id);
        if (student != null){
            student.setScores(scores);
        }
       return student;
    }
}
