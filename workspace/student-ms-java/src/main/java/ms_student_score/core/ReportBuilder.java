package ms_student_score.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Created by rzhou on 08/08/2017.
 */
public class ReportBuilder {

    private Report report = new Report();
    private List<Scores> scoresList = new ArrayList<>();
    private List<Student> studentsList = new ArrayList<>();

    private List<Scores> studentScoreItem = new ArrayList<>();

    private void buildStudentScoreItems(List<String> studentIDs) {
        studentScoreItem.clear();
        for (int i = 0; i < studentIDs.size(); i++) {
            int studentIndex = findStudentById(studentIDs.get(i));
            if (studentIndex == -1) {
                continue;
            }

            String name = studentsList.get(studentIndex).getName();
            int scoresIndex = findScoreSheetById(studentsList.get(studentIndex).getId());
            if (scoresIndex == -1){
                scoresList.add(new Scores(studentsList.get(studentIndex).getId(),0,0,0,0));
            }
            scoresIndex = findScoreSheetById(studentsList.get(studentIndex).getId());
            scoresList.get(scoresIndex).setName(name);
            studentScoreItem.add(scoresList.get(scoresIndex));
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

    private int findScoreSheetById(String id) {
        int index = -1;
        for (int i = 0; i < scoresList.size(); i++) {
            if (scoresList.get(i).getId() == id) {
                index = i;
                break;
            }
        }
        return index;
    }


    private int findStudentById(String id) {
        int index = -1;
        for (int i = 0; i < studentsList.size(); i++) {
            if (Objects.equals(studentsList.get(i).getId(), id)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public Report buildReport(List<String> studentIDs, List<Scores> scores, List<Student> students) {
        this.scoresList = scores;
        this.studentsList = students;

        buildStudentScoreItems(studentIDs);
        updateAverage();
        updateMedian();
        return this.report;
    }
}


