package ms_student_score.service;

import ms_student_score.core.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rzhou on 06/08/2017.
 */
public class Manager {
    private Klass klass = new Klass();
    private GradeCenter gradeCenter = new GradeCenter();
    private ReportBuilder reportBuilder = new ReportBuilder();

    public void addStudent(Student student) {
        klass.addStudent(student);
    }

    public Klass getAllStudents() {
        return klass;
    }

    public Report buildReport(List<String> studentIds) {
        return reportBuilder.buildReport(studentIds, gradeCenter);
    }

    public Report buildAllReport() {
        List<String> studentIds = new ArrayList<>();
        for (int i = 0; i < klass.getStudentList().size(); i++) {
            studentIds.add(klass.getStudentList().get(i).getId());
        }
        return reportBuilder.buildReport(studentIds, gradeCenter);
    }

    public ScoreSheet modifyStudentScoresById(ScoreSheet scoreSheet) {
        int index = gradeCenter.findScoreSheetById(scoreSheet.getId());
        if (index != -1) {
            gradeCenter.getScoreSheet().get(index).setGrade(scoreSheet);
            return scoreSheet;

        } else
            return null;
    }

    public Student findStudentById(String id) {
        int index = klass.findStudentById(id);
        if (index != -1){
            return klass.getStudentList().get(index);
        }
        else
            return null;
    }
}
