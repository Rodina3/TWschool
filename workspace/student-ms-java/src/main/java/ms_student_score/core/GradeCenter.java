package ms_student_score.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rzhou on 10/08/2017.
 */
public class GradeCenter {
    private List<ScoreSheet> scoreSheet = new ArrayList<>();

    public List<ScoreSheet> getScoreSheet() {
        return scoreSheet;
    }

    public void addScoreSheet(ScoreSheet scoreSheet) {
        this.scoreSheet.add(scoreSheet);
    }
    public int findScoreSheetById(String id) {
        int index = -1;
        for (int i = 0; i < this.getScoreSheet().size(); i++) {
            if (id.equals(this.getScoreSheet().get(i).getId())) {
                index = i;
                break;
            }
        }
        return index;
    }

}
