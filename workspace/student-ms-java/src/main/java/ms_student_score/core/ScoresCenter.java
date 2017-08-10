package ms_student_score.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rzhou on 10/08/2017.
 */
public class ScoresCenter {
    private List<Scores> scores = new ArrayList<>();

    public List<Scores> getScores() {
        return scores;
    }

    public void addScoreSheet(Scores scores) {
        this.scores.add(scores);
    }
    public int findScoreSheetById(String id) {
        int index = -1;
        for (int i = 0; i < this.getScores().size(); i++) {
            if (id.equals(this.getScores().get(i).getId())) {
                index = i;
                break;
            }
        }
        return index;
    }

}
