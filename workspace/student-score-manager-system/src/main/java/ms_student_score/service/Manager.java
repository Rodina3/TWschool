package ms_student_score.service;

import ms_student_score.core.Klass;
import ms_student_score.core.Report;
import ms_student_score.core.Student;
import ms_student_score.view.*;

import java.util.List;

/**
 * Created by rzhou on 06/08/2017.
 */
public class Manager {
    private Klass klass =new Klass();
    private String studentScoresItem;

    private void buildStudentItems(List<String> studentIDs) {
        StringBuilder studentItem = new StringBuilder();

        for (int i = 0; i < studentIDs.size(); i++) {
            int index = findStudentById(studentIDs.get(i));

            if (index == -1) {
                continue;
            }

            studentItem.append(klass.getStudentList().get(index).getName()).append("|")
                    .append(klass.getStudentList().get(index).getScores().get("数学")).append("|")
                    .append(klass.getStudentList().get(index).getScores().get("语文")).append("|")
                    .append(klass.getStudentList().get(index).getScores().get("英语")).append("|")
                    .append(klass.getStudentList().get(index).getScores().get("编程")).append("|")
                    .append(klass.getStudentList().get(index).getAverage()).append("|")
                    .append(klass.getStudentList().get(index).getTotalScore()).append("\n");

        }
        this.studentScoresItem = studentItem.toString();
    }

    private int findStudentById(String id) {
        int index = -1;
        for (int i = 0; i < klass.getStudentList().size(); i++) {
            if (id.equals(klass.getStudentList().get(i).getID())) {
                index = i;
                break;
            }

        }
        return index;
    }

    public void buildReport(List<String> studentIDs) {
        buildStudentItems(studentIDs);

        String report = String.format(Report.getReportTemplate(),
                this.studentScoresItem,
                this.klass.getKlassAverage(),
                this.klass.getKlassMedian());

       View.showReportPage(report);
    }

    public void addStudent(Student student) {
        klass.addStudent(student);
        View.showAddSuccessPage(student);
    }

}
