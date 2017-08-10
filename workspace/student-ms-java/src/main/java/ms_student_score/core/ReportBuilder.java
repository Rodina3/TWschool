package ms_student_score.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by rzhou on 08/08/2017.
 */
public class ReportBuilder {

    private Report report = new Report();
    private ScoresCenter scoresCenter = new ScoresCenter();
    private Klass klass = new Klass();
    private List<Scores> studentScoreItem = new ArrayList<>();

    private void buildStudentScoreItems(List<String> studentIDs) {
        studentScoreItem.clear();
        for (int i = 0; i < studentIDs.size(); i++) {
            int index = scoresCenter.findScoreSheetById(studentIDs.get(i));
            if (index == -1) {
                continue;
            }

            String name = klass.getStudentList().get(klass.findStudentById(studentIDs.get(i))).getName();
            scoresCenter.getScores().get(i).setName(name);
            studentScoreItem.add(scoresCenter.getScores().get(i));
        }
        report.setStudentItem(studentScoreItem);
    }


    private void updateAverage() {
        float average = 0;
        for (Scores scores : this.studentScoreItem) {
            average += scores.getAverage();
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


    public Report buildReport(List<String> studentIDs, ScoresCenter scoresCenter, Klass klass) {
        this.scoresCenter = scoresCenter;
        this.klass = klass;
        buildStudentScoreItems(studentIDs);
        updateAverage();
        updateMedian();
        return this.report;
    }
}


