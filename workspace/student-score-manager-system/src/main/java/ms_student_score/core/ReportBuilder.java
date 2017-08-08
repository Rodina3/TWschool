package ms_student_score.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by rzhou on 08/08/2017.
 */
public class ReportBuilder {
    Klass klass = new Klass();
    private Report report = new Report();
    private List<Student> studentItem = new ArrayList<>();

    private void buildStudentItems(List<String> studentIDs) {
        studentItem.clear();
        for (int i = 0; i < studentIDs.size(); i++) {
            int index = findStudentById(studentIDs.get(i));

            if (index == -1) {
                continue;
            }
            studentItem.add(klass.getStudentList().get(i));
        }
        report.setStudentItem(studentItem);
    }


    private void updateAverage() {
        float average = 0;
        for (Student stu : this.studentItem) {
            average += stu.getAverage();
        }
        average /= this.studentItem.size();
        report.setAverage(average);
    }

    private void updateMedian() {
        float median = 0;
        List<Integer> totalScoreList = new ArrayList<>();

        if (studentItem.size() == 1) {
            median = studentItem.get(0).getTotalScore();
            report.setMedian(median);
            return;
        }

        for (int i = 0; i < studentItem.size(); i++) {
            totalScoreList.add(studentItem.get(i).getTotalScore());
        }
        Collections.sort(totalScoreList);
        int index = 0;
        if (studentItem.size() % 2 == 0) {
            index = studentItem.size() / 2;
            median = (float) ((studentItem.get(index).getTotalScore() + studentItem.get(index - 1).getTotalScore()) / 2.0);
        } else {
            index = (studentItem.size() - 1) / 2;
            median = studentItem.get(index).getTotalScore();
        }
        report.setMedian(median);
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

    public Report buildReport(List<String> studentIDs, Klass klass) {
        this.klass = klass;
        buildStudentItems(studentIDs);
        updateAverage();
        updateMedian();
        return this.report;
    }
}
