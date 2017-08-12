package coreTest;

import ms_student_score.core.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by rzhou on 10/08/2017.
 */
public class ReportBuilderTest {
    @Test
    public void should_build_one_student_score_report() throws Exception {
        Klass klass = new Klass();
        klass.addStudent(new Student("张三", "000", "buaa@163", "123"));

        ScoresCenter scoresCenter = new ScoresCenter();
        Scores scores1 = new Scores("000", 100, 100, 100, 100);

        scoresCenter.addScoreSheet(scores1);
        ReportBuilder reportBuilder = new ReportBuilder();
        List<String> studentIDs = new ArrayList<>();
        studentIDs.add("000");

        Report report = reportBuilder.buildReport(studentIDs, scoresCenter.getScores(), klass.getStudentList());

        assertThat(report.getStudentScoreItem().get(0).getName(), is("张三"));
        assertThat(report.getStudentScoreItem(), is(Arrays.asList(scores1)));
        assertThat(report.getAverage() - 100 < 0.01, is(true));
        assertThat(report.getMedian() - 400 < 0.01, is(true));
    }

    @Test
    public void should_build_two_students_score_report() throws Exception {
        Scores scores1 = new Scores("000", 100, 100, 100, 100);
        Scores scores2 = new Scores("001", 90, 90, 90, 90);
        ScoresCenter scoresCenter = new ScoresCenter();
        scoresCenter.addScoreSheet(scores1);
        scoresCenter.addScoreSheet(scores2);

        Klass klass = new Klass();
        klass.addStudent(new Student("张三", "000", "buaa@163", "123"));
        klass.addStudent(new Student("李四", "001", "buaa@163", "123"));

        ReportBuilder reportBuilder = new ReportBuilder();
        List<String> studentIDs = new ArrayList<>();
        studentIDs.add("000");
        studentIDs.add("001");

        Report report = reportBuilder.buildReport(studentIDs, scoresCenter.getScores(), klass.getStudentList());

        assertThat(report.getStudentScoreItem().get(1).getName(), is("李四"));
        assertThat(report.getAverage() - 95 < 0.01, is(true));
        assertThat(report.getMedian() - 380 < 0.01, is(true));
        assertThat(report.getStudentScoreItem(), is(Arrays.asList(scores1, scores2)));
    }
}
