package ms_student_score.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rzhou on 27/07/2017.
 */
public class Report {

    private List<ScoreSheet> studentItem = new ArrayList<>();
    private float average = 0;
    private float median = 0;

    public List<ScoreSheet> getStudentScoreItem() {
        return studentItem;
    }

    public void setAverage(float average) {
        this.average = average;
    }

    public void setStudentItem(List<ScoreSheet> studentItem) {
        this.studentItem = studentItem;
    }

    public void setMedian(float median) {
        this.median = median;
    }

    public float getAverage() {
        return average;
    }

    public float getMedian() {
        return median;
    }

}
