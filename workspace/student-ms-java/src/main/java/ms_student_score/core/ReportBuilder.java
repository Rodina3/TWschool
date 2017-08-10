package ms_student_score.core;

import javax.persistence.GeneratedValue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by rzhou on 08/08/2017.
 */
public class ReportBuilder {

    private GradeCenter gradeCenter = new GradeCenter();
    private Report report = new Report();
    private List<ScoreSheet> studentScoreItem = new ArrayList<>();

    private void buildStudentScoreItems(List<String> studentIDs) {
        studentScoreItem.clear();
        for (int i = 0; i < studentIDs.size(); i++) {
            int index = gradeCenter.findScoreSheetById(studentIDs.get(i));

            if (index == -1) {
                continue;
            }
            studentScoreItem.add(gradeCenter.getScoreSheet().get(i));
        }
        report.setStudentItem(studentScoreItem);
    }


    private void updateAverage() {
        float average = 0;
        for (ScoreSheet scoreSheet : this.studentScoreItem) {
            average += scoreSheet.getAverage();
        }
        average /= this.studentScoreItem.size();
        report.setAverage(average);
    }

    private void updateMedian() {
        float median = 0;
        List<Integer> totalScoreList = new ArrayList<>();

        if (studentScoreItem.size() == 1) {
            median = studentScoreItem.get(0).getTotalScore();
            report.setMedian(median);
            return;
        }

        for (int i = 0; i < studentScoreItem.size(); i++) {
            totalScoreList.add(studentScoreItem.get(i).getTotalScore());
        }
        Collections.sort(totalScoreList);
        int index = 0;
        if (studentScoreItem.size() % 2 == 0) {
            index = studentScoreItem.size() / 2;
            median = (float) ((studentScoreItem.get(index).getTotalScore() + studentScoreItem.get(index - 1).getTotalScore()) / 2.0);
        } else {
            index = (studentScoreItem.size() - 1) / 2;
            median = studentScoreItem.get(index).getTotalScore();
        }
        report.setMedian(median);
    }


    public Report buildReport(List<String> studentIDs, GradeCenter gradeCenter) {
        this.gradeCenter = gradeCenter;
        buildStudentScoreItems(studentIDs);
        updateAverage();
        updateMedian();
        return this.report;
    }
}
