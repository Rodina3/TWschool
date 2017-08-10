package ms_student_score.service;

import ms_student_score.core.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rzhou on 06/08/2017.
 */
public class Manager {
    private Klass klass = new Klass();
    private ScoresCenter scoresCenter = new ScoresCenter();
    private ReportBuilder reportBuilder = new ReportBuilder();

    public void addStudent(Student student) {
        klass.addStudent(student);
        scoresCenter.addScoreSheet(new Scores(student.getId(),0,0,0,0));
    }

    public Student getStudentById(String id) {
        int index = klass.findStudentById(id);
        if (index != -1) {
            return klass.getStudentList().get(index);
        } else
            return null;
    }

    public Klass getAllStudents() {
        return klass;
    }

    public Scores modifyStudentScores(Scores scores) {
        if (klass.findStudentById(scores.getId()) != -1) {
            int index = scoresCenter.findScoreSheetById(scores.getId());
            if (index != -1) {
                scoresCenter.getScores().get(index).setGrade(scores);
            } else {
                scoresCenter.addScoreSheet(scores);
            }
            return scores;
        }
        return null;
    }

    public Report buildReport(List<String> studentIds) {
        return reportBuilder.buildReport(studentIds, scoresCenter, klass);
    }

    public Report buildAllReport() {
        List<String> studentIds = new ArrayList<>();
        for (int i = 0; i < klass.getStudentList().size(); i++) {
            studentIds.add(klass.getStudentList().get(i).getId());
        }
        return reportBuilder.buildReport(studentIds, scoresCenter, klass);
    }

}
