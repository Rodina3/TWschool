import ms_student_score.core.Scores;
import ms_student_score.core.ScoresCenter;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by rzhou on 10/08/2017.
 */
public class ScoresCenterTest {
    @Test
    public void should_add_student_score() throws Exception {
        Scores scores1 = new Scores("000", 100, 100, 85, 100);
        Scores scores2 = new Scores("001", 90, 90, 90, 90);
        ScoresCenter scoresCenter = new ScoresCenter();
        scoresCenter.addScoreSheet(scores1);
        scoresCenter.addScoreSheet(scores2);

        assertThat(scoresCenter.getScores(), is(Arrays.asList(scores1, scores2)));
        assertThat(scoresCenter.getScores().get(0).getEnglish(),is(85));
        assertThat(scoresCenter.getScores().get(0).getTotalScore(),is(385));
        assertThat(scoresCenter.getScores().get(1).getAverage()-90<0.01,is(true));
    }

    @Test
    public void should_find_student_scores_by_id() throws Exception {
        Scores scores1 = new Scores("000", 100, 100, 100, 100);
        Scores scores2 = new Scores("001", 90, 90, 90, 90);
        ScoresCenter scoresCenter = new ScoresCenter();
        scoresCenter.addScoreSheet(scores1);
        scoresCenter.addScoreSheet(scores2);

        assertThat(scoresCenter.getScores().get(scoresCenter.findScoreSheetById("000")), is(scores1));
        assertThat(scoresCenter.findScoreSheetById("002"), is(-1));
    }
}
